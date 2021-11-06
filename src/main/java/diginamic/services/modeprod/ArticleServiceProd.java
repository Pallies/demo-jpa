package diginamic.services.modeprod;

import java.util.List;

import javax.persistence.TypedQuery;

import diginamic.connection.EntityManagerRef;
import diginamic.entities.Article;
import diginamic.services.ArticleService;

/**
 * The Class ArticleService.
 */
public class ArticleServiceProd extends ArticleService {

	/**
	 * Insert.
	 *
	 * @param article the article
	 * @return the article
	 */
	@Override
	public Article insert(Article article) {
		setEm(EntityManagerRef.getInstance());
		Article articleRef = searchIdOrTitre(article);
		if (articleRef == null) {
			em.getTransaction().begin();
			em.persist(article);
			em.getTransaction().commit();
		}
		em.close();
		return searchIdOrTitre(article);
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Override
	public List<Article> findAll() {
		setEm(EntityManagerRef.getInstance());
		List<Article> articles = em.createQuery("FROM Article as a", Article.class).getResultList();
		em.close();
		return articles;
	}

	/**
	 * Find.
	 *
	 * @param article the article
	 * @return the article
	 */
	@Override
	public Article find(Article article) {
		setEm(EntityManagerRef.getInstance());
		TypedQuery<Article> qry = em.createQuery("SELECT a FROM Article as a WHERE ref= :ref", Article.class);
		Article articleRef = qry.setParameter("ref", article.getRef()).getSingleResult();
		em.close();
		return articleRef;
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the article
	 */
	@Override
	public Article findById(Integer id) {
		setEm(EntityManagerRef.getInstance());
		Article articleRef = em.find(Article.class, id);
		em.close();
		return articleRef;
	}

	/**
	 * Update.
	 *
	 * @param article1 the article 1
	 * @param article2 the article 2
	 * @return the article
	 */
	@Override
	public Article update(Article article1, Article article2) {
		setEm(EntityManagerRef.getInstance());
		Article articleRef = searchIdOrTitre(article1);
		if (articleRef != null) {
			article2.setId(articleRef.getId());
			em.getTransaction().begin();
			articleRef = em.merge(article2);
			em.getTransaction().commit();
		}
		em.close();
		return articleRef;
	}

	/**
	 * Delete.
	 *
	 * @param article the article
	 * @return the article find in database
	 */
	@Override
	public Article delete(Article article) {
		setEm(EntityManagerRef.getInstance());
		Article articleRef = searchIdOrTitre(article);
		if (articleRef != null) {
			em.getTransaction().begin();
			em.remove(articleRef);
			em.getTransaction().commit();
		}
		em.close();
		return articleRef;
	}

}

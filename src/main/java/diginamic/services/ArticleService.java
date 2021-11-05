package diginamic.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import diginamic.connection.EntityManagerRef;
import diginamic.entities.Article;
import diginamic.services.dao.IArticleDao;

/**
 * The Class ArticleService.
 */
public class ArticleService implements IArticleDao {

	/** The em. */
	private static EntityManager em;

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
		return null;
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Override
	public List<Article> findAll() {
		setEm(EntityManagerRef.getInstance());
		TypedQuery<Article> qry = em.createQuery("SELECT a FROM Article as a", Article.class);
		return qry.getResultList();
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
		qry.setParameter("ref", article.getRef());
		return qry.getSingleResult();
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
		return em.find(Article.class, id);
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
			em.merge(article2);
			em.getTransaction().commit();
		}
		return findById(articleRef.getId());
	}

	/**
	 * Delete.
	 *
	 * @param article the article
	 * @return the article
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
		return articleRef;
	}

	/**
	 * Sets the em.
	 *
	 * @param em the new em
	 */
	private static void setEm(EntityManager em) {
		ArticleService.em = em;
	}

	/**
	 * Search id or titre.
	 *
	 * @param article the article
	 * @return the article
	 */
	private Article searchIdOrTitre(Article article) {
		if (article.getId() != null)
			return findById(article.getId());
		else
			return find(article);
	}
}

package diginamic.services.modedev;

import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import diginamic.connection.EntityManagerRef;
import diginamic.entities.Article;
import diginamic.services.ArticleService;

/**
 * The Class ArticleService.
 */
public class ArticleServiceDev extends ArticleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceDev.class);
	private static final String TRANSACTION_BEGIN;
	private static final String TRANSACTION_COMMIT;

	static {
		ResourceBundle props = ResourceBundle.getBundle("developpement");
		TRANSACTION_BEGIN = props.getString("ET_BEGIN");
		TRANSACTION_COMMIT = props.getString("ET_COMMIT");
	}

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
			LOGGER.info(TRANSACTION_BEGIN);
			em.getTransaction().begin();
			em.persist(article);
			em.getTransaction().commit();
			LOGGER.info(TRANSACTION_COMMIT);
		}
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
		return em.createQuery("FROM Article as a", Article.class).getResultList();
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
		TypedQuery<Article> qry = em.createQuery("FROM Article as a WHERE ref= :ref", Article.class);
		return qry.setParameter("ref", article.getRef()).getResultStream().findFirst().orElse(null);
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
			LOGGER.info(TRANSACTION_BEGIN);
			em.getTransaction().begin();
			articleRef = em.merge(article2);
			em.getTransaction().commit();
			LOGGER.info(TRANSACTION_COMMIT);
		}
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
			LOGGER.info(TRANSACTION_BEGIN);
			em.getTransaction().begin();
			em.remove(articleRef);
			em.getTransaction().commit();
			LOGGER.info(TRANSACTION_COMMIT);
		}
		return articleRef;
	}

}

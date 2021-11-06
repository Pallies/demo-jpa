package diginamic.services;

import javax.persistence.EntityManager;

import diginamic.entities.Article;
import diginamic.services.dao.IArticleDao;

public abstract class ArticleService  implements IArticleDao{

	/** The em. */
	protected static EntityManager em;
	
	/**
	 * Sets the em.
	 *
	 * @param em the new em
	 */
	protected static void setEm(EntityManager em) {
		ArticleService.em = em;
	}

	/**
	 * Search id or titre.
	 *
	 * @param article the article
	 * @return the article
	 */
	protected Article searchIdOrTitre(Article article) {
		if (article.getId() != null)
			return findById(article.getId());
		else
			return find(article);
	}

}

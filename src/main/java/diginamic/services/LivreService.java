package diginamic.services;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import diginamic.entities.Livre;
import diginamic.services.dao.ILivreDao;

/**
 * The Class LivreService.
 */
public abstract class LivreService implements ILivreDao{

	/** The em. */
	protected static EntityManager em;

private static final Logger LOGGER = LoggerFactory.getLogger(LivreService.class);
	/**
	 * Sets the em.
	 *
	 * @param em the new em
	 */
	protected static void setEm(EntityManager em) {
		LivreService.em = em;
		LOGGER.info("CREATE ENTITY MANAGER <-----------------------------------------------------");
	}

	/**
	 * Search id or titre.
	 *
	 * @param livre the livre
	 * @return the livre
	 */
	protected Livre searchIdOrTitre(Livre livre) {
		if (livre.getId() != null)
			return findById(livre.getId());
		else
			return find(livre);
	}

}

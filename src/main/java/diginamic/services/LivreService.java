package diginamic.services;

import javax.persistence.EntityManager;

import diginamic.entities.Livre;
import diginamic.services.dao.ILivreDao;

/**
 * The Class LivreService.
 */
public abstract class LivreService implements ILivreDao{

	/** The em. */
	protected static EntityManager em;

	/**
	 * Sets the em.
	 *
	 * @param em the new em
	 */
	protected static void setEm(EntityManager em) {
		LivreService.em = em;
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

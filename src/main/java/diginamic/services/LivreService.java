package diginamic.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import diginamic.connection.EntityManagerRef;
import diginamic.entities.Livre;
import diginamic.services.dao.ILivreDao;

/**
 * The Class LivreService.
 */
public final class LivreService implements ILivreDao {

	/** The em. */
	private static EntityManager em;

	/**
	 * Insert.
	 *
	 * @param livre the livre
	 * @return the livre
	 */
	@Override
	public Livre insert(Livre livre) {
		setEm(EntityManagerRef.getInstance());
		Livre livreRef = find(livre);
		if (livreRef == null) {
			em.getTransaction().begin();
			em.persist(livre);
			em.getTransaction().commit();
		}
		return find(livre);
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Override
	public List<Livre> findAll() {
		setEm(EntityManagerRef.getInstance());
		TypedQuery<Livre> livres = em.createQuery("SELECT l FROM Livre as l", Livre.class);
		return livres.getResultList();
	}

	/**
	 * Find.
	 *
	 * @param livre the livre
	 * @return the livre
	 */
	@Override
	public Livre find(Livre livre) {
		setEm(EntityManagerRef.getInstance());
		TypedQuery<Livre> qry = em.createQuery("SELECT l FROM Livre as l WHERE l.titre= :titre", Livre.class);
		qry.setParameter("titre", livre.getTitre());
		return qry.getSingleResult();
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the livre
	 */
	@Override
	public Livre findById(Integer id) {
		setEm(EntityManagerRef.getInstance());
		return em.find(Livre.class, id);
	}

	/**
	 * Update.
	 *
	 * @param livre1 the livre 1
	 * @param livre2 the livre 2
	 * @return the livre
	 */
	@Override
	public Livre update(Livre livre1, Livre livre2) {
		setEm(EntityManagerRef.getInstance());
		Livre livreRef = searchIdOrTitre(livre1);

		if (livreRef != null) {
			livre2.setId(livreRef.getId());
			em.getTransaction().begin();
			em.merge(livre2);
			em.getTransaction().commit();
		}
		return findById(livre2.getId());
	}

	/**
	 * Delete.
	 *
	 * @param livre the livre
	 * @return the livre
	 */
	@Override
	public Livre delete(Livre livre) {
		setEm(EntityManagerRef.getInstance());
		Livre livreRef = searchIdOrTitre(livre);

		em.getTransaction().begin();
		em.remove(livreRef);
		em.getTransaction().commit();
		return null;
	}

	/**
	 * Sets the em.
	 *
	 * @param em the new em
	 */
	private static void setEm(EntityManager em) {
		LivreService.em = em;
	}

	/**
	 * Search id or titre.
	 *
	 * @param livre the livre
	 * @return the livre
	 */
	private Livre searchIdOrTitre(Livre livre) {
		if (livre.getId() != null)
			return findById(livre.getId());
		else
			return find(livre);
	}
}

package diginamic.services.modedev;

import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import diginamic.connection.EntityManagerRef;
import diginamic.entities.Livre;
import diginamic.services.LivreService;

/**
 * The Class LivreService.
 */
public final class LivreServiceDev extends LivreService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LivreServiceDev.class);
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
	 * @param livre the livre
	 * @return the livre
	 */
	@Override
	public Livre insert(Livre livre) {
		setEm(EntityManagerRef.getInstance());
		Livre livreRef = find(livre);
		if (livreRef == null) {
			LOGGER.info(TRANSACTION_BEGIN);
			em.getTransaction().begin();
			em.persist(livre);
			em.getTransaction().commit();
			LOGGER.info(TRANSACTION_COMMIT);
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
		return em.createQuery("FROM Livre", Livre.class).getResultList();
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
		return qry.setParameter("titre", livre.getTitre())
				.getResultStream()
				.findFirst()
				.orElse(null);
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
			LOGGER.info(TRANSACTION_BEGIN);
			em.getTransaction().begin();
			livreRef = em.merge(livre2);
			em.getTransaction().commit();
			LOGGER.info(TRANSACTION_COMMIT," livre --> {}",livreRef);
		}
		return livreRef;
	}

	/**
	 * Delete.
	 *
	 * @param livre the livre
	 * @return the livre find in dataBase
	 */
	@Override
	public Livre delete(Livre livre) {
		setEm(EntityManagerRef.getInstance());
		Livre livreRef = searchIdOrTitre(livre);
		LOGGER.info(TRANSACTION_BEGIN);
		em.getTransaction().begin();
		em.remove(livreRef);
		em.getTransaction().commit();
		LOGGER.info(TRANSACTION_COMMIT);
		return livreRef;
	}

}

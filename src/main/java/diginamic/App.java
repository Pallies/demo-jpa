package diginamic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import diginamic.entities.Livre;
import diginamic.services.LivreService;
import diginamic.services.dao.ILivreDao;
import diginamic.services.factory.LivreServiceFactory;

public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		new LivreServiceFactory();
		LivreServiceFactory t = new LivreServiceFactory();
		LivreService test = t.builder();
		List<Livre> livres1 = test.findAll();

		for (Livre l : livres1) {
			System.out.println(l);
		}

		Livre livreNew = new Livre();
//		livreNew.setAuteur("R.KOONTZ");
//		livreNew.setTitre("Chasse à mort");
		livreNew.setTitre("Germinal");
//		test.insert(livreNew);

LOGGER.info(test.find(livreNew)+" <-----------------------------------------------------");
List<Livre> livres2 = test.findAll();

		for (Livre l : livres2) {
			System.out.println(l);
		}

//		Livre livre=new Livre();
//		livre.setTitre("Chasse à mort");
//		livre.setAuteur("R.KOONTZ");
//		test.delete(livre);
//		Livre livre2=new Livre();
//		livre2.setTitre("Chasse à mort");
//		livre2.setAuteur("Dupont");
//		test.update(livre,livre2);
//		
//		List<Livre> livres3 = test.findAll();
//		
//		for(Livre l:livres3) {
//			System.out.println(l);
//		}

//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-hibernate");
//		EntityManager em = emf.createEntityManager();
//		System.out.println(em);
//		Livre livre = em.find(Livre.class, 1);
//		System.out.println(livre);
//		
//		
//		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
//		TypedQuery<Livre> livreRef =em.createQuery("SELECT l FROM Livre l WHERE l.titre='1001 recettes de Cuisine'",Livre.class);
//		Livre livreDeCuisine = livreRef.getResultList().get(0);
//		
//		livreDeCuisine.setTitre("Du plaisir dans la cuisine");
//		em.merge(livreDeCuisine);
//		
//		transaction.commit();
//		
//		em.close();
//		emf.close();
		LOGGER.info("Hello, world!!");
	}

}

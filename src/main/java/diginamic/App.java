package diginamic;

import java.util.List;

import diginamic.services.factory.ArticleServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import diginamic.entities.Livre;
import diginamic.services.LivreService;
import diginamic.services.factory.LivreServiceFactory;

public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		new LivreServiceFactory();
		LOGGER.info("createFactory");
		LivreServiceFactory livreFactory = new LivreServiceFactory();
		ArticleServiceFactory aticleFactory= new ArticleServiceFactory();
		LivreService livreService = livreFactory.builder();
		List<Livre> livres1 = livreService.findAll();
		for (Livre l : livres1) {
			System.out.println(l);
		}

		LOGGER.info("insertion d'un nouveau livre");
		Livre livreNew = new Livre();
		livreNew.setAuteur("R.KOONTZ");
		livreNew.setTitre("Chasse à mort");
//		livreNew.setTitre("Germinal");
		livreService.insert(livreNew);

		LOGGER.info("Retrouver le livre nouvellement inséré");
		livreService.find(livreNew);
		List<Livre> livres2 = livreService.findAll();

		for (Livre l : livres2) {
			System.out.println(l);
		}
		LOGGER.info("suppression du livre inséré");
		Livre livre=new Livre();
		livre.setTitre("Chasse à mort");
		livre.setAuteur("R.KOONTZ");
		livreService.delete(livre);
//		Livre livre2=new Livre();
//		livre2.setTitre("Chasse à mort");
//		livre2.setAuteur("Dupont");
//		livreService.update(livre,livre2);
//
	}

}

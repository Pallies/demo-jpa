package diginamic.services.factory;

import diginamic.services.LivreService;
import diginamic.services.modedev.LivreServiceDev;
import diginamic.services.modeprod.LivreServiceProd;

/**
 * A factory for creating LivreService objects.
 */
public class LivreServiceFactory extends ServiceFactory<LivreService>{

	
	/**
	 * Gets the instance dev.
	 *
	 * @return the instance dev
	 */
	@Override
	protected  LivreService getInstanceDev() {
		return new LivreServiceDev();
	}
	
	/**
	 * Gets the instance prod.
	 *
	 * @return the instance prod
	 */
	@Override
	protected  LivreService getInstanceProd() {
		return new LivreServiceProd();
	}

}

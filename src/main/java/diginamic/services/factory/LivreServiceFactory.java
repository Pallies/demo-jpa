package diginamic.services.factory;

import diginamic.services.LivreService;

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
		return new LivreService();
	}
	
	/**
	 * Gets the instance test.
	 *
	 * @return the instance test
	 */
	@Override
	protected  LivreService getInstanceTest() {
		return new LivreService();
	}
	
	/**
	 * Gets the instance prod.
	 *
	 * @return the instance prod
	 */
	@Override
	protected  LivreService getInstanceProd() {
		return new LivreService();
	}

}

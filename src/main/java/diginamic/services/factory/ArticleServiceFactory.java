package diginamic.services.factory;

import diginamic.services.ArticleService;

/**
 * A factory for creating ArticleService objects.
 */
public class ArticleServiceFactory extends ServiceFactory<ArticleService>{

	
	/**
	 * Gets the instance dev.
	 *
	 * @return the instance dev
	 */
	@Override
	protected  ArticleService getInstanceDev() {
		return new ArticleService();
	}
	
	/**
	 * Gets the instance test.
	 *
	 * @return the instance test
	 */
	@Override
	protected  ArticleService getInstanceTest() {
		return new ArticleService();
	}
	
	/**
	 * Gets the instance prod.
	 *
	 * @return the instance prod
	 */
	@Override
	protected  ArticleService getInstanceProd() {
		return new ArticleService();
	}

}

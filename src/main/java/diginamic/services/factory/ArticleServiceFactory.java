package diginamic.services.factory;

import diginamic.services.ArticleService;
import diginamic.services.modedev.ArticleServiceDev;
import diginamic.services.modeprod.ArticleServiceProd;

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
		return new ArticleServiceDev();
	}
	
	/**
	 * Gets the instance prod.
	 *
	 * @return the instance prod
	 */
	@Override
	protected  ArticleService getInstanceProd() {
		return new ArticleServiceProd();
	}

}

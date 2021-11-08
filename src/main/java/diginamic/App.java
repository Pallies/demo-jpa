package diginamic;

import java.util.List;

import diginamic.entities.Article;
import diginamic.services.ArticleService;
import diginamic.services.factory.ArticleServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {


        LOGGER.info("createFactory");

        ArticleServiceFactory aticleFactory = new ArticleServiceFactory();
        ArticleService articleService = aticleFactory.builder();

        List<Article> articles = articleService.findAll();
        for (Article article : articles) {
            System.out.println(article);
        }
    }

}

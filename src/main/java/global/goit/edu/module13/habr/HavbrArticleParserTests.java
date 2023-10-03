package global.goit.edu.module13.habr;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HavbrArticleParserTests {

    public static void main(String[] args) throws IOException {
        String url = "https://habr.com/ru/articles/";

        Document document = Jsoup.connect(url).get();

        Elements articles = document.selectFirst("div.tm-articles-list").select("article");

        for (Element article : articles) {
            HabrArticleParsers habrArticleParsers = new HabrArticleParsers(article);
            String title = habrArticleParsers.getTitle(article);
            int rating = habrArticleParsers.getRating();
            System.out.println("Title - " + title + ", rating - " + rating);
        }

    }

}

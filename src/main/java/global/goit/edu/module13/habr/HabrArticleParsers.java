package global.goit.edu.module13.habr;

import org.jsoup.nodes.Element;

public class HabrArticleParsers {

    private Element article;

    public HabrArticleParsers (Element article) {
        this.article = article;
    }

    public String getTitle (Element article) {
        return article.getElementsByTag("h2").first().text();
    }

    public int getRating () {
        String text = article
                .selectFirst("div.tm-votes-meter")
                .selectFirst("span.tm-votes-meter__value")
                .text();
        return Integer.parseInt(text.replace("+", ""));

    }

}

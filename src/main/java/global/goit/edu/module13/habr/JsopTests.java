package global.goit.edu.module13.habr;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class JsopTests {

    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("https://habr.com/ru/articles/").get();

        Element head = document.getElementsByTag("head").first();

        Elements title = head.getElementsByTag("title");

        System.out.println("title.text() = " + title.text());


    }



}

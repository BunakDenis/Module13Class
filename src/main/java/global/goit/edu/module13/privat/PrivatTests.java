package global.goit.edu.module13.privat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class PrivatTests {

    public static void main(String[] args) throws IOException {
        String url = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";

        String text = Jsoup.connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type type = TypeToken.getParameterized(List.class, CurrencyItem.class).getType();
        Gson gson = new Gson();
        List<CurrencyItem> currencyItems = gson.fromJson(text, type);

        for (CurrencyItem currencyItem : currencyItems) {
            System.out.println(currencyItem);
        }

        Float aFloat = currencyItems
                .stream()
                .filter(it -> it.getCcy() == CurrencyItem.CCY.USD)
                .filter(it -> it.getBase_ccy() == CurrencyItem.CCY.UAH)
                .map(it -> it.getBuy())
                .findFirst()
                .orElseThrow();

        System.out.println("UAH - USD = " + aFloat);

    }

}

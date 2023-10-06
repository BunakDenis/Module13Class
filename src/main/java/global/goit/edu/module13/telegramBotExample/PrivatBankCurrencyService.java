package global.goit.edu.module13.telegramBotExample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import global.goit.edu.module13.privat.CurrencyItem;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class PrivatBankCurrencyService implements CurrencyService {


    @Override
    public double getRate(Currency currency) {
        String url = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";

        String text;
        try {
            text = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();
        } catch (IOException e) {
           throw new IllegalStateException("Can't connect to Privat API");
        }

        Type type = TypeToken.getParameterized(List.class, CurrencyItem.class).getType();
        Gson gson = new Gson();
        List<CurrencyItem> currencyItems = gson.fromJson(text, type);

        for (CurrencyItem currencyItem : currencyItems) {
            System.out.println(currencyItem);
        }

        Float aFloat = currencyItems
                .stream()
                .filter(it -> it.getCcy() == currency)
                .filter(it -> it.getBase_ccy() == Currency.UAH)
                .map(CurrencyItem::getBuy)
                .findFirst()
                .orElseThrow();

        System.out.println("UAH - " + currency + " = " + aFloat);


return aFloat;
    }
}

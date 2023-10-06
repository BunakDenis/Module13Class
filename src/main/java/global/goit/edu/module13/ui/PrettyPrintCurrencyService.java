package global.goit.edu.module13.ui;

import global.goit.edu.module13.telegramBotExample.Currency;

public class PrettyPrintCurrencyService {

    public String convert (double rate, Currency currency) {
        String template = "Курс ${currency} => UAH = ${rate}";
        return template
                .replace("${currency}", currency.name())
                .replace("${rate}", Double.toString(rate));
    }

}

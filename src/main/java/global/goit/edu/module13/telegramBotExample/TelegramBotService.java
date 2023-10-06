package global.goit.edu.module13.telegramBotExample;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TelegramBotService {
    private CurrencyTelegramBot currencyTelegramBot;
    public TelegramBotService() {
        currencyTelegramBot = new CurrencyTelegramBot();
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot((LongPollingBot) currencyTelegramBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

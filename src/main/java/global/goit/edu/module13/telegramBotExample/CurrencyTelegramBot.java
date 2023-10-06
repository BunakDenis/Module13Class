package global.goit.edu.module13.telegramBotExample;
import global.goit.edu.module13.telegramBotExample.Command.StartCommand;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CurrencyTelegramBot {


public CurrencyTelegramBot () {

}

    public void processNonCommandUpdate(Update update) {

    }

    public String getBotToken () {
        return BotConstans.BOT_TOKEN;
    }

}
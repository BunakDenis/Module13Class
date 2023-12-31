package global.goit.edu.module13.telegramBotExample.Command;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.CommandRegistry;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class StartCommand extends BotCommand {
    public StartCommand() {
        super("start", "Start command");
    }
    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        System.out.println("Start pressed!");
    }
}

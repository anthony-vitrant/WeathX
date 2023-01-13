import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TelegramBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "SDE_Project";
    }

    @Override
    public String getBotToken() {
        return "5861282054:AAGoZM6f9h5a8vXxgMC-UV5JTgCx0GJb-EA";
    }

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            SendMessage message = new SendMessage();
            if (messageText.startsWith("/")){
                String[] commandAndArgs = messageText.split(" ");
                String command = commandAndArgs[0];
                message.setChatId(update.getMessage().getChatId().toString());
                if (command.equals("/hotels")) {
                    String location = commandAndArgs[1];
                    // Retreive data from the AP and met en forme le texte pour l'envoyer

                }else if (command.equals("/restaurants")) {
                    String location = commandAndArgs[1];
                    // Retreive data from the AP and met en forme le texte pour l'envoyer

                }else if (command.equals("/parking")) {
                    String location = commandAndArgs[1];
                    // Retreive data from the AP and met en forme le texte pour l'envoyer

                }else if (command.equals("/gasstations")) {
                    String location = commandAndArgs[1];
                    // Retreive data from the AP and met en forme le texte pour l'envoyer
                }else{
                    message.setText(update.getMessage().getText()+" is not a valid command");
                    message.setText("Valid commands are: /hotels 'City name' , /restaurants 'City name', /parking 'City name', /gasstations 'City name'");
                }
            }else{
                message.setText(update.getMessage().getText()+" is not a command");
                message.setText("Valid commands are: /hotels 'City name' , /restaurants 'City name', /parking 'City name', /gasstations 'City name'");
            }
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TelegramBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

package View;

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
        System.out.println(update.getMessage().getText());
        if (update.hasMessage() && update.getMessage().hasText()) {

            String messageText = update.getMessage().getText();
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());

            if (messageText.startsWith("/")){

                String[] commandAndArgs = messageText.split(" ");
                String command = commandAndArgs[0];

                if (command.equals("/hotels")) {
                    String location = commandAndArgs[1];
                    message.setText("Searching for Hotels in "+location);

                }else if (command.equals("/restaurants")) {
                    String location = commandAndArgs[1];
                    // Retreive data from the AP and met en forme le texte pour l'envoyer
                    message.setText("Searching for Restaurants in "+location);

                }else if (command.equals("/parking")) {
                    String location = commandAndArgs[1];
                    // Retreive data from the AP and met en forme le texte pour l'envoyer
                    message.setText("Searching for Parking in "+location);

                }else if (command.equals("/gasstations")) {
                    String location = commandAndArgs[1];
                    // Retreive data from the AP and met en forme le texte pour l'envoyer
                    message.setText("Searching for Gas Stations in "+location);

                }else{
                    message.setText("'"+update.getMessage().getText()+"' is not a valid command  \nValid commands are: /hotels 'City name' , /restaurants 'City name', /parking 'City name', /gasstations 'City name'");
                }
            }else{
                message.setText("'"+update.getMessage().getText()+"' is not a command  \nCommands are: /hotels 'City name' , /restaurants 'City name', /parking 'City name', /gasstations 'City name'");
            }
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}

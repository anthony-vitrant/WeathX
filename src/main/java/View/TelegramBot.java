package View;

import Controller.Controller;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

public class TelegramBot extends TelegramLongPollingBot {
    Controller controller = new Controller();

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

                if (commandAndArgs[1] == " " || commandAndArgs[1] == null){
                    message.setText("Please enter a location");
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                if (command.equals("/hotels")) {
                    String location = commandAndArgs[1];
                    message.setText("Searching for Hotels in "+location);
                    try {
                        execute(message);
                        message.setText(controller.getHotelsByCityName(location));
                    } catch (TelegramApiException | IOException | InterruptedException e) {
                        e.printStackTrace();
                    }

                }else if (command.equals("/restaurants")) {
                    String location = commandAndArgs[1];
                    message.setText("Searching for Restaurants in "+location);
                    try {
                        execute(message);
                        message.setText(controller.getRestaurantsByCityName(location));
                    } catch (TelegramApiException | IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }else if (command.equals("/museums")) {
                    String location = commandAndArgs[1];
                    message.setText("Searching for Museums in "+location);
                    try {
                        execute(message);
                        message.setText(controller.getMuseumsByCityName(location));
                    } catch (TelegramApiException | IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }else if (command.equals("/parkings")) {
                    String location = commandAndArgs[1];
                    message.setText("Searching for Parking in "+location);
                    try {
                        execute(message);
                        message.setText(controller.getParkingsByCityName(location));
                    } catch (TelegramApiException | IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }else if (command.equals("/gasstations")) {
                    String location = commandAndArgs[1];
                    message.setText("Searching for Gas Stations in "+location);
                    try {
                        execute(message);
                        message.setText(controller.getGasStationsByCityName(location));
                    } catch (TelegramApiException | IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
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

package Model;

import java.io.IOException;
import java.util.List;

public class HotelParser implements Parser {
    String HotelJson;
    String WeatherMessage;
    String Message;
    @Override
    public String parseJson(List<String> latlon) throws IOException, InterruptedException {
        WeatherMessage = new WeatherParser().parseJson(latlon);
        HotelJson = new OpenStreetMapAPI().getHotelsByLatLon(latlon.get(0), latlon.get(1));
        //TODO
        //parse the json to get the display name
        // and return the WeatherMessage + the Message with the display name (5 max)
        // like return WeatherMessage +"\n"+ Message;
        return null;
    }
}

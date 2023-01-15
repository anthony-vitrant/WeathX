package Model;

import java.io.IOException;
import java.util.List;

public class WeatherParser implements Parser {
    String WeatherJson;
    String WeatherMessage;
    String main;
    String temp;
    @Override
    public String parseJson(List<String> latlon) throws IOException, InterruptedException {
        WeatherJson = new WeatherAPI().GetWeatherByLatLon(latlon.get(0), latlon.get(1));

        //split the json to get the weather message
        main = WeatherJson.substring(WeatherJson.indexOf("description")+14);
        main = main.split("\"")[0];
        System.out.println(main);

        //split the json to get the temperature
        temp = WeatherJson.substring(WeatherJson.indexOf("temp")+6);
        temp = temp.split(",")[0];
        System.out.println(temp);

        WeatherMessage = "The weather is "+main+" and the temperature is "+temp+"°C";
        return WeatherMessage;
    }
}

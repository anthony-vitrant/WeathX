package Model;

import java.io.IOException;
import java.util.List;

public class WeatherParser implements Parser {
    String WeatherJson;
    String WeatherMessage;
    @Override
    public String parseJson(List<String> latlon) throws IOException, InterruptedException {
        WeatherJson = new WeatherAPI().GetWeatherByLatLon(latlon.get(0), latlon.get(1));


        return null;
    }
}

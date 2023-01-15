package Model;

import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HotelParser implements Parser {
    String HotelJson;
    String WeatherMessage;
    String HotelMessage;
    @Override
    public String parseJson(List<String> latlon) throws IOException, InterruptedException {

        WeatherMessage = new WeatherParser().parseJson(latlon);
        HotelJson = new OpenStreetMapAPI().getHotelsByLatLon(latlon.get(0), latlon.get(1));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(HotelJson);

        int counter = 0;
        for (JsonNode node : jsonNode) {
            String displayName = node.get("display_name").asText();

            int commaIndex = displayName.indexOf(",");
            String shortenedString;
            if (commaIndex != -1) {
                shortenedString = displayName.substring(0, commaIndex);
            } else {
                shortenedString = displayName;
            }
            HotelMessage += shortenedString + "\n";
            System.out.println(shortenedString);
            counter++;
            if (counter == 5) { //5times max
                break;
            }
        }

        System.out.println(HotelMessage);
        return WeatherMessage + "\n" + HotelMessage;
    }
}

package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class RestaurantParser implements Parser{
    String RestaurantJson;
    String WeatherMessage;
    String RestaurantMessage="Restaurants :\n";
    @Override
    public String parseJson(List<String> latlon) throws IOException, InterruptedException {
        WeatherMessage = new WeatherParser().parseJson(latlon);
        RestaurantJson = new OpenStreetMapAPI().getRestaurantsByLatLon(latlon.get(0), latlon.get(1));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(RestaurantJson);

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
            RestaurantMessage += "- "+shortenedString + "\n";
            System.out.println(shortenedString);
            counter++;
            if (counter == 5) { //5times max
                break;
            }
        }
        return WeatherMessage + "\n" + RestaurantMessage;
    }
}

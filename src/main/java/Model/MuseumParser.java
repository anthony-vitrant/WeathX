package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class MuseumParser implements Parser{
    String MuseumJson;
    String WeatherMessage;
    String MuseumMessage="Museums :\n";
    @Override
    public String parseJson(List<String> latlon) throws IOException, InterruptedException {
        WeatherMessage = new WeatherParser().parseJson(latlon);
        MuseumJson = new OpenStreetMapAPI().getMuseumsByLatLon(latlon.get(0), latlon.get(1));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(MuseumJson);

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
            MuseumMessage += "- "+shortenedString + "\n";
            System.out.println(shortenedString);
            counter++;
            if (counter == 5) { //5times max
                break;
            }
        }
        return WeatherMessage + "\n" + MuseumMessage;
    }
}

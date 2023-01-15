package Model;

import java.io.IOException;
import java.util.List;

public interface Parser {
    public String parseJson(List<String> latlon) throws IOException, InterruptedException;
}

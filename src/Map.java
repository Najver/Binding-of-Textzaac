import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Map {
    private Room[][] rooms;

    public Map()
    {
        this.rooms = loadRoomsFromFile();
    }

    private Room[][] loadRoomsFromFile()
    {
        Room[][] rooms = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Map1.mp")))
        {
            StringBuilder stringBuilder = new StringBuilder();
            int numberOfLines = 0;
            int numberOfRows = 0;
            boolean isFirstLine = true;
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                if (isFirstLine)
                {
                    numberOfRows = line.toCharArray().length;
                    isFirstLine = false;
                }
                stringBuilder.append(line).append("\n");
            }

        }
        catch (IOException ioException)
        {

        }
        return rooms;
    }
}

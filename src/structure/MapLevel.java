package structure;

import util.WrongMapFormatException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MapLevel {

    private Room[][] rooms;

    private int[] playerCurrentCoordinates;

    private Room spawnRoom;

    public MapLevel(String nameOfTheMap)
    {
        this.playerCurrentCoordinates = new int[2];
        this.rooms = loadRoomsFromFile(nameOfTheMap);
    }

    private Room[][] loadRoomsFromFile(String nameOfTheMap)
    {
        Room[][] rooms = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nameOfTheMap + ".maap")))
        {
            StringBuilder stringBuilder = new StringBuilder();
            int numberOfCollumns = 0;
            int numberOfRows = 0;
            boolean isFirstLine = true;
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                if (isFirstLine)
                {
                    numberOfCollumns = line.toCharArray().length;
                    isFirstLine = false;
                }
                stringBuilder.append(line).append("\n");
                numberOfRows++;
            }
            rooms = new Room[numberOfRows][numberOfCollumns];
            this.rooms = rooms;
            String[] s = stringBuilder.toString().split("\n");
            for (int i = 0; i < s.length; i++) {
                if (s[i].isBlank())
                    throw new WrongMapFormatException("Part of the map has blank space \nstructure.Map:\n" + stringBuilder);
                generateRoomInRow(s[i],rooms,i);
            }
            /*printMap();*/
        }
        catch (IOException ignored)
        {

        }
        return rooms;
    }
    private void generateRoomInRow(String s,Room[][] rooms,int rowIndex){
       char[] charsInString = s.toCharArray();
        for (int i = 0; i < charsInString.length; i++) {
            switch (charsInString[i])
            {
                case '*' -> rooms[rowIndex][i] = null;
                case '+' -> rooms[rowIndex][i] = new Room("Room" + (i + 1), rowIndex, i);
                case '$' -> rooms[rowIndex][i] = new Shop("Shop", rowIndex, i);
                case '-' -> {
                    Room spawn = new Spawn("Spawn", rowIndex, i);
                    rooms[rowIndex][i] = spawn;
                    playerCurrentCoordinates[0] = rowIndex;
                    playerCurrentCoordinates[1] = i;
                    this.spawnRoom = spawn;
                }
                default -> System.err.println("Invalid map char");
            }
        }
    }
    public void printMap(){
        StringBuilder builder = new StringBuilder();
        for (Room[] room : rooms) {
            builder.append(Arrays.toString(room)).append("\n");
        }
        System.out.println(builder);
    }

    public void setPlayerCurrentCoordinates(int playerCurrentCoordinatesX, int playerCurrentCoordinatesY) {
        playerCurrentCoordinates[0] = playerCurrentCoordinatesX;
        playerCurrentCoordinates[1] = playerCurrentCoordinatesY;
    }
    public Room getSpawn()
    {
        return spawnRoom;
    }
    public Room[][] getRooms() {
        return rooms;
    }
}

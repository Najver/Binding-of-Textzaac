package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Map {
    private Room[][] rooms;

    public Map()
    {
        this.rooms = loadRoomsFromFile();
    }

    private Room[][] loadRoomsFromFile()
    {
        Room[][] rooms = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("FrozenDungeon.maap")))
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
                    throw new WrongMapFormatException("Part of the map has blank space \ngame.Map:\n" + stringBuilder);
                generateRoomInRow(s[i],rooms,i);
            }
            printMap();
        }
        catch (IOException ignored)
        {

        }
        return rooms;
    }
    private void generateRoomInRow(String s,Room[][] rooms,int rowIndex){
       char[] charsInString = s.toCharArray();
        for (int i = 0; i < charsInString.length; i++) {
            if(charsInString[i] == '+'){
                rooms[rowIndex][i] = new Room("game.Room" + (i + 1));
            }
        }
    }
    private void printMap(){
        StringBuilder builder = new StringBuilder();
        for (Room[] room : rooms) {
            builder.append(Arrays.toString(room)).append("\n");
        }
        System.out.println(builder);
    }
}

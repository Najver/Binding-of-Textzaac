package game.comandmanager.room;

import characters.Movement;
import characters.Player;
import structure.MapLevel;
import structure.room.Room;

public class MovementAction implements CommandActions{


    @Override
    public void execute(String parameter, Player player, MapLevel mapLevel)
    {
        Movement movementDirection = Movement.valueOf(parameter.toUpperCase());
        if (translateToAnotherRoom(mapLevel, player, movementDirection))
            System.out.println("Has moved to another room");
    }

    private boolean translateToAnotherRoom(MapLevel mapLevel, Player player, Movement movementDirection)
    {
        if (!canMoveInDirection(mapLevel, player, movementDirection))
        {
            System.err.println("You cannot move to this direction");
            return false;
        }
        int[] currentRoomIndices = player.getCurentRoom().getIndices();
        player.setCurrentRoom(mapLevel.getRooms()
                            [currentRoomIndices[0] + movementDirection.translateX]
                            [currentRoomIndices[1] + movementDirection.translateY]);
        mapLevel.setPlayerCurrentCoordinates(currentRoomIndices[0] + movementDirection.translateX,
                            currentRoomIndices[1] + movementDirection.translateY);
        return true;
    }

    private boolean canMoveInDirection(MapLevel mapLevel, Player player, Movement movementDirection)
    {
        Room[][] allRooms = mapLevel.getRooms();
        int[] roomPosition = player.getCurentRoom().getIndices();
        int futureXPosition = roomPosition[0] + movementDirection.translateX;
        int futureYPosition = roomPosition[1] + movementDirection.translateY;
        if (isValidIndex(allRooms, futureXPosition, futureYPosition))
            return allRooms[futureXPosition][futureYPosition] != null;
        return false;
    }

    private boolean isValidIndex(Room[][] allRooms, int x, int y)
    {
        int mapXMax = allRooms.length;
        int mapYMax = allRooms[0].length;
        return (x < mapXMax && x > -1) && (y < mapYMax && y > -1);
    }
}

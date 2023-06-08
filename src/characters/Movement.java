package characters;

/**
 * movement is really easy to understand, first you get coordinates from your map, and then you move in the direction you want, for example if you want to go up, it will substruct one row
 */
public enum Movement {
    UP(-1, 0),
    DOWN(1, 0),
    RIGHT(0,1),
    LEFT(0,-1);

    public final int translateX;
    public final int translateY;

    Movement(int translateX, int translateY) {
        this.translateX = translateX;
        this.translateY = translateY;
    }

}

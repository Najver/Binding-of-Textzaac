package characters;

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

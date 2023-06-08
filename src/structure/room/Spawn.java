package structure.room;

public class Spawn extends Room{

    public Spawn(String name, int x, int y) {
        super(name, x, y);
        super.enemy = null;
    }
}

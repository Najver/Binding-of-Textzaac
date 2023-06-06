package structure.room;

import characters.Boss;

public class BossRoom extends Room{

    public BossRoom(String name, int x, int y, Boss boss) {
        super(name, x, y);
        this.setEnemy(boss);
    }
}

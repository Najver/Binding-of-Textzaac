package game;

public abstract class Item {
    protected String name;

    public String getName() {
        return name;
    }

    public Item(String name) {
        this.name = name;
    }
}

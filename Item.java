public abstract class Item extends GameObject {

    protected int value;

    public Item(double x, double y, double width, double height, int value) {
        super(x, y, width, height);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}



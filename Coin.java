import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Coin extends Item {

    public Coin(double x, double y) {
        super(x, y, 30, 30, 1);
    }

    @Override
    protected void createToken(double x, double y) {
        Circle corps = new Circle(width/2, height/2, width/2);
        corps.setFill(Color.GOLD);
        corps.setStroke(Color.DARKGOLDENROD);
        corps.setStrokeWidth(3);

        Circle relief = new Circle(width/2, height/2, width/2 - 5);
        relief.setFill(Color.GOLDENROD);
        relief.setOpacity(0.6);

        token = new Group(corps, relief);
        token.setLayoutX(x);
        token.setLayoutY(y);
    }
}


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Mur extends GameObject {
    public Mur(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    @Override
    protected void createToken(double x, double y) {
        Rectangle m = new Rectangle(-width/2, -height/2, width, height);
        m.setFill(Color.DARKOLIVEGREEN);
        m.setStroke(Color.BLACK);
        token = new Group(m);
        token.setLayoutX(x);
        token.setLayoutY(y);
    }
}

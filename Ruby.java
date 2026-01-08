import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.Group;
public class Ruby extends Item {

    public Ruby(double x, double y) {
        super(x, y, 30, 30, 3);
    }

    @Override
    protected void createToken(double x, double y) {
        Polygon diamant = new Polygon(
                0, -height/2,
                width/2, 0,
                0, height/2,
                -width/2, 0
        );
        diamant.setFill(Color.CYAN);
        diamant.setStroke(Color.DARKBLUE);
        diamant.setStrokeWidth(3);

        Polygon facet1 = new Polygon(0, -height/2, width/2, 0, 0, -height/4);
        facet1.setFill(Color.LIGHTBLUE);

        Polygon facet2 = new Polygon(0, -height/2, 0, -height/4, -width/2, 0);
        facet2.setFill(Color.AZURE);

        Polygon facet3 = new Polygon(0, height/2, width/2, 0, 0, height/4);
        facet3.setFill(Color.DEEPSKYBLUE);

        Polygon facet4 = new Polygon(0, height/2, 0, height/4, -width/2, 0);
        facet4.setFill(Color.SKYBLUE);

        token = new Group(diamant, facet1, facet2, facet3, facet4);
        token.setLayoutX(x);
        token.setLayoutY(y);
    }
}


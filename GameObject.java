import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public abstract class GameObject {
    public double getXLeft()   { return getX() - width / 2; }
    public double getXRight()  { return getX() + width / 2; }
    public double getYTop()    { return getY() - height / 2; }
    public double getYBottom() { return getY() + height / 2; }



    public double getRotation() {
        return token.getRotate();
    }

    public void setRotation(double rotation) {
        token.setRotate(rotation);
    }

    public void setX(double x){this.token.setLayoutX(x);}
    public void setY(double y){this.token.setLayoutY(y);}
    public double getY(){return token.getLayoutY();}
    public double getX(){return token.getLayoutX();}
    double width;
    double height;
    Group token;
    boolean enable = true;
    public GameObject(double x, double y, double width, double height){

        this.width = width;
        this.height = height;
        createToken(x,y);
    }
    void createToken(double x, double y) {
        System.out.println("Méthode créateToken du joueur appelée");
        // double width;
        //double height;
        Ellipse corp= new Ellipse(0,0, width/2, height/2);
        Circle tete = new Circle(0,0,15);
        Circle main = new Circle(32,-10,6);
        Rectangle sword = new Rectangle(25,-13 ,15,3);
        sword.setFill(Color.WHITE);
        corp.setFill(Color.DARKOLIVEGREEN);
        this.token = new Group(corp, tete, main, sword);
        this.token.setLayoutX(x);
        this.token.setLayoutY(y);
    }

    public boolean isEnable() {
        return enable;
    }

    public void disable() {
        enable = false;
        token.setVisible(false);
    }

    public void addToPane(Pane pane) {
        pane.getChildren().add(this.token);
    }
}

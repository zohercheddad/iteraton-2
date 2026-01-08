import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;



public class Joueur extends Character{
    private int live = 10;
    private int points = 0;

    public Joueur(double x, double y) {
        super(x, y, 40, 40, 5); // width, height OBLIGATOIRES
        //createToken(x, y);
    }

    public int getLive() {
        return live;
    }

    public int getPoints() {
        return points;
    }

    @Override
    protected void createToken(double x, double y) {
        System.out.println("Méthode créateToken du joueur appelée");
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




    public void drop(Item i) {
        i.disable();
        points += i.getValue();
    }


    public void reciveDamages(int x) {
        live = Math.max(0, live - x);

        // recul 10 px selon la rotation
        switch ((int) getRotation()) {
            case 0:   setY(getY() + 10); break;   // nord
            case 90:  setX(getX() - 10); break;   // est
            case 180: setY(getY() - 10); break;   // sud
            case 270: setX(getX() + 10); break;   // ouest
        }
    }
    @Override
    public void onCollideWith(GameObject go) {
        if (go instanceof Item) {
            drop((Item) go);
        } else if (go instanceof Monster) {
            reciveDamages(2);
        } else {
            repositionAbout(go); // méthode fournie par le prof
        }
    }
}

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import java.util.List;
import java.util.Random;

public class Monster extends Character {

    private int frameCount = 0;
    private Random rnd = new Random();

    public Monster(double x, double y) {
        super(x, y, 30, 30, 3); // width, height, vitesse
        changeDirection();
    }

    @Override
    protected void createToken(double x, double y) {
        System.out.println("Monster token créé");
        Rectangle corps = new Rectangle(-width/2, -height/2, width, height);
        corps.setFill(Color.DARKGREEN);
        corps.setOpacity(0.5);

        Circle oeil1 = new Circle(8 - width/2, 1 - height/2, 3);
        Circle oeil2 = new Circle(22 - width/2, 1 - height/2, 3);

        token = new Group(oeil1, oeil2, corps);

        for (int k = 0; k < 3; ++k) {
            Ellipse e = new Ellipse(15 - width/2, k * 10 + 5 - height/2, 3, 5);
            e.setFill(Color.GREEN);
            token.getChildren().add(e);
        }

        token.setLayoutX(x);
        token.setLayoutY(y);
    }

    // ===== LE PDF =====
    public void resolveMove(List<GameObject> gos) {
        double dx = 0, dy = 0;

        switch ((int) getRotation()) {
            case 0:   dy = -vitesse; break;   // nord
            case 90:  dx =  vitesse; break;   // est
            case 180: dy =  vitesse; break;   // sud
            case 270: dx = -vitesse; break;   // ouest
        }

        move(dx, dy, getRotation(), gos);

        frameCount++;
        if (frameCount % 150 == 0) {
            changeDirection();
        }
    }

    // ===== LE PDF =====
    public void changeDirection() {
        int[] dirs = {0, 90, 180, 270};
        setRotation(dirs[rnd.nextInt(4)]);
    }


    // ===== LE PDF =====
    @Override
    public void onCollideWith(GameObject go) {
        changeDirection();

        if (go instanceof Joueur) {
            // dégâts de 2 → à implémenter côté Joueur
            // ((Joueur) go).takeDamage(2);
        }
    }
}


import java.util.List;

public abstract class Character extends GameObject {

    protected int vitesse;



    public Character(double x, double y, double width, double height, int vitesse) {
        super(x, y, width, height);
        this.vitesse = vitesse;
    }

    public int getVitesse() {
        return vitesse;
    }

    // ===== COLLISIONS (code du PDF, OK chez toi) =====

    public boolean collideWith(GameObject go) {
        return collideBottom(go) || collideLeft(go) || collideRight(go) || collideTop(go);
    }

    public boolean collideLeft(GameObject elem) {
        double xGauchePerso = getXLeft();
        boolean result = getY() >= elem.getYTop()
                && getY() <= elem.getYBottom()
                && xGauchePerso <= elem.getXRight()
                && xGauchePerso >= elem.getXLeft();
        return elem.isEnable() && result;
    }

    public boolean collideRight(GameObject elem) {
        boolean result = getY() >= elem.getYTop()
                && getY() <= elem.getYBottom()
                && getXRight() >= elem.getXLeft()
                && getXRight() <= elem.getXRight();
        return elem.isEnable() && result;
    }

    public boolean collideTop(GameObject elem) {
        boolean result = getX() >= elem.getXLeft()
                && getX() <= elem.getXRight()
                && getYTop() <= elem.getYBottom()
                && getYTop() >= elem.getYTop();
        return elem.isEnable() && result;
    }

    public boolean collideBottom(GameObject elem) {
        boolean result = getX() >= elem.getXLeft()
                && getX() <= elem.getXRight()
                && getYBottom() >= elem.getYTop()
                && getYBottom() <= elem.getYBottom();
        return elem.isEnable() && result;
    }

    // ===== DÉPLACEMENT CENTRALISÉ (OBLIGATOIRE) =====

    public void move(double dx, double dy, double rotation, List<GameObject> gos) {
        double oldX = getX();
        double oldY = getY();

        setRotation(rotation);
        setX(oldX + dx);
        setY(oldY + dy);

        for (GameObject go : gos) {
            if (go != this && collideWith(go)) {
                setX(oldX);
                setY(oldY);
                onCollideWith(go);
                break;
            }
        }
    }

    // ===== COMPORTEMENT SPÉCIFIQUE =====
    public abstract void onCollideWith(GameObject go);
}


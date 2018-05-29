package FriendsCodes.sz.testfx.app1.game.objects;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public abstract class GameObject {
    protected Node object;

    public GameObject(Node object) {
        this.object = object;
    }

    public void rotateToAnotherObject(GameObject object) {
        setRotate(Math.atan2(getX() - object.getX(), getY() - object.getY()) * 180/Math.PI);
    }

    public void rotateToMouse(MouseEvent event) {
        setRotate(Math.atan2(getY() - event.getY(), getX() - event.getX()) * 180/Math.PI);
    }

    public abstract void update();

    public double getX() {
        return object.getTranslateX();
    }

    public void setX(double x) {
        object.setTranslateX(x);
    }

    public double getY() {
        return object.getTranslateY();
    }

    public void setY(double y) {
        object.setTranslateY(y);
    }

    public Node getObject() {
        return object;
    }

    public void setRotate(double value) {
        object.setRotate(value);
    }

    public double getRotate() {
        return object.getRotate();
    }
}

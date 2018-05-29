package FriendsCodes.sz.testfx.app1.game.objects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Bullet extends GameObject {
    private Polygon object;
    private double baseSpeed = 10;
    private double speedX, speedY;
    private int time, lifetime;

    public Bullet(GameObject parent, int lifetime) {
        super(new Polygon(
                -10.0D, 0.0D,
                -5.0D, 5.0D,
                0.0D, 5.0D,
                -2.5D, 2.5D,
                10.0D, 0.0D,
                -2.5D, -2.5D,
                0.0D, -5.0D,
                -5.0D, -5.0D
        ));
        this.object = (Polygon)super.object;
        object.setFill(Color.BLACK);
        object.setStroke(Color.BLACK);

        setX(parent.getX());
        setY(parent.getY());

        speedX = baseSpeed * -Math.cos(parent.getRotate() * Math.PI/180);
        speedY = baseSpeed * -Math.sin(parent.getRotate() * Math.PI/180);
        setRotate(parent.getRotate());

        this.lifetime = lifetime;
    }

    @Override
    public void update() {
        time++;
        setX(getX() + speedX);
        setY(getY() + speedY);
    }

    public boolean isAlive() {
        return lifetime > time;
    }

    public boolean isDead() {
        return !isAlive();
    }
}

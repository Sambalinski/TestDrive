package FriendsCodes.sz.testfx.app1.game.objects.player;

import FriendsCodes.sz.testfx.app1.Reference;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import FriendsCodes.sz.testfx.app1.game.objects.Bullet;
import FriendsCodes.sz.testfx.app1.game.objects.Entity;

import java.util.HashSet;
import java.util.Set;

public class Player extends Entity {
    private Polygon object;
    private Set<Direction> directions;

    public Player() {
        super(2000, new Polygon(
                -20.0D, 0.0D,
                15.0D, 15.0D,
                10.0D, 5.0D,
                20.0D, 0.0D,
                10.0D, -5.0D,
                15.0D, -15.0D));
        this.object = (Polygon)super.object;
        object.setTranslateX(Reference.WINDOW_WIDTH/2);
        object.setTranslateY(Reference.WINDOW_HEIGHT/2);
        object.setStroke(Color.WHITE);
        object.setStrokeWidth(2);
        object.setFill(Color.BLACK);

        directions = new HashSet<>(4);
    }

    public Bullet shoot() {
        return new Bullet(this, 50);
    }

    @Override
    public void update() {
        //moving a player object
        if (directions.contains(Direction.UP))
            setY(getY()-5);
        if (directions.contains(Direction.RIGHT))
            setX(getX()+5);
        if (directions.contains(Direction.DOWN))
            setY(getY()+5);
        if (directions.contains(Direction.LEFT))
            setX(getX()-5);

        //borders
        if (getX() < 0)
            setX(0);
        if (getX() > Reference.WINDOW_WIDTH)
            setX(Reference.WINDOW_WIDTH);
        if (getY() < 0)
            setY(0);
        if (getY() > Reference.WINDOW_HEIGHT)
            setY(Reference.WINDOW_HEIGHT);
    }

    public void move(KeyEvent event) {
        if (event.getEventType() == KeyEvent.KEY_PRESSED) {
            switch (event.getCode()) {
                case UP: case W:
                    directions.add(Direction.UP); break;
                case RIGHT: case D:
                    directions.add(Direction.RIGHT); break;
                case DOWN: case S:
                    directions.add(Direction.DOWN); break;
                case LEFT: case A:
                    directions.add(Direction.LEFT); break;
            }
        }
        if (event.getEventType() == KeyEvent.KEY_RELEASED) {
            switch (event.getCode()) {
                case UP: case W:
                    directions.remove(Direction.UP); break;
                case RIGHT: case D:
                    directions.remove(Direction.RIGHT); break;
                case DOWN: case S:
                    directions.remove(Direction.DOWN); break;
                case LEFT: case A:
                    directions.remove(Direction.LEFT); break;
            }
        }
    }
}

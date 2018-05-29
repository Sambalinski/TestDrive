package FriendsCodes.sz.testfx.app1.game.objects;

import FriendsCodes.sz.testfx.app1.Reference;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Enemy extends Entity {
    private Circle object;

    public Enemy() {
        super(200, new Circle(10.0D, Color.DARKRED));
        this.object = (Circle)super.object;
        object.setTranslateX(Math.random()* Reference.WINDOW_WIDTH);
        object.setTranslateY(Math.random()* Reference.WINDOW_HEIGHT);
        object.setOnMouseClicked(e -> System.out.println(health));
    }

    @Override
    public void update() {
    }
}

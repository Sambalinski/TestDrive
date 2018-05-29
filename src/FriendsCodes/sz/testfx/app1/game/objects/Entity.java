package FriendsCodes.sz.testfx.app1.game.objects;

import javafx.scene.Node;

public abstract class Entity extends GameObject {
    protected int health;

    public Entity(int health, Node object) {
        super(object);
        this.health = health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean isDead() {
        return !isAlive();
    }
}
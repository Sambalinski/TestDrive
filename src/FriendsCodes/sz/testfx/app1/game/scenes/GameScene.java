package FriendsCodes.sz.testfx.app1.game.scenes;

import FriendsCodes.sz.testfx.app1.Utils;
import FriendsCodes.sz.testfx.app1.game.objects.Bullet;
import FriendsCodes.sz.testfx.app1.game.objects.Enemy;
import FriendsCodes.sz.testfx.app1.game.objects.Entity;
import FriendsCodes.sz.testfx.app1.game.objects.player.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import FriendsCodes.sz.testfx.app1.GameSettings;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GameScene extends Scene {
    private final Stage stage;
    private Group layout;
    private Player player;
    private Set<Enemy> enemies;
    private Set<Bullet> bullets;
    private AnimationTimer timer;

    public GameScene(Stage stage) {
        super(new Group());
        this.stage = stage;

        layout = (Group)getRoot();

        player = new Player();
        setOnMouseMoved(player::rotateToMouse);
        setOnKeyPressed(this::keyboardManage);
        setOnKeyReleased(this::keyboardManage);
        enemies = new HashSet<>();
        bullets = new HashSet<>();

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        timer.start();

        layout.getChildren().addAll(player.getObject());
        Utils.setSceneDefaultSettings(stage, this);
    }

    private void onUpdate() {
        player.update();
        enemies.forEach(Enemy::update);
        bullets.forEach(Bullet::update);

        enemies.stream().filter(Entity::isDead).forEach(e -> {
            if (layout.getChildren().contains(e.getObject()))
                layout.getChildren().remove(e.getObject());
        });
        enemies = enemies.stream().filter(Entity::isAlive).collect(Collectors.toSet());

        bullets.stream().filter(Bullet::isDead).forEach(b -> {
            if (layout.getChildren().contains(b.getObject()))
                layout.getChildren().remove(b.getObject());
        });
        bullets = bullets.stream().filter(Bullet::isAlive).collect(Collectors.toSet());

        if (enemies.size() < GameSettings.MAX_ENEMIES)
            if (Math.random() < 0.025D) {
                Enemy enemy = new Enemy();
                enemies.add(enemy);
                layout.getChildren().addAll(enemy.getObject());
                System.out.println("Enemy has been spawned. Total objects: " + layout.getChildren().size() + " Enemies: " + enemies.size());
            }

        if (player.isDead()) {
            timer.stop();
            setOnMouseMoved(null);
        }
    }

    private void keyboardManage(KeyEvent event) {
        if (GameSettings.MOVING_CODES.contains(event.getCode())) {
            player.move(event);
        }

        if (event.getEventType() == KeyEvent.KEY_PRESSED) {
            KeyCode code = event.getCode();
            switch(code) {
                case ESCAPE: {
                    timer.stop();
                    stage.setScene(new MainMenu(stage));
                    break;
                }
                case SPACE: {
                    Bullet bullet = player.shoot();
                    bullets.add(bullet);
                    layout.getChildren().addAll(bullet.getObject());
                    System.out.println("Shoot!");
                }
            }
        }
    }
}

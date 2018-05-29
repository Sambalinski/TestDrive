package FriendsCodes.sz.testfx.app1;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import FriendsCodes.sz.testfx.app1.game.objects.player.Player;
import FriendsCodes.sz.testfx.app1.game.scenes.MainMenu;

public class Utils {
    public static void setSceneDefaultSettings(Stage stage, Scene scene) {
        if (scene.getOnKeyPressed() == null) {
            scene.setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.ESCAPE)
                    stage.setScene(new MainMenu(stage));
            });
        }

        scene.setFill(Color.GRAY);
    }

    public static Player getMenuPlayerMask() {
        Player mask = new Player();
        mask.setRotate(60.0D);
        mask.setX(Reference.WINDOW_WIDTH * 3 / 4);
        mask.setY(Reference.WINDOW_HEIGHT / 2);
        mask.getObject().setScaleX(7.5D);
        mask.getObject().setScaleY(7.5D);
        mask.getObject().setOpacity(0.5D);

        return mask;
    }
}

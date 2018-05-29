package FriendsCodes.sz.testfx.app1;

import javafx.scene.input.KeyCode;

import java.util.Arrays;
import java.util.List;

public class GameSettings {
    public static final List<KeyCode> MOVING_CODES = Arrays.asList(
            KeyCode.UP, KeyCode.W, KeyCode.RIGHT, KeyCode.D, KeyCode.DOWN, KeyCode.S, KeyCode.LEFT, KeyCode.A);

    public static final int MAX_ENEMIES = 20;
}

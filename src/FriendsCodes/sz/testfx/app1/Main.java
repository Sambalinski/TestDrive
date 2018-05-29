package FriendsCodes.sz.testfx.app1;

import javafx.application.Application;
import javafx.stage.Stage;
import FriendsCodes.sz.testfx.app1.game.scenes.MainMenu;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setHeight(Reference.WINDOW_HEIGHT);
        stage.setWidth(Reference.WINDOW_WIDTH);
        stage.setTitle(Reference.GAME_NAME);
        stage.setResizable(false);

        stage.setScene(new MainMenu(stage));

        stage.show();
    }
}

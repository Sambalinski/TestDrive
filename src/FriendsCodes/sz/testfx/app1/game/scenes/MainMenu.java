package FriendsCodes.sz.testfx.app1.game.scenes;

import FriendsCodes.sz.testfx.app1.Reference;
import FriendsCodes.sz.testfx.app1.Utils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu extends Scene{
    private final Stage stage;
    private Group layout;

    public MainMenu(Stage stage) {
        super(new Group());
        this.stage = stage;

        layout = (Group)getRoot();

        VBox leftMenu = new VBox();
        leftMenu.setPrefSize(Reference.WINDOW_WIDTH/2, Reference.WINDOW_HEIGHT);
        leftMenu.setPadding(new Insets(50));
        leftMenu.setSpacing(30);

        leftMenu.getChildren().addAll(
                getGameTitleText(),
                getMenuButton("start", event -> stage.setScene(new GameScene(stage))),
                getMenuButton("Instructions", event -> stage.setScene(new InstructionsMenu(stage))),
                getMenuButton("About...", event -> stage.setScene(new AboutMenu(stage))));

        layout.getChildren().addAll(leftMenu, Utils.getMenuPlayerMask().getObject());
        Utils.setSceneDefaultSettings(stage, this);
    }

    private Text getGameTitleText() {
        Text title = new Text(Reference.GAME_NAME);
        title.setFont(Font.font("Bell Gothic Std", FontWeight.BOLD, 40));
        title.setStroke(Color.AQUA);
        title.setFill(Color.AZURE);

        return title;
    }

    private Button getMenuButton(String text, EventHandler<ActionEvent> event) {
        Button button = new Button(text);
        button.setTranslateX(50);
        button.setFont(Font.font("Bell Gothic Std", FontWeight.EXTRA_BOLD, 24));
        button.setPrefSize(200, 35);
        button.setOnAction(event);

        return button;
    }
}
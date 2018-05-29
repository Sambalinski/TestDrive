package FriendsCodes.sz.testfx.app1.game.scenes;

import FriendsCodes.sz.testfx.app1.Utils;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InstructionsMenu extends Scene {
    private final Stage stage;
    private Group layout;

    public InstructionsMenu(Stage stage) {
        super(new Group());
        this.stage = stage;
        layout = (Group)getRoot();

        VBox leftMenu = new VBox();
        leftMenu.setPadding(new Insets(50));
        leftMenu.setSpacing(10);
        addInstructionText(leftMenu, "W", "Move up");
        addInstructionText(leftMenu, "A", "Move left");
        addInstructionText(leftMenu, "S", "Move down");
        addInstructionText(leftMenu, "D", "Move right");
        addInstructionText(leftMenu, "ESC", "Go to main menu");

        layout.getChildren().addAll(leftMenu, Utils.getMenuPlayerMask().getObject());
        Utils.setSceneDefaultSettings(stage, this);
    }

    private void addInstructionText(VBox menu, String button, String description) {
        Text text = new Text(button + " - " + description);
        text.setFont(Font.font("Bell Gothic Std", FontWeight.BOLD, 25));
        text.setStroke(Color.AQUA);
        text.setFill(Color.AZURE);
        menu.getChildren().addAll(text);
    }
}

package application.labyrinth.app.ui.menu;

import application.labyrinth.app.game.GameFlowController;
import application.labyrinth.app.game.GameResolution;
import application.labyrinth.app.ui.controller.Menu;
import application.labyrinth.app.ui.fxml.FxmlConfig;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainMenuScene
{
    private final Scene scene;

    public MainMenuScene(SceneManager manager, GameFlowController controller, GameResolution resolution)
    {
        try{
            FxmlConfig fxml = new FxmlConfig();
            final String fxmlPath = fxml.getFxmlPath() + "Menu.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));

            Parent root = loader.load();

            Menu menuController = loader.getController();
            menuController.init(controller,manager,resolution);

            final double width = resolution.getWidth(resolution.getScaleW());
            final double height = resolution.getHeight(resolution.getScaleH());
            this.scene = resolution.createScene(root, width, height);
        } catch (Exception e)
        {
            throw new RuntimeException("Failed to load Main Menu", e);
        }
    }
    public Scene getScene()
    {
        return scene;
    }
}
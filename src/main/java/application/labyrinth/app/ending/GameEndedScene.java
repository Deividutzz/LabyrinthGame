package application.labyrinth.app.ending;

import application.labyrinth.app.game.GameResolution;
import application.labyrinth.app.ui.controller.GameEnded;
import application.labyrinth.app.ui.fxml.FxmlConfig;
import application.labyrinth.app.ui.menu.SceneCreator;
import application.labyrinth.app.ui.menu.SceneManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameEndedScene
{
    private final Scene scene;

    public GameEndedScene(SceneManager manager, SceneCreator creator, GameResolution resolution)
    {
        try
        {
            FxmlConfig fxml = new FxmlConfig();
            final String fxmlPath = fxml.getFxmlPath() + "GameEnded.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));

            Parent root = loader.load();

            GameEnded endingController = loader.getController();
            endingController.init(creator,manager,resolution);

            final double width = resolution.getWidth(resolution.getScaleW());
            final double height = resolution.getHeight(resolution.getScaleH());
            this.scene = resolution.createScene(root, width, height);
        } catch (Exception e)
        {
            throw new RuntimeException("Failed to load Game Ended Scene", e);
        }
    }
    public Scene getScene()
    {
        return scene;
    }
}
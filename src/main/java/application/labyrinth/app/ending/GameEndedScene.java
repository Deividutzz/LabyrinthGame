package application.labyrinth.app.ending;

import application.labyrinth.app.game.GameResolution;
import application.labyrinth.app.game.GameStats;
import application.labyrinth.app.ui.controller.GameEnded;
import application.labyrinth.app.ui.fxml.FxmlConfig;
import application.labyrinth.app.ui.menu.SceneCreator;
import application.labyrinth.app.ui.menu.SceneManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.Objects;

public class GameEndedScene
{
    private final Scene scene;
    private final GameEnded gameEnded;

    public GameEndedScene(SceneManager manager, SceneCreator creator, GameResolution resolution, GameStats gameStats)
    {
        try
        {
            FxmlConfig fxml = new FxmlConfig();
            final String fxmlPath = fxml.getFxmlPath() + "GameEnded.fxml";
            final String cssPath = fxml.getCssPath() + "GameEndedStyling.css";

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));

            Parent root = loader.load();

            GameEnded endingController = loader.getController();
            endingController.init(creator,manager,resolution,gameStats);
            gameEnded = endingController;

            final double width = resolution.getWidth(resolution.getScaleW());
            final double height = resolution.getHeight(resolution.getScaleH());
            this.scene = resolution.createScene(root, width, height);
            this.scene.getStylesheets().add(
                    Objects.requireNonNull(getClass().getResource(cssPath)).toExternalForm()
            );
        } catch (Exception e)
        {
            throw new RuntimeException("Failed to load Game Ended Scene", e);
        }
    }
    public Scene getScene()
    {
        return scene;
    }
    public GameEnded getEndedCntrllr()
    {
        return gameEnded;
    }
}
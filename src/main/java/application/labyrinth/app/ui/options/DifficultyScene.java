package application.labyrinth.app.ui.options;

import application.labyrinth.app.game.GameResolution;
import application.labyrinth.app.ui.controller.Difficulty;
import application.labyrinth.app.ui.fxml.FxmlConfig;
import application.labyrinth.app.ui.menu.SceneManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.Objects;

public class DifficultyScene
{
    private final Scene scene;

    public DifficultyScene(SceneManager manager, OptionsController controller, GameResolution resolution)
    {
        try
        {
            FxmlConfig fxml = new FxmlConfig();
            final String fxmlPath = fxml.getFxmlPath() + "Difficulty.fxml";
            final String cssPath = fxml.getCssPath() + "DifficultyStyling.css";

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));

            Parent root = loader.load();

            Difficulty difficultyController = loader.getController();
            difficultyController.init(manager,controller,resolution);

            final double width = resolution.getWidth(resolution.getScaleW());
            final double height = resolution.getHeight(resolution.getScaleH());
            this.scene = resolution.createScene(root, width, height);
            this.scene.getStylesheets().add(
                    Objects.requireNonNull(getClass().getResource(cssPath)).toExternalForm()
            );
        } catch (Exception e)
        {
            throw new RuntimeException("Failed to load Difficulty", e);
        }
    }
    public Scene getScene()
    {
        return scene;
    }
}
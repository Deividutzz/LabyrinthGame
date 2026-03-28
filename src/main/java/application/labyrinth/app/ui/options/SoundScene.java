package application.labyrinth.app.ui.options;

import application.labyrinth.app.game.GameResolution;
import application.labyrinth.app.ui.controller.Sound;
import application.labyrinth.app.ui.fxml.FxmlConfig;
import application.labyrinth.app.ui.menu.SceneManager;
import application.labyrinth.app.ui.menu.SoundtrackManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.Objects;

public class SoundScene
{
    private final Scene scene;

    public SoundScene(SceneManager manager, OptionsController controller, GameResolution resolution, SoundtrackManager soundtrack)
    {
        try
        {
            FxmlConfig fxml = new FxmlConfig();
            final String path = fxml.getFxmlPath() + "Sound.fxml";
            final String cssPath = fxml.getCssPath() + "AudioStyling.css";

            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));

            Parent root = loader.load();

            Sound soundController = loader.getController();
            soundController.init(manager,controller,resolution,soundtrack);

            final double width = resolution.getWidth(resolution.getScaleW());
            final double height = resolution.getHeight(resolution.getScaleH());
            this.scene = resolution.createScene(root, width, height);
            this.scene.getStylesheets().add(
                    Objects.requireNonNull(getClass().getResource(cssPath)).toExternalForm()
            );
        } catch (Exception e)
        {
            throw new RuntimeException("Failed to load Audio and Video", e);
        }
    }
    public Scene getScene()
    {
        return scene;
    }
}
package application.labyrinth.app.ui.options;

import application.labyrinth.app.game.GameResolution;
import application.labyrinth.app.ui.controller.Options;
import application.labyrinth.app.ui.fxml.FxmlConfig;
import application.labyrinth.app.ui.menu.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class OptionsScene
{
    private final Scene scene;

    public OptionsScene(SceneManager manager, GameResolution resolution)
    {
        try
        {
            FxmlConfig fxml = new FxmlConfig();
            final String fxmlPath = fxml.getFxmlPath() + "Options.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));

            Parent root = loader.load();

            Options optionsController = loader.getController();
            optionsController.init(manager,resolution);

            final double width = resolution.getWidth(resolution.getScaleW());
            final double height = resolution.getHeight(resolution.getScaleH());
            this.scene = resolution.createScene(root, width, height);
        } catch (Exception e)
        {
            throw new RuntimeException("Failed to load Options", e);
        }

    }
    public Scene getScene()
    {
        return scene;
    }
}
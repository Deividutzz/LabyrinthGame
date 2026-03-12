package application.labyrinth.app.ui.menu;

import application.labyrinth.app.game.GameResolution;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneManager
{
    private final Stage stage;

    private Scene soundScene;
    private Scene diffScene;
    private Scene mainScene;
    private Scene optionsScene;
    private Scene gameScene;
    private Scene endGameScene;
    private final GameResolution resolution;

    public SceneManager(Stage stage, GameResolution resolution)
    {
        this.stage = stage;
        this.resolution = resolution;
    }

    public void setScene(Scene scene)
    {
        stage.setScene(scene);
    }

    public void setVolume(Scene scene) {this.soundScene = scene;}
    public void setDifficulty(Scene scene) {this.diffScene = scene;}
    public void setMainMenu(Scene scene)
    {
        this.mainScene = scene;
    }
    public void setOptions(Scene scene)
    {
        this.optionsScene = scene;
    }
    public void setGame(Scene scene) { this.gameScene = scene; }
    public void setEndGame(Scene scene) { this.endGameScene = scene; }

    public void showVolume()
    {
        stage.setScene(soundScene);
    }
    public void showDifficulty()
    {
        stage.setScene(diffScene);
    }
    public void showMainMenu()
    {
        stage.setScene(mainScene);
    }
    public void showOptions()
    {
        stage.setScene(optionsScene);
    }
    public void showGame()
    {
        stage.setScene(gameScene);
    }
    public void showEndGame()
    {
        stage.setScene(endGameScene);
    }

    public void delete(Scene scene)
    {
        Parent root = scene.getRoot();
        ((VBox) root).getChildren().clear();
    }

    public void exitGame()
    {
        stage.close();
    }
}
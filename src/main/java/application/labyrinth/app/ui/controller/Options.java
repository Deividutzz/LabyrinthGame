package application.labyrinth.app.ui.controller;

import application.labyrinth.app.game.GameResolution;
import application.labyrinth.app.ui.menu.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Options
{
    @FXML private Button difficultyButton;
    @FXML private Button soundButton;
    @FXML private Button backButton;
    @FXML private ImageView backgroundImg;

    private SceneManager manager;
    private GameResolution resolution;

    public void init(SceneManager manager, GameResolution resolution)
    {
        this.manager = manager;
        this.resolution = resolution;

        setupActions();
        setupBackground();
    }

    private void setupActions()
    {
        difficultyButton.setOnAction(e -> manager.showDifficulty());
        soundButton.setOnAction(e -> manager.showVolume());
        backButton.setOnAction(e -> manager.showMainMenu());
    }
    private void setupBackground()
    {
        final String path = "/application/labyrinth/assets/Images/optionsBg.jpg";

        Image backgroundImage = new Image
        (
                Objects.requireNonNull(getClass().getResource(path)).toExternalForm()
        );

        backgroundImg.setImage(backgroundImage);
        backgroundImg.setFitWidth(resolution.getScreenWidth());
        backgroundImg.setFitHeight(resolution.getScreenHeight());
    }
}
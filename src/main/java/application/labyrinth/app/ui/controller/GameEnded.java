package application.labyrinth.app.ui.controller;

import application.labyrinth.app.game.GameResolution;
import application.labyrinth.app.ui.menu.SceneCreator;
import application.labyrinth.app.ui.menu.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class GameEnded
{
    @FXML private Button returnToMenu;
    @FXML private Button quitGame;
    @FXML private ImageView backgroundImg;

    private SceneCreator creator;
    private SceneManager manager;
    private GameResolution resolution;

    public void init(SceneCreator creator, SceneManager manager, GameResolution resolution)
    {
        this.creator = creator;
        this.manager = manager;
        this.resolution = resolution;

        setupActions();
        setupBackground();
    }

    private void setupActions()
    {
        returnToMenu.setOnAction(e ->
        {
            creator.create();
            manager.showMainMenu();
        });

        quitGame.setOnAction(e -> manager.exitGame());
    }
    private void setupBackground()
    {
        final String path = "/application/labyrinth/assets/Images/gameEndedBg.jpg";

        Image backgroundImage = new Image
        (
                Objects.requireNonNull(getClass().getResource(path)).toExternalForm()
        );

        backgroundImg.setImage(backgroundImage);
        backgroundImg.setFitWidth(resolution.getScreenWidth());
        backgroundImg.setFitHeight(resolution.getScreenHeight());
    }
}
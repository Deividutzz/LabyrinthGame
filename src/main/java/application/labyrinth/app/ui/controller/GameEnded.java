package application.labyrinth.app.ui.controller;

import application.labyrinth.app.game.GameResolution;
import application.labyrinth.app.game.GameStats;
import application.labyrinth.app.ui.menu.SceneCreator;
import application.labyrinth.app.ui.menu.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class GameEnded
{
    @FXML private Label timeSurvivedLabel;
    @FXML private Button returnToMenu;
    @FXML private Button quitGame;
    @FXML private ImageView backgroundImg;

    private SceneCreator creator;
    private SceneManager manager;
    private GameResolution resolution;
    private GameStats gameStats;

    public void init(SceneCreator creator, SceneManager manager, GameResolution resolution,  GameStats gameStats)
    {
        this.creator = creator;
        this.manager = manager;
        this.resolution = resolution;
        this.gameStats = gameStats;

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
    public void setupStats()
    {
        ///  here should be all the methods with the stats

        setupTimeSurvivedLabel();
    }
    private void setupTimeSurvivedLabel()
    {
        //System.out.println(gameStats.getTimeSurvived() + "ceva");
        timeSurvivedLabel.setText("Mario succesfully survived: ");

        String minutes = gameStats.getminutesSurvived() + " minutes and ";
        if(gameStats.getminutesSurvived().equals("0"))
            minutes = "";

        String seconds = gameStats.getsecondsSurvived() + " seconds";
        if(gameStats.getsecondsSurvived().equals("0"))
            seconds = "";

        timeSurvivedLabel.setText(
                timeSurvivedLabel.getText() + minutes + seconds);
    }
}
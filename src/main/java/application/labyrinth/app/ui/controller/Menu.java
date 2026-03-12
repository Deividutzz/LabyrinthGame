package application.labyrinth.app.ui.controller;

import application.labyrinth.app.game.GameFlowController;
import application.labyrinth.app.game.GameResolution;
import application.labyrinth.app.ui.menu.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.util.Objects;

public class Menu
{
    @FXML private Button startGameButton;
    @FXML private Button optionsButton;
    @FXML private Button exitButton;
    @FXML private MediaView backgroundVideo;
    @FXML private ImageView backgroundGif;

    private GameFlowController flowController;
    private SceneManager sceneManager;
    private GameResolution resolution;

    public void init(GameFlowController flowController, SceneManager sceneManager, GameResolution resolution)
    {
        this.flowController = flowController;
        this.sceneManager = sceneManager;
        this.resolution = resolution;

        setupActions();
        setupBackground();
        //setupVideo();
    }
    private void setupActions()
    {
        startGameButton.setOnAction(e -> flowController.startGame());
        optionsButton.setOnAction(e -> sceneManager.showOptions());
        exitButton.setOnAction(e -> sceneManager.exitGame());
    }
    private void setupBackground()
    {
        final String path = "/application/labyrinth/assets/Images/animatedBg2.gif";

        Image backgroundImage = new Image
        (
                Objects.requireNonNull(getClass().getResource(path)).toExternalForm()
        );

        backgroundGif.setImage(backgroundImage);
        backgroundGif.setFitWidth(resolution.getScreenWidth());
        backgroundGif.setFitHeight(resolution.getScreenHeight());
    }
    private void setupVideo()
    {
        final String path = "/application/labyrinth/assets/Videos/animatedBg2.mp4";

        Media media = new Media(
                Objects.requireNonNull(getClass().getResource(path)).toExternalForm()
        );

        MediaPlayer mediaPlayer = new MediaPlayer(media);

        backgroundVideo.setMediaPlayer(mediaPlayer);

        mediaPlayer.setOnReady(() -> {
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        });

        backgroundVideo.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                backgroundVideo.fitWidthProperty().bind(newScene.widthProperty());
                backgroundVideo.fitHeightProperty().bind(newScene.heightProperty());
            }
        });

        media.setOnError(() -> {
            System.out.println("Media error (media): " + media.getError());
        });

        mediaPlayer.setOnError(() -> {
            System.out.println("Media error (player): " + mediaPlayer.getError());
        });

        backgroundVideo.setPreserveRatio(false);

    }
}
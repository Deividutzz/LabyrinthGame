package application.labyrinth.app.ui.controller;

import application.labyrinth.app.game.GameResolution;
import application.labyrinth.app.ui.menu.SceneManager;
import application.labyrinth.app.ui.options.OptionsController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Objects;

public class Sound
{
    @FXML private Slider volumeSlider;
    @FXML private Button fullscreenButton;
    @FXML private Button resetButton;
    @FXML private Button backButton;
    @FXML private StackPane root;
    @FXML private ImageView backgroundImg;

    private SceneManager manager;
    private OptionsController controller;
    private GameResolution resolution;

    public void init(SceneManager manager, OptionsController controller, GameResolution resolution)
    {
        this.manager = manager;
        this.controller = controller;
        this.resolution = resolution;

        setupActions();
        setupBackground();
    }

    private void setupActions()
    {
        volumeSlider.setValue(controller.getVolume());
        setProperties();
        volumeSlider.valueProperty().addListener((o, ov, nv) ->
                controller.setVolume(nv.intValue())
        );

        fullscreenButton.setOnAction(e -> {
            resolution.setWidth(resolution.getScreenWidth(),1);
            resolution.setHeight(resolution.getScreenHeight(),1);


            Stage stage = (Stage) root.getScene().getWindow();

            stage.setX(0);
            stage.setY(0);

            stage.setWidth(resolution.getWidth(1));
            stage.setHeight(resolution.getHeight(1));
            manager.showVolume();
        });

        resetButton.setOnAction(e -> {
            resolution.resetToDefault();

            Stage stage = (Stage) root.getScene().getWindow();
            stage.setX(resolution.getStageX());
            stage.setY(resolution.getStageY());
            resolution.setWidth(resolution.getScreenWidth(),resolution.getScaleW());
            resolution.setHeight(resolution.getScreenHeight(),resolution.getScaleH());

            stage.setWidth(resolution.getWidth(resolution.getScaleW()));
            stage.setHeight(resolution.getHeight(resolution.getScaleH()));
            manager.showVolume();
        });

        backButton.setOnAction(e -> manager.showOptions());
    }
    private void setProperties()
    {
        volumeSlider.setMajorTickUnit(1);
        volumeSlider.setMinorTickCount(0);
        volumeSlider.setSnapToTicks(true);
        volumeSlider.setShowTickLabels(true);
    }
    private void setupBackground()
    {
        final String path = "/application/labyrinth/assets/Images/audioVideoBg.jpg";

        Image backgroundImage = new Image
        (
                Objects.requireNonNull(getClass().getResource(path)).toExternalForm()
        );

        backgroundImg.setImage(backgroundImage);
        backgroundImg.setFitWidth(resolution.getScreenWidth());
        backgroundImg.setFitHeight(resolution.getScreenHeight());
    }
}

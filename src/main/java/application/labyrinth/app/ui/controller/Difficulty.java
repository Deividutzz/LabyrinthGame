package application.labyrinth.app.ui.controller;

import application.labyrinth.app.game.GameResolution;
import application.labyrinth.app.ui.menu.SceneManager;
import application.labyrinth.app.ui.options.OptionsController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Paint;

import java.awt.*;
import java.util.Objects;

public class Difficulty
{
    @FXML private Slider enemiesSlider;
    @FXML private Slider obstaclesSlider;
    @FXML private Slider speedSlider;
    @FXML private Button backButton;
    @FXML private ImageView backgroundImg;
    @FXML private Label enemiesLabel;
    @FXML private Label obstaclesLabel;
    @FXML private Label speedLabel;

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
        setSliders();
        setLabels();

        enemiesSlider.valueProperty().addListener((o, ov, nv) ->
                controller.setEnemies(nv.intValue())
        );

        obstaclesSlider.valueProperty().addListener((o, ov, nv) ->
                controller.setObstacles(nv.intValue())
        );

        speedSlider.valueProperty().addListener((o,ov,nv) ->
                controller.setSpeed(nv.intValue())
        );

        backButton.setOnAction(e -> manager.showOptions());
    }
    private void setupBackground()
    {
        final String path = "/application/labyrinth/assets/Images/difficultyBg.jpg";

        Image backgroundImage = new Image
        (
                Objects.requireNonNull(getClass().getResource(path)).toExternalForm()
        );

        backgroundImg.setImage(backgroundImage);
        backgroundImg.setFitWidth(resolution.getScreenWidth());
        backgroundImg.setFitHeight(resolution.getScreenHeight());
    }

    private void setSliders()
    {
        setValue();
        setProperties();
    }
    private void setValue()
    {
        enemiesSlider.setValue(controller.getEnemies());
        obstaclesSlider.setValue(controller.getObstacles());
        speedSlider.setValue(controller.getSpeed());
    }
    private void setProperties()
    {
        enemiesSlider.setMajorTickUnit(1);
        enemiesSlider.setMinorTickCount(0);
        enemiesSlider.setSnapToTicks(true);
        enemiesSlider.setShowTickLabels(true);

        obstaclesSlider.setMajorTickUnit(10);
        obstaclesSlider.setMinorTickCount(0);
        obstaclesSlider.setSnapToTicks(true);
        obstaclesSlider.setShowTickLabels(true);

        speedSlider.setMajorTickUnit(1);
        speedSlider.setMinorTickCount(0);
        speedSlider.setSnapToTicks(true);
        speedSlider.setShowTickLabels(true);
    }
    private void setLabels()
    {
        enemiesLabel.setLineSpacing(20);
        obstaclesLabel.setLineSpacing(20);
        speedLabel.setLineSpacing(20);


    }
}
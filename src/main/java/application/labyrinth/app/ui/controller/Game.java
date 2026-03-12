package application.labyrinth.app.ui.controller;

import application.labyrinth.app.fx.FxGameRenderer;
import application.labyrinth.app.game.GameResolution;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Objects;

public class Game
{
    @FXML
    private Pane staticLayer;

    @FXML
    private Pane entityLayer;

    private FxGameRenderer renderer;

    public void init(GameResolution resolution) {
        renderer = new FxGameRenderer(staticLayer, entityLayer, resolution);
    }

    public FxGameRenderer getRenderer() {
        return renderer;
    }
}
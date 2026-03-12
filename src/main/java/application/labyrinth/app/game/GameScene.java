package application.labyrinth.app.game;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Scale;

public class GameScene
{
    private final Scene scene;
    private final Scale scale;

    public GameScene(StackPane gameRoot, Parent gamePane, GameResolution resolution)
    {
        final double gameWidth = resolution.getWidth(resolution.getScaleW());
        final double gameHeight = resolution.getHeight(resolution.getScaleH());
        this.scale = getWindowScale(gameRoot,gamePane, resolution.getScreenWidth(), resolution.getScreenHeight());
        this.scene = resolution.createScene(gameRoot, gameWidth, gameHeight);
        StackPane.setAlignment(gamePane, Pos.CENTER);
    }

    private Scale getWindowScale(StackPane root, Parent gamePane, double gameWidth, double gameHeight)
    {
        DoubleBinding scaleFactor = (DoubleBinding) Bindings.min(
                root.widthProperty().divide(gameWidth),
                root.heightProperty().divide(gameHeight)
        );

        Scale scale = new Scale();
        scale.xProperty().bind(scaleFactor);
        scale.yProperty().bind(scaleFactor);

        gamePane.getTransforms().add(scale);
        return scale;
    }
    public Scene getScene()
    {
        return scene;
    }
    public Scale getScale() {return scale;}
}
 /*
        scheme:
        i need a stackpane that is the root (parent) for the scene
        Pane for adding the elements into the root
        binding the scale proportional with the window size
         */
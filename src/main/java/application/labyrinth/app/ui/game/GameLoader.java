package application.labyrinth.app.ui.game;

import application.labyrinth.app.fx.FxGameRenderer;
import javafx.scene.Parent;

public class GameLoader
{
    private final Parent root;
    private final FxGameRenderer renderer;

    public GameLoader(Parent root, FxGameRenderer renderer)
    {
        this.root = root;
        this.renderer = renderer;
    }

    public Parent getRoot() { return root; }
    public FxGameRenderer getRenderer() { return renderer; }
}
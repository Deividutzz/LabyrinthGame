package application.labyrinth.app.fx;

import application.labyrinth.app.game.GameController;
import application.labyrinth.domain.model.Direction;
import javafx.scene.Scene;

public class FxInputHandler
{
    private final Scene scene;
    private final GameController controller;
    public FxInputHandler(Scene scene, GameController controller)
    {
        this.scene = scene;
        this.controller = controller;
    }
    public void setInput()
    {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode())
            {
                case W -> controller.move(Direction.UP);
                case A -> controller.move(Direction.LEFT);
                case S -> controller.move(Direction.DOWN);
                case D -> controller.move(Direction.RIGHT);
                case ESCAPE -> controller.pause();
            }
        });
    }
}
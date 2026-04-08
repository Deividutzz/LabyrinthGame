package application.labyrinth.app.fx;

import application.labyrinth.app.game.GameController;
import application.labyrinth.domain.model.Direction;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

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
                case W, KeyCode.UP -> controller.move(Direction.UP);
                case A, KeyCode.LEFT -> controller.move(Direction.LEFT);
                case S, KeyCode.DOWN -> controller.move(Direction.DOWN);
                case D, KeyCode.RIGHT -> controller.move(Direction.RIGHT);
                case ESCAPE -> controller.pause();
            }
        });
    }
}
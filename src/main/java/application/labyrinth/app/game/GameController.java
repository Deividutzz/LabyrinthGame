package application.labyrinth.app.game;

import application.labyrinth.domain.model.Direction;

public class GameController
{

    private GameEngine engine;

    public void setEngine(GameEngine engine)
    {
        this.engine = engine;
    }

    public void move(Direction dir)
    {
        if (engine != null) {
            engine.movePlayer(dir);
        }
    }
    public void pause()
    {
        if (engine != null) {
            engine.setGamePaused(!engine.isGamePaused());
        }
    }
}


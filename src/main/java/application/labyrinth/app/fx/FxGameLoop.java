package application.labyrinth.app.fx;

import application.labyrinth.app.game.GameEngine;
import application.labyrinth.app.game.GameFlowController;
import javafx.animation.AnimationTimer;

public class FxGameLoop extends AnimationTimer
{

    private GameEngine engine;
    private final FxGameRenderer renderer;
    private GameFlowController controller;

    public FxGameLoop(FxGameRenderer renderer)
    {
        this.renderer = renderer;
    }

    public void start(GameEngine engine, GameFlowController controller)
    {
        this.engine = engine;
        this.controller = controller;
        super.start();
        renderer.renderStatic(engine.getView());
    }

    @Override
    public void handle(long now) {
        engine.pauseTimer();
        if(!engine.isGamePaused())
        {
            if(engine.pauseTimer())
                engine.resumeTimer();

            engine.updateEnemies();
            renderer.renderDynamic(engine.getView());
            if (engine.isGameOver())
                controller.handleEnding();
        }
    }
}

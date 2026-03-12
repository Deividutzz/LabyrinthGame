package application.labyrinth.app.game;

import application.labyrinth.app.fx.FxGameLoop;
import application.labyrinth.app.ui.menu.SceneManager;

public class GameFlowController
{

    private final GameConfig config;
    private final GameBuilder builder;
    private final SceneManager sceneManager;
    private final FxGameLoop loop;
    private final GameController gameController;

    public GameFlowController(
            GameConfig config,
            GameBuilder builder,
            FxGameLoop loop,
            GameController gameController,
            SceneManager sceneManager)
    {
        this.config = config;
        this.builder = builder;
        this.loop = loop;
        this.gameController = gameController;
        this.sceneManager = sceneManager;
    }

    public void startGame()
    {
        GameEngine engine = builder.create(config);
        gameController.setEngine(engine);
        loop.start(engine,this);
        sceneManager.showGame();
    }

    public void handleEnding()
    {
        loop.stop();
        config.delete();
        sceneManager.showEndGame();
    }
}

package application.labyrinth.app.game;

import application.labyrinth.app.ending.GameEndedScene;
import application.labyrinth.app.fx.FxGameLoop;
import application.labyrinth.app.ui.controller.GameEnded;
import application.labyrinth.app.ui.menu.SceneManager;

public class GameFlowController
{

    private final GameConfig config;
    private final GameBuilder builder;
    private final SceneManager sceneManager;
    private final FxGameLoop loop;
    private final GameController gameController;
    private final GameStats gameStats;
    private GameEndedScene gameEnded;

    public GameFlowController(
            GameConfig config,
            GameBuilder builder,
            FxGameLoop loop,
            GameController gameController,
            SceneManager sceneManager,
            GameStats gameStats)
    {
        this.config = config;
        this.builder = builder;
        this.loop = loop;
        this.gameController = gameController;
        this.sceneManager = sceneManager;
        this.gameStats = gameStats;
    }

    public void startGame()
    {
        GameEngine engine = builder.create(config,gameStats);
        gameController.setEngine(engine);
        loop.start(engine,this);
        sceneManager.showGame();
    }

    public void handleEnding()
    {
        loop.stop();
        config.delete();
        sceneManager.showEndGame();
        gameStats.resetTimer();
        gameEnded.getEndedCntrllr().setupStats();
    }

    public void injectEndGame(GameEndedScene gameEnd)
    {
        gameEnded = gameEnd;
    }
}

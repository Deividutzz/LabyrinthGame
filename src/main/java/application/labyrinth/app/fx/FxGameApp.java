package application.labyrinth.app.fx;

import application.labyrinth.app.ending.GameEndedScene;
import application.labyrinth.app.ui.controller.Game;
import application.labyrinth.app.ui.controller.Sound;
import application.labyrinth.app.ui.fxml.FxmlConfig;
import application.labyrinth.app.ui.game.GameLoader;
import application.labyrinth.app.ui.menu.*;
import application.labyrinth.app.game.*;
import com.almasb.fxgl.app.FXGLApplication;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FxGameApp extends Application
{
    public void start(Stage stage)
    {
        GameStats gameStats = new GameStats();
        GameResolution resolution = new GameResolution();
        SoundtrackManager soundtrack = new SoundtrackManager();
        soundtrack.play();

        declareStage(stage,resolution);

        /// Classes that are needed everywhere:

        GameConfig config = new GameConfig();
        SceneManager sceneManager = new SceneManager(stage,resolution);
        GameBuilder gameBuild = new GameBuilder();

        StackPane gameRoot = new StackPane();

        /// Flow and application logic creation:

        GameLoader gameLoader = loadGameUi(resolution);
        FxGameRenderer renderer = gameLoader.getRenderer();
        Parent root = gameLoader.getRoot();

        gameRoot.getChildren().clear();
        gameRoot.getChildren().add(root);
        GameScene gameScene = new GameScene(gameRoot,root,resolution);

        FxGameLoop loop = new FxGameLoop(renderer);
        GameController gameController = new GameController();

        GameFlowController flow = new GameFlowController(
                config,
                gameBuild,
                loop,
                gameController,
                sceneManager,
                gameStats
        );

        /// Input declaration:

        FxInputHandler inputHandler =
                new FxInputHandler(gameScene.getScene(), gameController);
        inputHandler.setInput();

        /// Scenes creation:

        SceneCreator sceneCreator = new SceneCreator(sceneManager,config,flow,gameScene,resolution,soundtrack);
        sceneCreator.create();

        GameEndedScene endGame = new GameEndedScene(sceneManager,sceneCreator,resolution,gameStats);
        sceneManager.setEndGame(endGame.getScene());
        flow.injectEndGame(endGame);

        sceneManager.showMainMenu();
        stage.setTitle("Labyrinth Game");

        stage.setWidth(resolution.getWidth(resolution.getScaleW()));
        stage.setHeight(resolution.getHeight(resolution.getScaleH()));

        stage.show();
        /// x = 292 si y = 183 (stage coord)
    }
    public static void main(String[] args) {
        Application.launch(FxGameApp.class, args);
    }

    private void declareStage(Stage stage, GameResolution resolution)
    {
        final double GAME_WIDTH  = 1024;
        final double GAME_HEIGHT = 580;

        stage.setMinWidth(GAME_WIDTH);
        stage.setMinHeight(GAME_HEIGHT);

        stage.setWidth(GAME_WIDTH);
        stage.setHeight(GAME_HEIGHT);

        final double GAME_RATIO = GAME_WIDTH / GAME_HEIGHT;
        PauseTransition resizePause = new PauseTransition(Duration.millis(80));

        stage.widthProperty().addListener((obs, oldW, newW) -> {
            resizePause.setOnFinished(e ->
                    stage.setHeight(stage.getWidth() / GAME_RATIO)
            );
            resizePause.playFromStart();
        });
    }
    private GameLoader loadGameUi(GameResolution resolution)
    {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/application/labyrinth/ui/fxml/Game.fxml")
            );

            Parent root = loader.load();

            Game controller = loader.getController();
            controller.init(resolution);

            FxGameRenderer renderer = controller.getRenderer();

            return new GameLoader(root, renderer);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load Game UI", e);
        }
    }
}
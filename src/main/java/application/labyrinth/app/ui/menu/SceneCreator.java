package application.labyrinth.app.ui.menu;

import application.labyrinth.app.game.GameConfig;
import application.labyrinth.app.game.GameFlowController;
import application.labyrinth.app.game.GameResolution;
import application.labyrinth.app.game.GameScene;
import application.labyrinth.app.ui.options.DifficultyScene;
import application.labyrinth.app.ui.options.OptionsController;
import application.labyrinth.app.ui.options.OptionsScene;
import application.labyrinth.app.ui.options.SoundScene;
import javafx.stage.Stage;

public class SceneCreator
{
    private final SceneManager sceneManager;
    private DifficultyScene difficultyScene;
    private final MainMenuScene mainScene;
    private OptionsScene optionsScene;
    private final GameConfig config;
    private SoundScene soundScene;
    private final GameResolution resolution;

    public SceneCreator(SceneManager sceneManager, GameConfig config, GameFlowController flow, GameScene gameScene, GameResolution resolution)
    {
        this.config = config;
        this.sceneManager = sceneManager;
        this.resolution = resolution;
        OptionsController optionsController = new OptionsController(config);
        this.optionsScene = new OptionsScene(sceneManager,resolution);
        this.mainScene = new MainMenuScene(sceneManager,flow,resolution);
        this.difficultyScene = new DifficultyScene(sceneManager,optionsController,resolution);
        this.soundScene = new SoundScene(sceneManager,optionsController,resolution);
        sceneManager.setGame(gameScene.getScene());
    }
    public void create()
    {
        OptionsController optionsController = new OptionsController(config);
        optionsScene = new OptionsScene(sceneManager,resolution);
        difficultyScene = new DifficultyScene(sceneManager,optionsController,resolution);
        soundScene = new SoundScene(sceneManager,optionsController,resolution);
        sceneManager.setMainMenu(mainScene.getScene());
        sceneManager.setOptions(optionsScene.getScene());
        sceneManager.setDifficulty(difficultyScene.getScene());
        sceneManager.setVolume(soundScene.getScene());
    }
    public void delete()
    {
        sceneManager.delete(optionsScene.getScene());
        sceneManager.delete(difficultyScene.getScene());
        sceneManager.delete(soundScene.getScene());

        // this method is not working
    }
}
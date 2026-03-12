package application.labyrinth.app.ui.options;

import application.labyrinth.app.game.GameConfig;

public class OptionsController
{
    private final GameConfig config;

    public OptionsController(GameConfig config)
    {
        this.config = config;
    }

    public void setEnemies(int value)
    {
        config.setNrEnemies(value);
    }

    public void setObstacles(int value)
    {
        config.setNrObstacles(value);
    }

    public void setVolume(int value)
    {
        config.setSoundVolume(value);
    }

    public void setSpeed(int value) {config.setEnemySpeed(value);}

    public int getEnemies()
    {
        return config.getNrEnemies();
    }
    public int getObstacles()
    {
        return config.getNrObstacles();
    }
    public int getVolume()
    {
        return config.getSoundVolume();
    }
    public int getSpeed()
    {
        return config.getEnemySpeed();
    }
}
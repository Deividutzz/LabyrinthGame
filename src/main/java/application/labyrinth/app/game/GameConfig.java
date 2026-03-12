package application.labyrinth.app.game;

public class GameConfig
{
    private int numberOfEnemies = 1;
    private int numberOfObstacles = 70;
    private int soundVolume = 8;
    private int enemySpeed = 7;
    private final int mazeLength = 16;

    public void setNrEnemies(int number)
    {
        numberOfEnemies = number;
    }
    public void setNrObstacles(int number)
    {
        numberOfObstacles = number;
    }
    public void setSoundVolume(int number)
    {
        soundVolume = number;
    }
    public void setEnemySpeed(int number) {enemySpeed = number;}
    public int getNrEnemies()
    {
        return numberOfEnemies;
    }
    public int getNrObstacles()
    {
        return numberOfObstacles;
    }
    public int getSoundVolume()
    {
        return soundVolume;
    }
    public int getEnemySpeed() {return enemySpeed;}
    public int getMazeLength()
    {
        return mazeLength;
    }
    public void delete()
    {
        numberOfEnemies = 1;
        numberOfObstacles = 70;
        soundVolume = 8;
        enemySpeed = 7;
    }
}
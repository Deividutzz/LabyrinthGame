package application.labyrinth.domain.model;

import java.util.ArrayList;
import java.util.List;

public class GameState
{
    private boolean gameOver = false;
    private int score = 0;
    private boolean playerMoved = false;
    private List <Boolean> enemyMoved = new ArrayList<Boolean>();
    private boolean gamePaused = false;

    public void setGameOver(boolean over) { this.gameOver = over; }
    public void setScore(int score) { this.score = score; }
    public boolean isGameOver() { return gameOver; }
    public int getScore() { return score; }
    public boolean playerMoved() { return playerMoved; }
    public void setPlayerState(boolean playerMoved) { this.playerMoved = playerMoved; }
    public List <Boolean> enemyMoved() { return enemyMoved; }
    public void setEnemyState(boolean state, int index)
    {
        enemyMoved.set(index, state);
    }
    public void setGamePaused(boolean gamePaused) { this.gamePaused = gamePaused; }
    public boolean isGamePaused() { return gamePaused; }
}
package application.labyrinth.app.game;

import application.labyrinth.domain.model.*;
import application.labyrinth.domain.service.*;
import application.labyrinth.app.view.*;

import java.util.ArrayList;
import java.util.List;

public class GameEngine
{
    private final Maze maze;
    private final List<Enemy> enemies;
    private final Player player;
    private final GameState gameState;

    private final MovementService movementService;
    private final EnemyChaseService enemyChaseService;

    private int enemyTickCounter = 0;
    private final int enemyMoveDelay;
    private final int enemySpeed;

    public GameEngine(Player player,
                      List<Enemy> enemies,
                      Maze maze,
                      GameState gameState,
                      MovementService movementService,
                      EnemyChaseService enemyChaseService,
                      int speedDiff)
    {
        this.player = player;
        this.enemies = enemies;
        this.maze = maze;
        this.gameState = gameState;
        this.movementService = movementService;
        this.enemyChaseService = enemyChaseService;
        this.enemySpeed = speedDiff;
        enemyMoveDelay = computeEnemySpeed();
    }
    public void movePlayer(Direction direction)
    {
        gameState.setPlayerState(getView().entityState().playerMoved());
        int x = player.getCoordX() + direction.dx();
        int y = player.getCoordY() + direction.dy();
        if (movementService.canMove(maze, x, y))
        {
            gameState.playerMoved();
            player.setCoordXY(x,y);
        }
    }
    public void updateEnemies()
    {
        if(gameState.isGameOver())
            return ;

        enemyTickCounter ++;
        if(enemyTickCounter < enemyMoveDelay)
            return ;
        enemyTickCounter = 0;

        for(Enemy enemy : enemies)
        {
            Direction move = enemyChaseService.nextMove(maze,player, enemy);

            if(move != null)
            {
                int newX = enemy.getCoordX() + move.dx();
                int newY = enemy.getCoordY() + move.dy();
                enemy.setCoordXY(newX,newY);
            }

            if(enemy.getCoordX() == player.getCoordX()
                    && enemy.getCoordY() == player.getCoordY())
            {
                gameState.setGameOver(true);
            }
        }
    }

    public boolean isGameOver()
    {
        return gameState.isGameOver();
    }
    public boolean isGamePaused() {return gameState.isGamePaused();}
    public void setGamePaused(boolean state) {gameState.setGamePaused(state);}

    public GameView getView()
    {
        List<EnemyView> enemiesView = new ArrayList<>();

        for (Enemy enemy : enemies)
        {
            enemiesView.add(
                    new EnemyView(enemy.getCoordX(), enemy.getCoordY())
            );
        }
        return new GameView(
                new PlayerView(player.getCoordX(), player.getCoordY()),
                enemiesView,
                new MazeView(maze.getCopy()),
                gameState.isGameOver(),
                new GameStateView(gameState.playerMoved(), gameState.enemyMoved())
        );
    }

    private int computeEnemySpeed()
    {
        final int coef = 5;
        int speed = 70;
        /// ^ default variables

        return speed - coef*enemySpeed;
    }
}
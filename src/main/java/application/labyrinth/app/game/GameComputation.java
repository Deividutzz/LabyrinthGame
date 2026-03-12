package application.labyrinth.app.game;

import application.labyrinth.domain.model.Enemy;
import application.labyrinth.domain.model.Maze;
import application.labyrinth.domain.model.Player;
import application.labyrinth.domain.service.EnemyService;
import application.labyrinth.domain.service.MazeGeneratorService;
import application.labyrinth.domain.service.MazeService;
import application.labyrinth.domain.service.PlayerService;

import java.util.List;

public class GameComputation
{
    private Player player;
    private List<Enemy> enemies;
    private Maze maze;

    public void create(GameConfig config)
    {
        maze = new Maze(config.getMazeLength());
        maze.setObstacles(config.getNrObstacles());
        MazeService mazeService = new MazeService();

        PlayerService playerService = new PlayerService();
        player = playerService.createPlayer(maze, mazeService);

        EnemyService enemyService = new EnemyService();
        enemies = enemyService.createEnemies(maze, mazeService, config.getNrEnemies());

        MazeGeneratorService mazeGen = new MazeGeneratorService();

        mazeGen.generateMaze(maze, player, enemies);
    }
    public Player getPlayer() {return player;}
    public List <Enemy> getEnemies() {return enemies;}
    public Maze getMaze() {return maze;}
    public MazeService getMazeServ() {return new MazeService();}
}
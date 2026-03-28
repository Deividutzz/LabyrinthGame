package application.labyrinth.app.game;

import application.labyrinth.domain.model.*;
import application.labyrinth.domain.service.*;

import java.util.List;

public class GameBuilder
{
    public GameEngine create(GameConfig config, GameStats stats)
    {
        Volume volume = new Volume();
        volume.setVolume(config.getSoundVolume());

        GameComputation computation = new GameComputation();
        computation.create(config);

        Player player = computation.getPlayer();
        List <Enemy> enemies = computation.getEnemies();
        Maze maze = computation.getMaze();
        MazeService mazeService = computation.getMazeServ();

        GameState gameState = new GameState();
        MovementService movementService = new MovementService(mazeService);
        PathfindingService pathfinding = new PathfindingService();
        EnemyChaseService chaseService = new EnemyChaseService(pathfinding);

        return new GameEngine(
                player,
                enemies,
                maze,
                gameState,
                movementService,
                chaseService,
                config.getEnemySpeed(),
                stats
        );
    }
}
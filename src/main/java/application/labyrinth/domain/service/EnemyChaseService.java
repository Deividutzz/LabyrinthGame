package application.labyrinth.domain.service;

import application.labyrinth.domain.model.Direction;
import application.labyrinth.domain.model.Enemy;
import application.labyrinth.domain.model.Maze;
import application.labyrinth.domain.model.Player;

import java.util.Stack;

public class EnemyChaseService
{
    private final PathfindingService pathService;
    public EnemyChaseService(PathfindingService pathService)
    {
        this.pathService = pathService;
    }
    public Direction nextMove(Maze maze, Player player, Enemy enemy)
    {
        Stack<int[]> path = pathService.computePath(
                maze,
                enemy.getCoordX(), enemy.getCoordY(),
                player.getCoordX(), player.getCoordY()
        );

        if (path == null || path.isEmpty()) return null;

        int topX = path.peek()[0];
        int topY = path.peek()[1];

        int coefX = topX - enemy.getCoordX();
        int coefY = topY - enemy.getCoordY();

        for(Direction dir : Direction.values())
        {
            if(coefX == dir.dx() && coefY == dir.dy())
                return dir;
        }
        return null;
    }
    /// compute the next move (later)
}
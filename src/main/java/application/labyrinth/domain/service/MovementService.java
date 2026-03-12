package application.labyrinth.domain.service;

import application.labyrinth.domain.service.MazeService;
import application.labyrinth.domain.model.Maze;
import application.labyrinth.domain.model.Player;

public class MovementService
{
    private final MazeService mazeService;

    public MovementService(MazeService mazeService)
    {
        this.mazeService = mazeService;
    }
    public boolean canMove(Maze maze, int x, int y)
    {
        return mazeService.isWalkable(maze, x, y);
    }
    public boolean movePlayer(Maze maze, Player player, int newX, int newY)
    {
        if(canMove(maze, newX, newY))
            player.setCoordXY(newX, newY);
        return canMove(maze, newX, newY);
    }
}
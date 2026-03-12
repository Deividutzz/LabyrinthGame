package application.labyrinth.domain.service;
import application.labyrinth.domain.model.Maze;

public class MazeService
{
    public boolean isInside(Maze maze, int x, int y)
    {
        int size = maze.length();
        return x >= 0 && x < size && y >= 0 && y < size;
    }

    public boolean isWalkable(Maze maze, int x, int y)
    {
        return isInside(maze, x, y) && maze.getCell(x,y) == 0;
    }
}
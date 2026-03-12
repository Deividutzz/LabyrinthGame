package application.labyrinth.domain.service;

import application.labyrinth.domain.model.Enemy;
import application.labyrinth.domain.model.Maze;
import application.labyrinth.domain.model.Player;

import java.util.List;
import java.util.Random;

public class MazeGeneratorService
{
    private void initialize(Maze maze)
    {
        int size = maze.length();
        for(int x = 0; x < size; x++)
        {
            for(int y = 0; y < size; y++)
            {
                maze.setCell(x,y,0);
            }
        }
    }
    private void compute(Maze maze, int x1, int y1)
    {
        int placed = 0;
        initialize(maze);
        int size = maze.length();
        Random random = new Random();
        int nrObstacles = maze.getObstacles();
        while(placed < nrObstacles)
        {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            if(maze.getCell(x, y) == 0 && !(x == x1 && y == y1))
            {
                maze.setCell(x, y,-1);
                placed ++;
            }
        }
    }
    public void generateMaze(Maze maze, Player player, List<Enemy> enemies)
    {
        PathfindingService pathfinding = new PathfindingService();

        int xStart = player.getCoordX();
        int yStart = player.getCoordY();
        boolean valid = false;
        while(!valid)
        {
            valid = true;
            compute(maze,xStart,yStart);
            for(Enemy enemy : enemies)
            {
                int xEnd = enemy.getCoordX();
                int yEnd = enemy.getCoordY();
                pathfinding.computePath(maze, xStart, yStart, xEnd, yEnd);
                if(!pathfinding.existsPath())
                {
                    valid = false;
                    break;
                }
                if(pathfinding.getDistance() < 6)
                {
                    valid = false;
                    break;
                }
            }
        }
    }
}
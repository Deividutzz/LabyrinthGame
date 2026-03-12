package application.labyrinth.domain.service;

import application.labyrinth.domain.model.*;

import java.util.*;

public class EnemyService
{
    private final Random rand = new Random();
    public List <Enemy> createEnemies(Maze maze, MazeService mazeService, int numberOfEnemies)
    {
        List <Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < numberOfEnemies; i++)
        {
            int size = maze.length();
            int id = rand.nextInt(512-256+1) + 256;
            int x = 0;
            int y = 0;
            do {
                x = rand.nextInt(size);
                y = rand.nextInt(size);
            } while (!mazeService.isWalkable(maze, x, y));
            Enemy enemy = new Enemy(id,x,y);
            enemies.add(enemy);
        }
        return enemies;
    }
}
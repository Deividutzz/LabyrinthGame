package application.labyrinth.domain.service;

import application.labyrinth.domain.model.Maze;
import application.labyrinth.domain.model.Player;

import java.util.Random;

public class PlayerService
{
    private final Random random = new Random();

    public Player createPlayer(Maze maze, MazeService mazeService)
    {
        int size = maze.length();
        int id = random.nextInt(256-128+1) + 128;
        int x, y;
        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        }while(!mazeService.isWalkable(maze, x, y));
        Player player = new Player("Player",x,y);
        player.setID(id);
        return player;
    }
}

package application.labyrinth.domain.model;

public class Maze
{
    private int size;
    private int[][] maze;
    private int obstacles = 0;
    public Maze(int size)
    {
        this.size = size;
        this.maze = new int[size][size];
    }
    public void setCell(int x, int y, int number)
    {
        maze[x][y] = number;
    }
    public void setObstacles(int number)
    {
        obstacles = number;
    }
    public int[][] getCopy()
    {
        int[][] copy = new int[size][size];
        for(int i = 0; i < size; i++)
        {
            System.arraycopy(maze[i], 0, copy[i], 0, size);
        }
        return copy;
    }
    public int getCell(int x, int y)
    {
        return maze[x][y];
    }
    public int getObstacles()
    {
        return obstacles;
    }
    public int length()
    {
        return size;
    }
}
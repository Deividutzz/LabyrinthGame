package application.labyrinth.domain.service;

import application.labyrinth.domain.model.Maze;
import java.util.*;

public class PathfindingService
{
    private boolean exists = false;
    private int distance = 0;
    private int[][] parentx;
    private int[][] parenty;
    private int[] getPair(int x, int y)
    {
        return new int[]{x,y};
    }
    private boolean isIn(int x, int y, int size)
    {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
    private void bfs(Maze maze, int xStart, int yStart, int xEnd, int yEnd)
    {
        distance = 0;
        exists = false;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        int size = maze.length();
        int[][] dist = new int[size][size];

        parentx = new int[size][size];
        parenty = new int[size][size];

        for (int i = 0; i < size; i++)
        {
            Arrays.fill(dist[i], -1);
            Arrays.fill(parentx[i], -1);
            Arrays.fill(parenty[i], -1);
        }

        dist[xStart][yStart] = 0;

        Queue <int[]> queue = new LinkedList<>();
        queue.add(getPair(xStart,yStart));
        while(!queue.isEmpty())
        {
            int[] poz = queue.poll();
            int x = poz[0];
            int y = poz[1];
            for(int k = 0; k < dx.length; k++)
            {
                int xk = x + dx[k];
                int yk = y + dy[k];
                if(isIn(xk,yk,size) && dist[xk][yk] == -1 && maze.getCell(xk,yk) == 0)
                {
                    dist[xk][yk] = dist[x][y] + 1;
                    queue.add(getPair(xk,yk));
                    parentx[xk][yk] = x;
                    parenty[xk][yk] = y;
                }
            }
        }

        if(dist[xEnd][yEnd] > 0)
            exists = true;
        distance = dist[xEnd][yEnd];
    }
    private Stack <int[]> reconstrPath(int xStart, int yStart, int xFinal, int yFinal)
    {
        Stack <int[]> path = new Stack<>();
        int x = xFinal;
        int y = yFinal;

        if (parentx[x][y] == -1)
        {
            return path;
        }

        while(!(x == xStart && y == yStart))
        {
            path.push(getPair(x, y));
            int px = parentx[x][y];
            int py = parenty[x][y];
            x = px;
            y = py;
        }
        return path;
    }
    public Stack <int[]> computePath(Maze maze, int xStart, int yStart, int xFinal, int yFinal)
    {
        bfs(maze,xStart,yStart,xFinal,yFinal);
        return reconstrPath(xStart,yStart,xFinal,yFinal);
    }
    public boolean existsPath() {return exists;}
    public int getDistance() {return distance;}
}
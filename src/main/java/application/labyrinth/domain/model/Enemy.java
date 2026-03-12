package application.labyrinth.domain.model;

public class Enemy
{
    private int id;
    private int coordX = 0;
    private int coordY = 0;
    public Enemy (int id, int coordX, int coordY)
    {
        this.id = id;
        setCoordXY(coordX, coordY);
    }
    public void setCoordXY(int x, int y)
    {
        this.coordX = x;
        this.coordY = y;
    }
    public int getCoordX()
    {
        return coordX;
    }
    public int getCoordY()
    {
        return coordY;
    }
    public int getId()
    {
        return id;
    }
}
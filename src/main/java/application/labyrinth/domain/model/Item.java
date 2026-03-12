package application.labyrinth.domain.model;

public class Item
{
    private int id;
    private int coordX;
    private int coordY;
    public Item(int id, int coordX, int coordY)
    {
        this.id = id;
        this.coordX = coordX;
        this.coordY = coordY;
    }
    public int getId()
    {
        return id;
    }
    public int getCoordX()
    {
        return coordX;
    }
    public int getCoordY()
    {
        return coordY;
    }
}
package application.labyrinth.domain.model;

public class Player
{
    private String name;
    private int itemsCollected = 0;
    private int playerID = 0;
    private int coordX = 0;
    private int coordY = 0;

    public Player (String name, int coordX, int coordY)
    {
        this.name = name;
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
    public void setItems(int number)
    {
        this.itemsCollected = number;
    }
    public void ittItems(int coef)
    {
        this.itemsCollected += coef;
    }
    public int getItems()
    {
        return itemsCollected;
    }
    public String getName()
    {
        return name;
    }
    public void setID(int id)
    {
        this.playerID = id;
    }
    public int getID()
    {
        return playerID;
    }
}

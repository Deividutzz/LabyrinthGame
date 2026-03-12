package application.labyrinth.domain.model;

public class MazeTile
{
    private boolean walkable;
    private boolean hasItem;

    public MazeTile(boolean walkable)
    {
        this.walkable = walkable;
        this.hasItem = false;
    }

    public boolean isWalkable() { return walkable; }
    public boolean hasItem() { return hasItem; }

    public void setWalkable(boolean value) { walkable = value; }
    public void setItem(boolean value) { hasItem = value; }
}
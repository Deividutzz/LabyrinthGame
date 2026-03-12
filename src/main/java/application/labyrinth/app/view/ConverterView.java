package application.labyrinth.app.view;

public record ConverterView(double cellSize, double offsetX, double offsetY)
{
    public double toPixelX(int gridX)
    {
        return offsetX + gridX * cellSize;
    }
    public double toPixelY(int gridY)
    {
        return offsetY + gridY * cellSize;
    }
}
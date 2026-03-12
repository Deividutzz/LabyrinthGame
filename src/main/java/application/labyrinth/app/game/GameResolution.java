package application.labyrinth.app.game;

import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;

public class GameResolution
{
    private final double screenWidth;
    private final double screenHeight;
    private double width;
    private double height;
    private double scaleW = 0.834;
    private double scaleH = 0.834;
    private final int stageX = 292;
    private final int stageY = 183;

    public GameResolution()
    {
        Screen screen = Screen.getPrimary();
        Rectangle2D screenBounds = screen.getVisualBounds();

        screenWidth = screenBounds.getWidth();
        screenHeight = screenBounds.getHeight();

        width = (screenWidth * scaleW);
        height = (screenHeight * scaleH);
    }
    public double getWidth(double scale)
    {
        return width*scale;
    }
    public double getHeight(double scale)
    {
        return height*scale;
    }
    public void setWidth(double width, double scale)
    {
        this.width = width * scale;
    }
    public void setHeight(double height, double scale)
    {
        this.height = height * scale;
    }
    public void setScaleW(double scale)
    {
        this.scaleW = scale;
    }
    public double getScaleW()
    {
        return scaleW;
    }
    public void setScaleH(double scale)
    {
        this.scaleH = scale;
    }
    public double getScaleH()
    {
        return scaleH;
    }
    public Scene createScene(Parent root, double scaleW, double scaleH)
    {
        double width = getWidth(scaleW);
        double height = getHeight(scaleH);
        return new Scene(root, width, height);
    }
    public void resetToDefault()
    {
        scaleW = 0.834;
        scaleH = 0.834;
    }
    public double getScreenWidth() {return screenWidth;}
    public double getScreenHeight() {return screenHeight;}

    public int getStageX() {return stageX;}
    public int getStageY() {return stageY;}
}
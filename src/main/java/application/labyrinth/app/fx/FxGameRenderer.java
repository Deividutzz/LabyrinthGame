package application.labyrinth.app.fx;

import application.labyrinth.app.game.GameResolution;
import application.labyrinth.app.view.ConverterView;
import application.labyrinth.app.view.EnemyView;
import application.labyrinth.app.view.GameView;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FxGameRenderer
{
    //private final StackPane game;
    private Parent root;
    private final Pane staticLayer;
    private final Pane entityLayer;
    private ImageView player;
    private List <ImageView> enemies = new ArrayList<>();
    private double dimension;
    private double startingPointx;
    private double startingPointy;
    private final GameResolution resolution;
    private final List <ImageView> enemiesImages = new ArrayList<>();
    private final String imagesPath = "/application/labyrinth/assets/Images/";

    public FxGameRenderer(Pane staticLayer,
                          Pane entityLayer,
                          GameResolution resolution) {

        this.staticLayer = staticLayer;
        this.entityLayer = entityLayer;
        this.resolution = resolution;

        calculateCoord();
        buildImagesList();
    }
    public void renderStatic(GameView view)
    {
        staticLayer.getChildren().clear();
        entityLayer.getChildren().clear();

        drawBackGr();
        drawMaze(view);
        player = drawPlayer(view);
        enemies = drawEnemies(view);
    }
    public void renderDynamic(GameView view)
    {
        updatePlayer(view);
        updateEnemies(view);
    }
    public Parent getGameRoot()
    {
        return root;
    }
    private void buildImagesList()
    {
        for(int i = 0; i < 6; i++)
        {
            String path;
            if(i == 0)
            {
                path = imagesPath + "DarkBowser.gif";
            }
            else if(i == 1)
            {
                path = imagesPath + "Wario.png";
            }
            else if(i == 2)
            {
                path = imagesPath + "FunkyKong.png";
            }
            else if(i == 3)
            {
                path = imagesPath + "Yoshi.png";
            }
            else if(i == 4)
            {
                path = imagesPath + "Luigi.png";
            }
            else
            {
                path = imagesPath + "Eggman.png";
            }

            Image enemyImg = new Image
            (
                    Objects.requireNonNull(getClass().getResource(path)).toExternalForm()
            );
            ImageView enemy = new ImageView(enemyImg);
            enemiesImages.add(enemy);
        }
    }
    private void calculateCoord()
    {
        final double windowWidth = resolution.getScreenWidth(); // 0.834
        final double windowHeight = resolution.getScreenHeight();

        final double coefDim = 0.9567; // siix seveen
        final double coefx = 0.2625;
        final double coefy = 0.0241;

        dimension = (coefDim * windowHeight) / 16;
        startingPointx = coefx * windowWidth;
        startingPointy = coefy * windowHeight;
    }
    private void updatePlayer(GameView view)
    {
        ConverterView converter = new ConverterView(dimension,startingPointx,startingPointy);
        double playerX = converter.toPixelX(view.player().x());
        double playerY = converter.toPixelY(view.player().y());

        player.setX(playerX);
        player.setY(playerY);
        player.setFitWidth(converter.cellSize());
        player.setFitHeight(converter.cellSize());
    }
    private void updateEnemies(GameView view)
    {
        ConverterView converter = new ConverterView(dimension,startingPointx,startingPointy);
        int count = 0;
        for(EnemyView enemyView : view.enemies())
        {
            ImageView enemy = enemies.get(count);
            double enemyX = converter.toPixelX(enemyView.x());
            double enemyY = converter.toPixelY(enemyView.y());

            enemy.setX(enemyX);
            enemy.setY(enemyY);
            enemy.setFitWidth(converter.cellSize());
            enemy.setFitHeight(converter.cellSize());
            count ++;
        }
    }
    private void drawBackGr()
    {
        Image backgroundImage = new Image
        (
                Objects.requireNonNull(getClass().getResource( imagesPath + "backgroundBlue.jpg")).toExternalForm()
        );
        ImageView backgroundView = new ImageView(backgroundImage);
        staticLayer.getChildren().add(backgroundView);
        backgroundView.setFitWidth(resolution.getScreenWidth()*1.0267); // siix seveen
        backgroundView.setFitHeight(resolution.getScreenHeight()*1.0267);
    }
    private void drawMaze(GameView view)
    {
        ConverterView converter = new ConverterView(dimension,startingPointx,startingPointy);
        int size = view.maze().cells().length;
        for(int x = 0; x < size; x++)
        {
            for(int y = 0; y < size; y++)
            {
                int value = view.maze().cells()[x][y];
                double tmpX = converter.toPixelX(x);
                double tmpY = converter.toPixelY(y);
                double dim = converter.cellSize();
                Rectangle tmpRect = new Rectangle(tmpX, tmpY, dim, dim);
                boolean par = (x+y)%2 == 0;

                addObst(par,tmpRect,tmpX,tmpY,dim,value);
            }
        }
    }
    private ImageView drawPlayer(GameView view)
    {
        ConverterView converter = new ConverterView(dimension,startingPointx,startingPointy);
        Image playerImg = new Image
                (
                        Objects.requireNonNull(getClass().getResource(imagesPath + "Player.png")).toExternalForm()
                );
        ImageView player = new ImageView(playerImg);
        entityLayer.getChildren().add(player);
        double playerX = converter.toPixelX(view.player().x());
        double playerY = converter.toPixelY(view.player().y());
        player.setX(playerX);
        player.setY(playerY);
        player.setFitWidth(converter.cellSize());
        player.setFitHeight(converter.cellSize());
        return player;
    }
    private List <ImageView> drawEnemies(GameView view)
    {
        ConverterView converter = new ConverterView(dimension,startingPointx,startingPointy);
        List <ImageView> enemiesImage = new ArrayList<>();
        int cnt = 0;
        for(EnemyView enemyView : view.enemies())
        {
            ImageView enemy = enemiesImages.get(cnt);
            entityLayer.getChildren().add(enemy);
            double enemyX = converter.toPixelX(enemyView.x());
            double enemyY = converter.toPixelY(enemyView.y());
            enemy.setX(enemyX);
            enemy.setY(enemyY);
            enemy.setFitWidth(converter.cellSize());
            enemy.setFitHeight(converter.cellSize());
            enemiesImage.add(enemy);
            cnt++;
        }
        return enemiesImage;
    }
    private void addObst(boolean par, Rectangle rect, double tmpX, double tmpY, double dim, int value)
    {
        Image spikeImage = new Image(
                Objects.requireNonNull(
                        getClass().getResource(imagesPath + "Spikes.png")
                ).toExternalForm(),
                64,     // target width
                64,     // target height
                true,   // preserve ratio
                false    // smooth
        ); // System.out.println(spikeImage.getWidth() + " x " + spikeImage.getHeight());
        ImageView obstacle = new ImageView(spikeImage);

        if(par)
            rect.setFill(Color.GREEN);
        else
            rect.setFill(Color.DARKGREEN);
        staticLayer.getChildren().add(rect);

        if(value == -1)
        {
            staticLayer.getChildren().add(obstacle);
            obstacle.setX(tmpX);
            obstacle.setY(tmpY);
            obstacle.setFitWidth(dim);
            obstacle.setFitHeight(dim);
        }
    }
}
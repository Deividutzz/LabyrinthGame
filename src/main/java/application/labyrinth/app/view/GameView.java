package application.labyrinth.app.view;

import java.util.List;

public record GameView(
        PlayerView player,
        List<EnemyView> enemies,
        MazeView maze,
        boolean gameOver,
        GameStateView entityState
) {}

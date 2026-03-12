package application.labyrinth.app.view;

import java.util.List;

public record GameStateView(boolean playerMoved, List <Boolean> enemyMoved) { }
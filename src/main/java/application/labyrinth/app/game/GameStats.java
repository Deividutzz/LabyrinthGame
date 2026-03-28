package application.labyrinth.app.game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicInteger;

public class GameStats
{
    private String minutesSurvived = "";
    private String secondsSurvived = "";
    private Timeline timeline;

    public GameStats()
    {
        startsCounter();
    }

    public void startsCounter()
    {
        //timeCounterLabel.setVisible(true);
        AtomicInteger seconds = new AtomicInteger();

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            seconds.getAndIncrement();

            int minutes =  seconds.get() / 60;
            int remainingSeconds =  seconds.get() % 60;

            minutesSurvived = String.format("%01d", minutes);
            secondsSurvived = String.format("%01d", remainingSeconds);
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public boolean isPaused()
    {
        return timeline.getStatus() != Animation.Status.RUNNING;
    }
    public void pauseTimer()
    {
        if(!isPaused())
            timeline.pause();
    }
    public void resumeTimer()
    {
        if(isPaused())
            timeline.play();
    }
    public String getminutesSurvived()
    {
        return minutesSurvived;
    }
    public String getsecondsSurvived()
    {
        return secondsSurvived;
    }
}
package application.labyrinth.app.ui.menu;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;

public class SoundtrackManager
{

    private MediaPlayer mediaPlayer;

    public SoundtrackManager()
    {
        declareMediaPlayer();
    }

    private void declareMediaPlayer()
    {
        String path = "/application/labyrinth/assets/Audios/Orion(Remastered).mp3";

        Media media = new Media(
                Objects.requireNonNull(getClass().getResource(path)).toExternalForm()
        );

        mediaPlayer = new MediaPlayer(media);

        // loop forever
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        setVolume(0.8);
    }

    public void play()
    {
        mediaPlayer.play();
    }

    public void pause()
    {
        mediaPlayer.pause();
    }

    public void setVolume(double volume)
    {
        mediaPlayer.setVolume(volume); // value between 0.0 and 1.0
    }

    public double getVolume()
    {
        return mediaPlayer.getVolume();
    }
}
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Song extends Playlist {
    private String name;
    private String filePath;
    private String artist;

    //constructor
    public Song(String name, String filePath, String artist) {
        this.filePath = filePath;
        this.name = name;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getArtist() {
        return artist;
    }

    /*
    * Author: Max O'Didily
    *
     */
    public void playMusic() {

        try {
            File musicPath = new File(filePath);
            if(musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {
                System.out.println("File not found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

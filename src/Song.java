import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Song {
    private String name;
    private String filePath;
    private String artist;
    private Clip currentClip;

    public Song(String name, String filePath, String artist) {
        this.name = name;
        this.filePath = filePath;
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
    * https://www.youtube.com/watch?v=wJO_cq5XeSA
     */
    /*
     * Author: Max O'Didily
     * https://www.youtube.com/watch?v=wJO_cq5XeSA
     */
    public void playMusic(File filePath) {
        stopMusic(); //first stop the music before playing

        try {
            if (filePath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(filePath);
                currentClip = AudioSystem.getClip();
                currentClip.open(audioInput);
                currentClip.start();
            } else {
                System.out.println("File not found: " + filePath);
            }
        } catch (Exception e) {
            System.out.println("Error playing song: " + name + " - " + e.getMessage());
        }
    }

    public void stopMusic() {
        if (currentClip != null && currentClip.isRunning()) {
            currentClip.stop();
            currentClip.close();
        }
    }


    /*
    *Credit: https://www.w3schools.com/java/ref_string_trim.asp
     */
    public boolean checkGuess(String guess) {
        return guess.trim().equalsIgnoreCase(artist);
    }

    @Override
    public String toString() {
        return "Song: " + name + " by " + artist + " [" + filePath + "]";
    }

    public static ArrayList<Song> load(String filename) {
        ArrayList<Song> songs = new ArrayList<>();

        try {
            File myFile = new File(filename);
            Scanner fileScanner = new Scanner(myFile);
            fileScanner.nextLine(); // Skip header

            while (fileScanner.hasNextLine()) {
                String data = fileScanner.nextLine();
                String[] splitData = data.split(",");

                if (splitData.length > 3) {
                    String title = splitData[1].replaceAll("\"", "").trim();
                    String artist = splitData[3].replaceAll("\"", "").trim();

                    Song s = new Song(title, "", artist);
                    songs.add(s);
                }
            }

            fileScanner.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Reverse the list
        ArrayList<Song> reversed = new ArrayList<>();
        for (int i = songs.size() - 1; i >= 0; i--) {
            reversed.add(songs.get(i));
        }

        for (int i = 0; i < reversed.size(); i++) {
            String filePath = "snippets\\snippet_" + String.format("%03d", i) + ".wav";
            Song s = reversed.get(i);
            reversed.set(i, new Song(s.getName(), filePath, s.getArtist()));
        }

        return reversed;
    }

}

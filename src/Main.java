import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Load all songs from the CSV file
        // Assuming the CSV file is named "songs.csv" and located in the same directory
        ArrayList<Song> songs = Song.load("src\\top_100_most_streamed_songs_on_spotify.csv");

        // Generate a random number between 0 and 99
        Random random = new Random();
        int randomNumber = random.nextInt(100); // Generates a number from 0 to 99

        // Format the random number to have leading zeros (e.g., 000, 001, ..., 099)
        String formattedNumber = String.format("%03d", randomNumber);

        // Create the file path for the song snippet
        String filePath = "src/snippets/snippet_" + formattedNumber + ".wav";
        File songFile = new File(filePath);

        // Find the corresponding song in our loaded song list
        // The songs are already in reverse order from the load() method
        Song randomSong = null;
        if (randomNumber < songs.size()) {
            randomSong = songs.get(randomNumber + 1);
        } else {
            // If we don't have the metadata for this song, create a generic one
            randomSong = new Song("Random Song #" + randomNumber, filePath, "Unknown Artist");
        }

        // Print which song is being played, including title and artist
        System.out.println("Playing random song snippet #" + randomNumber);
        System.out.println("Title: " + randomSong.getName());
        System.out.println("Artist: " + randomSong.getArtist());
        System.out.println("File path: " + filePath);

        // Play the song
        randomSong.playMusic(songFile);

        // Keep the program running to allow the song to play
        try {
            System.out.println("Press Enter to stop the playback...");
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {

    private ArrayList<Song> playList;

    public Playlist() {
        playList = new ArrayList<>();
    }

    public void importData() {
        /* ----- EXAMPLE 1 ----- */
        // IMPORT DATA FROM A FILE
        try {
            File myFile = new File("src\\songs.csv");
            Scanner fileScanner = new Scanner(myFile);
            fileScanner.nextLine();

            while (fileScanner.hasNext()) {
                String data = fileScanner.nextLine();
                String[] splitData = data.split(",");
                String name = splitData[0];
                String filePath = splitData[1];
                String artist = splitData[2];
                Song s = new Song(name, filePath, artist);
                playList.add(s);
            }
            fileScanner.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }



//add the files paths and names to a seperate file and seperate using |
    //Read the contents of the file and then add only the file paths to a list
    //have methods that play a random song
    //have a method that plays a random song from a specifc audience



}

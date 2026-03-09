public class Song {
    private String title;
    private String artist;

    // Constructor
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    // toString method for a formatted representation of the song
    @Override
    public String toString() {
        return "Song [Title: " + title + ", Artist: " + artist + "]";
    }
}

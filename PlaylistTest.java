public class PlaylistTest {
    static int passed = 0;
    static int failed = 0;

    public static void main(String[] args) {
        testAddSong();
        testDisplayPlaylist();
        testRemoveSong();
        testRemoveFromEmpty();
        testRemoveNonExistent();
        testRemoveHead();
        testRemoveTail();
        testRemoveMiddle();
        testRemoveOnlyElement();
        testCaseInsensitiveRemove();
        testSize();

        System.out.println("\n===== RESULTS =====");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
        System.out.println(failed == 0 ? "ALL TESTS PASSED" : "SOME TESTS FAILED");
    }

    static void check(String testName, boolean condition) {
        if (condition) {
            System.out.println("[PASS] " + testName);
            passed++;
        } else {
            System.out.println("[FAIL] " + testName);
            failed++;
        }
    }

    static void testAddSong() {
        Playlist p = new Playlist();
        String result = p.addSong(new Song("TestSong", "TestArtist"));
        check("Add song returns confirmation", result.contains("Added song: TestSong"));
    }

    static void testDisplayPlaylist() {
        Playlist p = new Playlist();
        p.addSong(new Song("A", "Artist1"));
        p.addSong(new Song("B", "Artist2"));
        String display = p.getPlaylistDisplay();
        check("Display contains first song", display.contains("A") && display.contains("Artist1"));
        check("Display contains second song", display.contains("B") && display.contains("Artist2"));
        check("Display shows order (A before B)", display.indexOf("A") < display.indexOf("B"));
    }

    static void testRemoveSong() {
        Playlist p = new Playlist();
        p.addSong(new Song("X", "ArtistX"));
        String result = p.removeSong("X");
        check("Remove existing song returns confirmation", result.contains("Removed song: X"));
        check("Playlist empty after removing only song", p.isEmpty());
    }

    static void testRemoveFromEmpty() {
        Playlist p = new Playlist();
        String result = p.removeSong("Ghost");
        check("Remove from empty playlist", result.contains("empty"));
    }

    static void testRemoveNonExistent() {
        Playlist p = new Playlist();
        p.addSong(new Song("Real", "Artist"));
        String result = p.removeSong("Fake");
        check("Remove non-existent song", result.contains("not found"));
        check("Playlist unchanged after failed remove", p.getSize() == 1);
    }

    static void testRemoveHead() {
        Playlist p = new Playlist();
        p.addSong(new Song("First", "A1"));
        p.addSong(new Song("Second", "A2"));
        p.addSong(new Song("Third", "A3"));
        p.removeSong("First");
        String display = p.getPlaylistDisplay();
        check("Remove head - first gone", !display.contains("First"));
        check("Remove head - rest intact", display.contains("Second") && display.contains("Third"));
        check("Remove head - size correct", p.getSize() == 2);
    }

    static void testRemoveTail() {
        Playlist p = new Playlist();
        p.addSong(new Song("First", "A1"));
        p.addSong(new Song("Second", "A2"));
        p.addSong(new Song("Third", "A3"));
        p.removeSong("Third");
        String display = p.getPlaylistDisplay();
        check("Remove tail - last gone", !display.contains("Third"));
        check("Remove tail - rest intact", display.contains("First") && display.contains("Second"));
        check("Remove tail - size correct", p.getSize() == 2);
    }

    static void testRemoveMiddle() {
        Playlist p = new Playlist();
        p.addSong(new Song("First", "A1"));
        p.addSong(new Song("Second", "A2"));
        p.addSong(new Song("Third", "A3"));
        p.removeSong("Second");
        String display = p.getPlaylistDisplay();
        check("Remove middle - middle gone", !display.contains("Second"));
        check("Remove middle - ends intact", display.contains("First") && display.contains("Third"));
        check("Remove middle - size correct", p.getSize() == 2);
    }

    static void testRemoveOnlyElement() {
        Playlist p = new Playlist();
        p.addSong(new Song("Solo", "Artist"));
        p.removeSong("Solo");
        check("Remove only element - empty", p.isEmpty());
        check("Remove only element - display shows empty", p.getPlaylistDisplay().contains("empty"));
    }

    static void testCaseInsensitiveRemove() {
        Playlist p = new Playlist();
        p.addSong(new Song("Hello World", "Artist"));
        String result = p.removeSong("hello world");
        check("Case-insensitive remove works", result.contains("Removed"));
        check("Case-insensitive remove - playlist empty", p.isEmpty());
    }

    static void testSize() {
        Playlist p = new Playlist();
        check("Empty playlist size is 0", p.getSize() == 0);
        p.addSong(new Song("A", "A1"));
        check("Size is 1 after one add", p.getSize() == 1);
        p.addSong(new Song("B", "B1"));
        p.addSong(new Song("C", "C1"));
        check("Size is 3 after three adds", p.getSize() == 3);
        p.removeSong("B");
        check("Size is 2 after one remove", p.getSize() == 2);
    }
}

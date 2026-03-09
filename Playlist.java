public class Playlist {
    private Node head;
    private Node tail;

    public Playlist() {
        this.head = null;
        this.tail = null;
    }

    // Adds a new song to the end of the playlist
    public String addSong(Song song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        return "Added song: " + song.getTitle();
    }

    // Returns the playlist as a formatted string
    public String getPlaylistDisplay() {
        if (head == null) {
            return "The playlist is empty.";
        }
        StringBuilder sb = new StringBuilder();
        Node current = head;
        int index = 1;
        while (current != null) {
            sb.append(index).append(". ").append(current.getSong()).append("\n");
            current = current.getNext();
            index++;
        }
        return sb.toString().trim();
    }

    // Removes a song by title
    public String removeSong(String title) {
        if (head == null) {
            return "The playlist is empty.";
        }

        Node current = head;
        while (current != null) {
            if (current.getSong().getTitle().equalsIgnoreCase(title)) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) {
                    head = current.getNext();
                    if (head != null) {
                        head.setPrev(null);
                    }
                } else if (current == tail) {
                    tail = current.getPrev();
                    if (tail != null) {
                        tail.setNext(null);
                    }
                } else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                }
                return "Removed song: " + title;
            }
            current = current.getNext();
        }
        return "Song not found: " + title;
    }

    // Returns the number of songs
    public int getSize() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    // Checks if playlist is empty
    public boolean isEmpty() {
        return head == null;
    }
}

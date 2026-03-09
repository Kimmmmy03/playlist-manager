public class Node {
    private Song song;
    private Node next;
    private Node prev;

    // Constructor
    public Node(Song song) {
        this.song = song;
        this.next = null;
        this.prev = null;
    }

    // Getters and Setters
    public Song getSong() {
        return song;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    private Playlist playlist;
    private JTextArea playlistArea;
    private JTextField titleField;
    private JTextField artistField;
    private JLabel statusLabel;

    public Main() {
        playlist = new Playlist();

        JFrame frame = new JFrame("Playlist Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 480);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        // --- Input Panel (Top) ---
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Add / Remove Song",
            TitledBorder.LEFT, TitledBorder.TOP));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        inputPanel.add(new JLabel("Title:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        titleField = new JTextField(20);
        inputPanel.add(titleField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        inputPanel.add(new JLabel("Artist:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        artistField = new JTextField(20);
        inputPanel.add(artistField, gbc);

        // --- Buttons Panel ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JButton addButton = new JButton("Add Song");
        JButton removeButton = new JButton("Remove Song");
        JButton clearButton = new JButton("Clear All");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(clearButton);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        inputPanel.add(buttonPanel, gbc);

        frame.add(inputPanel, BorderLayout.NORTH);

        // --- Playlist Display (Center) ---
        playlistArea = new JTextArea();
        playlistArea.setEditable(false);
        playlistArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        playlistArea.setMargin(new Insets(8, 8, 8, 8));
        JScrollPane scrollPane = new JScrollPane(playlistArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Playlist",
            TitledBorder.LEFT, TitledBorder.TOP));
        frame.add(scrollPane, BorderLayout.CENTER);

        // --- Status Bar (Bottom) ---
        statusLabel = new JLabel(" Ready");
        statusLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY),
            BorderFactory.createEmptyBorder(4, 6, 4, 6)));
        frame.add(statusLabel, BorderLayout.SOUTH);

        // --- Button Actions ---
        addButton.addActionListener(e -> addSong());
        removeButton.addActionListener(e -> removeSong());
        clearButton.addActionListener(e -> clearAll());

        // Press Enter in artist field to add song
        artistField.addActionListener(e -> addSong());

        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        frame.setVisible(true);
        refreshPlaylist();
    }

    private void addSong() {
        String title = titleField.getText().trim();
        String artist = artistField.getText().trim();

        if (title.isEmpty()) {
            setStatus("Please enter a song title.");
            titleField.requestFocus();
            return;
        }
        if (artist.isEmpty()) {
            setStatus("Please enter an artist name.");
            artistField.requestFocus();
            return;
        }

        Song song = new Song(title, artist);
        String result = playlist.addSong(song);
        setStatus(result + "  |  Total: " + playlist.getSize() + " song(s)");
        titleField.setText("");
        artistField.setText("");
        titleField.requestFocus();
        refreshPlaylist();
    }

    private void removeSong() {
        String title = titleField.getText().trim();
        if (title.isEmpty()) {
            setStatus("Enter the song title to remove.");
            titleField.requestFocus();
            return;
        }

        String result = playlist.removeSong(title);
        setStatus(result + "  |  Total: " + playlist.getSize() + " song(s)");
        titleField.setText("");
        artistField.setText("");
        titleField.requestFocus();
        refreshPlaylist();
    }

    private void clearAll() {
        if (playlist.isEmpty()) {
            setStatus("Playlist is already empty.");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(null,
            "Remove all songs from the playlist?", "Confirm Clear",
            JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            while (!playlist.isEmpty()) {
                playlist.removeSong(playlist.getPlaylistDisplay().split("Title: ")[1].split(",")[0]);
            }
            setStatus("Playlist cleared.");
            refreshPlaylist();
        }
    }

    private void refreshPlaylist() {
        playlistArea.setText(playlist.getPlaylistDisplay());
    }

    private void setStatus(String message) {
        statusLabel.setText(" " + message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}

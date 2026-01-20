package Utils;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FunnyEffects {
    // Metoda sprawiająca, że przycisk "ucieka"
    public static void makeButtonRunAway(JButton button) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                Random rand = new Random();
                Container parent = button.getParent();
                if (parent != null) {
                    int nextX = rand.nextInt(Math.max(1, parent.getWidth() - button.getWidth()));
                    int nextY = rand.nextInt(Math.max(1, parent.getHeight() - button.getHeight()));
                    button.setLocation(nextX, nextY);
                }
            }
        });
    }

    // Metoda odtwarzająca dźwięk WAV z folderu resources
    public static void playSound(String fileName) {
        new Thread(() -> {
            try {
                // Maven szuka w src/main/resources/
                java.net.URL url = FunnyEffects.class.getResource("/sounds/" + fileName);
                if (url != null) {
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    clip.start();
                }
            } catch (Exception e) {
                System.err.println("Błąd audio: " + e.getMessage());
            }
        }).start();
    }
}
import java.io.*;
import javax.sound.sampled.*;

public class SoundPlayer {
        public void playLaserSound() {
            Thread soundThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        File soundFile = new File("src/Sounds/Laser Gun.wav");
                        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioIn);
                        clip.start();

                        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);


                        gainControl.setValue(gainControl.getValue() - 15.0f);



                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                        e.printStackTrace();
                    }
                }
            });
            soundThread.start();
        }
    public void playSong() {
        Thread soundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File soundFile = new File("src/Sounds/Away - Patrick Patrikios.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
//
                    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);


                    gainControl.setValue(gainControl.getValue() - 10.0f);

                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        });
        soundThread.start();
    }
    public void playBOOM() {
        Thread soundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File soundFile = new File("src/Sounds/Explosion Hiss Bop Bang .wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        });
        soundThread.start();
    }
}
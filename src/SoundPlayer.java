import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class SoundPlayer extends Thread{
    private float volume;
    private String soundName;
    public SoundPlayer(String soundName, float volume) {
        this.volume = volume;
        this.soundName = soundName;
    }
    public void run(){
        try {
            File soundFile = new File(soundName);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volume);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setVolume(float pVolume) {
        this.volume = pVolume;
    }
}

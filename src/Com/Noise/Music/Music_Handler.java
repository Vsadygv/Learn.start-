package Com.Noise.Music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music_Handler {
	public Music_Handler() {
		try {

//			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("/Com/Noise/Music/main.wav"));
			AudioInputStream audioInputStream2 = AudioSystem.getAudioInputStream(getClass().getResource("/Com/Noise/Music/main2.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream2);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
}

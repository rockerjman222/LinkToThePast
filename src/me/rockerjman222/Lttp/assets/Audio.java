package me.rockerjman222.Lttp.assets;


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Audio {

	private Clip clip;

	public Audio(File file) {
		try {
			AudioInputStream inputStream1 = AudioSystem.getAudioInputStream(file);

			AudioFormat baseFormat = inputStream1.getFormat();
			AudioFormat decodeFormat = new AudioFormat(
					AudioFormat.Encoding.PCM_SIGNED,
					baseFormat.getSampleRate(),
					16,
					baseFormat.getChannels(),
					baseFormat.getChannels() * 2,
					baseFormat.getSampleRate(),
					false
			);

			AudioInputStream inputStream2 = AudioSystem.getAudioInputStream(decodeFormat, inputStream1);
			clip = AudioSystem.getClip();
			clip.open(inputStream2);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public static double getLength(File file) {
		AudioInputStream stream;
		Clip clip = null;

		try {
			stream = AudioSystem.getAudioInputStream(file);
			AudioFormat format = stream.getFormat();
			if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
				format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format
						.getSampleRate(), format.getSampleSizeInBits() * 2, format
						.getChannels(), format.getFrameSize() * 2, format
						.getFrameRate(), true); // big endian
				stream = AudioSystem.getAudioInputStream(format, stream);
			}
			DataLine.Info info = new DataLine.Info(Clip.class, stream.getFormat(),
					((int) stream.getFrameLength() * format.getFrameSize()));
			clip = (Clip) AudioSystem.getLine(info);
			clip.close();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}

		return clip.getBufferSize() / (clip.getFormat().getFrameSize() * clip.getFormat().getFrameRate());
	}

	public void play() {
		if(clip == null)
			return;
		stop();
		clip.setFramePosition(0);
		clip.start();
	}

	public void loop(int times) {
		if(clip == null)
			return;
		stop();
		clip.setFramePosition(0);
		clip.loop(times);
	}

	public void stop() {
		if(clip.isRunning())
			clip.stop();
	}

	public void close() {
		stop();
		clip.close();
	}
}

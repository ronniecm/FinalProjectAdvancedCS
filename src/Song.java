import javax.print.attribute.standard.MediaPrintableArea;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import javafx.scene.media.*;

import sun.audio.*;

import java.io.*;

public class Song implements Music
{
	private String title, artist, path;
	// private Genre genre;
	private Album album;
	private File audioFile;
	private AudioInputStream ais;
	private Clip song;

	public Song(String title, String artist, String path, Album album) throws Exception
	{
		this.title = title;
		this.artist = artist;
		this.path = path;
		// this.genre = genre;
		this.album = album;

		File file = new File(path);

		song = AudioSystem.getClip();
		song.open(AudioSystem.getAudioInputStream(file));
	}

	public void play()
	{
		try 
		{
			song.start();
			Thread.sleep(song.getMicrosecondLength() / 1000);
		} catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public void pause()
	{
		song.stop();
	}
	public void printTime()
	{
		System.out.println(song.getMicrosecondPosition() / 1000);
	}

	public static void main(String[] args)
	{
		try
		{
			Song song = new Song("poker", "ronnie", "/Users/frcprogramming/Downloads/Juice-WRLD-Lean-Wit-Me.wav", null);
			song.play();
			song.pause();
			while(true)
				song.printTime();
		} catch (Exception e)
		{
			e.getStackTrace();
			System.out.println("error");
		}
	}
}

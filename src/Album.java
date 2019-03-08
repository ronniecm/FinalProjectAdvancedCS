
public class Album
{
	private Song[] album;
	private String title, artist;
	private int albumSize, currentSize;
	
	public Album(String title, String artist)
	{
		album = new Song[albumSize + 1];
		this.title = title;
		this.artist = artist;
		currentSize = 0;
	}
	
	public void add(Song song)
	{
		album[currentSize++] = song;
	}
}

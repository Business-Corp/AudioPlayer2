package player;

import java.io.File;
import java.net.URI;

import javafx.scene.media.Media;
import javafx.util.Duration;

public class Track {

	private File file;
	private String artist = "";
	private String titel = "";
	private Media media;
	
	
	public Track(File file) {
		if(file == null){
			return;
		}
		this.file=file;
		artist = file.getName();
		media = new Media(file.toURI().toString());
		
	}
	public String getArtist(){
		return artist;
	}
	public String getTitel(){
		return titel;
	}
	public Duration getDuration(){
		return media.getDuration();
	}
	public String toString(){
		if(titel.equals("")){
			return artist;
		}
		return artist+" - "+titel;
		
	}
	public Media getMedia(){
		return media;
	}
	public File getFile(){
		return file;
	}
	
}

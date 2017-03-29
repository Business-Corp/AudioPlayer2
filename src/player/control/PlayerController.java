package player.control;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import player.Track;
import player.playlist.Playlist;

/**
 * Diese Klasse kontrolliert den Player
 * 
 * @author Höling
 *
 */
public class PlayerController {

	private static PlayerController player = new PlayerController();
	private MediaPlayer mediaPlayer;
	private Playlist playlist;
	private Track trackATM;

	private PlayerController() {
		// TODO Auto-generated constructor stub
	}

	public static PlayerController getInstance() {
		return player;
	}

	/**
	 * Setzt das aktuelle Lied fort oder spielt das naechste Lied aus der
	 * Playlist ab, wenn aktuell kein lied geladen ist.
	 */
	public void play() {
		
		if (mediaPlayer != null) {

			mediaPlayer.play();

		} else {
			
			if (checkPlaylist()) {
				
				Track temp = playlist.getTrackFromIndex(0);
				if(temp != null){
					
					mediaPlayer=new MediaPlayer(new Media(temp.getFile().toURI().toString()));
					mediaPlayer.play();
					trackATM=temp;
				}
			}
		}

	}

	public void pause() {
		if(mediaPlayer!= null){
			mediaPlayer.pause();
		}

	}

	public void stop() {

		if(mediaPlayer!=null){
			mediaPlayer.stop();
		}
	}

	public void next() {
		if (checkPlaylist()) {
			int index = playlist.getIndex(trackATM);
			
			Track temp = playlist.getTrackFromIndex(index+1);
			if(temp != null){
				stop();
				mediaPlayer=new MediaPlayer(new Media(temp.getFile().toURI().toString()));
				mediaPlayer.play();
				trackATM=temp;
			}
			
		}

	}

	public void previous() {
		if (checkPlaylist()) {

		}
	}

	public void setPlaylist(Playlist list) {
		playlist = list;
		
	}
	
	public ReadOnlyObjectProperty<Duration> CurrentTimeProperty(){
		if(mediaPlayer!=null){
		return mediaPlayer.currentTimeProperty();
		
		}
		return null;
	}
	
	public Duration getMaxTime(){
		if(mediaPlayer!=null){
			mediaPlayer.getMedia().getDuration();
		}
		return new Duration(0);
	}
	public Track getCurrentTrack(){
		return trackATM;
	}

	private boolean checkPlaylist() {
		return playlist != null;
	}

}

package player.control;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import player.Track;
import player.playlist.Playlist;

/**
 * Diese Klasse kontrolliert den Player
 * 
 * @author Höling
 *
 */
public class PlayerController {

	private PlayerController player = new PlayerController();
	private MediaPlayer mediaPlayer;
	private Playlist playlist;

	private PlayerController() {
		// TODO Auto-generated constructor stub
	}

	public PlayerController getInstance() {
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
				Track temp = playlist.getTrackFromIndex(1);
				if(temp != null){
					mediaPlayer=new MediaPlayer(temp.getMedia());
					
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

		}

	}

	public void previous() {
		if (checkPlaylist()) {

		}
	}

	public void setPlaylist(Playlist list) {
		playlist = list;
	}

	private boolean checkPlaylist() {
		return playlist != null;
	}

}

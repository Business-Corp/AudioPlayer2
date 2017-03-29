import java.io.File;

import player.control.PlayerController;
import player.playlist.Playlist;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pfad = "E:\\Neuer Ordner\\musicc\\Music\\Anamanaguchi\\Anamanaguchi - Endless Fantasy\\01 Endless Fantasy.mp3";
		File file = new File(pfad);
		Playlist playlist = new Playlist();
		playlist.addTrack(file);
		
		PlayerController pc = PlayerController.getInstance();
		
		pc.setPlaylist(playlist);
		
		pc.play();

	}

}

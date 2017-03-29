package ui;
	
import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import player.control.PlayerController;
import player.playlist.Playlist;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
//			primaryStage.initStyle(StageStyle.UNDECORATED);
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Player.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
			
			
//			String pfad2 = "E:\\Neuer Ordner\\musicc\\Music\\Anamanaguchi\\Anamanaguchi - Endless Fantasy\\01 Endless Fantasy.mp3";
//			File file = new File(pfad2);
//			Playlist playlist = new Playlist();
//			playlist.addTrack(file);
//			
//			player.control.PlayerController pc = player.control.PlayerController.getInstance();
//			
//			pc.setPlaylist(playlist);
//			
//			pc.play();
//			
//			Thread.sleep(5000);
//			
//			pc.stop();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

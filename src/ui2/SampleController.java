package ui2;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import player.Track;
import player.control.PlayerController;
import player.playlist.Playlist;

public class SampleController implements Initializable{
	
	
	@FXML
	private Button play = new Button();

	@FXML
	private Button pause = new Button();
	
	@FXML
	private Button stop = new Button();
	
	@FXML
	private Button addFile = new Button();
	
	@FXML
	private Button bNext = new Button();
	
	@FXML
	private Button bPrev = new Button();
	
	@FXML
	private Slider sliderProgress = new Slider();

	@FXML
	private ListView<Track> playlist = new ListView<Track>();
	
	private PlayerController player = PlayerController.getInstance();
	private Playlist listePlaylist = new Playlist();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		player.setPlaylist(listePlaylist);
		
		playlist.setItems(listePlaylist.getObservableList());
//		playlist.setCellFactory(new Callback<ListView<Track>, ListCell<Track>>() {
//
//			@Override
//			public ListCell<Track> call(ListView<Track> param) {
//				
//				// TODO Auto-generated method stub
//				return null;
//			}
//		});
		
		addFile.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
//				String pfad2 = "E:\\Neuer Ordner\\musicc\\Music\\Anamanaguchi\\Anamanaguchi - Endless Fantasy\\01 Endless Fantasy.mp3";
//				File file = new File(pfad2);
//				listePlaylist.addTrack(file);
				
			
				//auf multiplen chosser umschreiben..
				FileChooser fc = new FileChooser();
				fc.setTitle("media auswaehlen");
				File auswahl = fc.showOpenDialog(addFile.getScene().getWindow());
				if(auswahl != null){
					listePlaylist.addTrack(auswahl);
				}
				
				
			}
		});
		
		play.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				playTrack();
				
			}
		});
		pause.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				player.pause();
				
			}
		});
		stop.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				player.stop();
				
			}
		});
		
		bNext.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				nextTrack();
				
			}
		});
		bPrev.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				player.previous();
				
			}
		});
		
		
		sliderProgress.setMin(0);
//		sliderProgress.setValue(170);
		
	}
	private void updateValues(){
		
	}
	private void nextTrack(){
		
		player.next();
		bindSlider();
		
		Track track = player.getCurrentTrack();
		 if(track != null){
		playlist.getSelectionModel().select(track);
		 }
	}
	private void playTrack(){
		player.play();
		bindSlider();
		Track track = player.getCurrentTrack();
		 if(track != null){
		playlist.getSelectionModel().select(track);
		 }
		
	}
	private void bindSlider(){
		sliderProgress.setMax(player.getMaxTime().toSeconds());
		
	}

}

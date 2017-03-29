package ui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.sound.sampled.AudioSystem;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import player.playlist.Playlist;

public class PlayerController implements Initializable{
	
	@FXML
	Button play = new Button("Play");
	
	@FXML
	Button pause = new Button("Pause");
	
	@FXML
	Button stop = new Button("Stop");
	

	@FXML
	Slider ablauf = new Slider();
	
	@FXML
	ProgressBar fortschritt = new ProgressBar();
	
	private long prevTime = 0;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		String pfad = "E:\\Neuer Ordner\\musicc\\Music\\Anamanaguchi\\Anamanaguchi - Endless Fantasy\\01 Endless Fantasy.mp3";
//		String pfad = "D:\\Multimedia\\Musik\\MP3\\Anamanaguchi - 2009 - Dawn Metropolis (V0)\\02 Anamanaguchi - Jetpack Blues.mp3";
		
		Media hit = new Media(new File(pfad).toURI().toString());
		MediaPlayer mp = new MediaPlayer(hit);
		
		//mp.play();
		
		ablauf.setMin(0.0);
		ablauf.setMax(mp.getMedia().getDuration().toSeconds());
		ablauf.setShowTickLabels(true);
		ablauf.setValue(20.0);
		
//		fortschritt.setProgress(0.75);
		
		
		play.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				mp.play();
			}
		});
		
		pause.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
			
				mp.pause();
			}
			
		});
		
		stop.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				mp.stop();
			}
		});
		

		
		new Playlist();
		
		
		mp.currentTimeProperty().addListener(new ChangeListener<Duration>() {
			@Override
			public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
				// TODO Auto-generated method stub
				
				long currTime = System.currentTimeMillis();
				
				if(Double.compare((currTime-prevTime), 500) > 0){
					Double abgespieltRate = mp.getCurrentTime().toSeconds()/mp.getMedia().getDuration().toSeconds();
					ablauf.setValue(mp.getCurrentTime().toSeconds());
					
					
					fortschritt.setProgress(abgespieltRate);
					
					System.out.println("mp current time: "+mp.getCurrentTime().toSeconds());
					System.out.println("laenge des songs?: "+mp.getMedia().getDuration().toSeconds());
					System.out.println("Rate: "+abgespieltRate);
					System.out.println(""+ablauf.getValue());

					ablauf.valueProperty().set(mp.getCurrentTime().toSeconds());
					
					prevTime=currTime;
				}
				
			}
		});
		
		
//		System.out.println(AudioSystem.getAudioFileTypes().toString());
		
		
		
		for (int i = 0; i < AudioSystem.getAudioFileTypes().length; i++) {
		
			System.out.println(AudioSystem.getAudioFileTypes()[i]);
		}
		
		
		
		
		
		
		
		
	}
	private void updateSlider(MediaPlayer mediaplayer){
		
		
		
	}
	
}

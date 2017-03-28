package player.playlist.ui;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import player.playlist.Playlist;

public class PlaylistController implements Initializable{
	
	@FXML
	Region regionNW = new Region();
	
	@FXML
	Button resize = new Button();
	
	@FXML
	Label label1 = new Label();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		Image imageResize = new Image(getClass().getResourceAsStream("resize_arrow.png"));
//		
		resize.setGraphic(new ImageView(imageResize));
		
		resize.setOnMouseDragged(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				Stage stage = player.playlist.Playlist.getStage();
				
				double mouseEventX = event.getSceneX();
				double mouseEventY = event.getSceneY();
				
				double sceneX = stage.getX();
				double sceneY = stage.getY();
				double sceneWidth = stage.getWidth();
				double sceneHeight = stage.getHeight();
				
//				Playlist.getStage().setX(event.getScreenX());
//				Playlist.getStage().setY(event.getScreenY());
//				
//				Playlist.getStage().getWidth()
//				
				stage.setWidth(event.getSceneX());
				stage.setHeight(event.getSceneY());
				
				resize.setLayoutX(event.getSceneX()-26);
				resize.setLayoutY(event.getSceneY()-26);
				
			}
		});
		
		
	}

}

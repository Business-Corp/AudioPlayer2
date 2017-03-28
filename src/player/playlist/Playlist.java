package player.playlist;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Playlist {

	private double xOffset;
	private double yOffset;
	private static Stage stage = new Stage();
	
	
	public Playlist() {
		
//		Stage stage = new Stage();
		
		stage.initStyle(StageStyle.UNDECORATED);
		
		AnchorPane root;
		
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("ui\\Playlist.fxml"));
			
			root.setOnMousePressed(new EventHandler<MouseEvent>() {
	          
			

				@Override
	            public void handle(MouseEvent event) {
	                xOffset = event.getSceneX();
	                yOffset = event.getSceneY();
	            }
	        });
			
	        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                stage.setX(event.getScreenX() - xOffset);
	                stage.setY(event.getScreenY() - yOffset);
	            }
	        });
			
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	public static Stage getStage() {
		return stage;
	}
	
}

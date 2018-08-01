//John Chung King Sow
//CS 211S Advanced Java Fall 2017
//Homework 6: Photo Album
//Instructor Abbas Moghtanei

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
 
public class PhotoAlbum extends Application 
{
     
Stage stage;

    @Override
    public void start(Stage stg) throws Exception 
    {
    		
    	stage = stg;  	
    	stg.setTitle("My Photo Album");
    	//We want the thumbnails to be in vertical orientation and to be presented to the top left as demonstrated by instructor Abbas in class   
        ScrollPane root = new ScrollPane();
        TilePane photoGrid = new TilePane(Orientation.VERTICAL); 
        photoGrid.setAlignment(Pos.TOP_LEFT); 
        photoGrid.setHgap(15);                
        photoGrid.setPrefRows(6);
      //Add padding to make it look more presentable to the viewers 
        photoGrid.setPadding(new Insets(15, 15, 15,15)); 
                                                       
        String path = "src/image/"; //The Images location
        
        File imageGallery = new File(path);
        File[] listOfMyPhotos = imageGallery.listFiles();
        
        for (File photos : listOfMyPhotos) 
        {
                ImageView imgView;
                imgView = setImageView(photos);
                photoGrid.getChildren().addAll(imgView);
               
        }

        root.setFitToWidth(true);
        root.setContent(photoGrid);
        
       
        stg.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        stg.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
                
        Scene sc = new Scene(root);
        stg.setScene(sc);
        stg.show();
    }

    private ImageView setImageView(File myImages) {

     	
        ImageView imgView = null;
        try {
            Image images = new Image(new FileInputStream(myImages), 150, 0, true,true);             
            imgView = new ImageView(images);
            imgView.setFitWidth(100); //Set width of image to 100
            imgView.setPreserveRatio(true);//Preseverve the ratio of the images 
            imgView.setSmooth(true); //Use higher quality filtering method
            imgView.setCache(true);//Cached for improved performance 
            
            imgView.setOnMouseClicked(new EventHandler<MouseEvent>() {   
            	
                @Override
                public void handle(MouseEvent event) {

                    if(event.getButton().equals(MouseButton.PRIMARY)){

                       if(event.getClickCount() == 1){ //One mouse click to view each image
                           try {
                           BorderPane borderPane = new BorderPane();
                           ImageView imageView = new ImageView();
                           Image img = new Image(new FileInputStream(myImages));
                           imageView.setImage(img);
                           imageView.setFitHeight(stage.getHeight() - 10);
                           imageView.setPreserveRatio(true);
                           imageView.setSmooth(true);
                           borderPane.setCenter(imageView);
                                                  
                                                              
                           Stage newStage = new Stage();
                           newStage.setWidth(stage.getWidth());
                           newStage.setHeight(stage.getHeight());
                           newStage.setTitle(myImages.getName());
                           Scene scene = new Scene(borderPane,Color.LIGHTGRAY);
                           newStage.setScene(scene);
                           newStage.show();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            });
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return imgView;
    }

    public static void main(String[] args) {
        launch(args);
    }
}






  


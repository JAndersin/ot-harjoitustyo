package ui;

import json.ProvinceParser;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import org.json.simple.JSONObject;

public class App extends Application {

    JSONObject prov = new JSONObject();

    @Override
    public void start(Stage stage) throws Exception {
        
        Image mapImage = new Image("map.bmp");
        
        ImageView imageView = new ImageView(mapImage);
        imageView.setPreserveRatio(true);
        HBox info = Interface.displayInformation(prov, 0, 0, 0, 0);
        
        imageView.setOnMousePressed(e -> {
            if (e.isPrimaryButtonDown()) {
                
                // if mouse1 pressed read pixel color at cursor location and then try to read relevant info
                // about that color from the provinces.JSON file and display it to user by replacing currently
                // displayed information
                
                PixelReader pixelreader = mapImage.getPixelReader();
                Color color = pixelreader.getColor((int) e.getX(), (int) e.getY());
                int provinceColor = Integer.valueOf("" + (int) (color.getRed() * 255) + (int) (color.getGreen() * 255) + (int) (color.getBlue() * 255));
                prov = ProvinceParser.getProvince(provinceColor);
                info.getChildren().clear(); 
                HBox newInfo = Interface.displayInformation(prov, provinceColor, (int) (color.getRed() * 255), (int) (color.getGreen() * 255), (int) (color.getBlue() * 255));
                info.getChildren().add(newInfo);
            }
        });
        
        Pane map = new Pane(imageView);
        ScrollPane scrollPane = new ScrollPane(map);
        info.setPadding(new Insets(10));
        HBox root = new HBox(scrollPane, info);
        stage.setScene(new Scene(root));
        stage.setTitle("Province Data Editor");
        stage.show();       
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
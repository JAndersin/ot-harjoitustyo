package ui;

import json.ProvinceParser;
import javafx.application.Application;
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
        Image mapImage = new Image("file:src/main/java/ui/map.bmp");

        ImageView imageView = new ImageView(mapImage);
        imageView.setPreserveRatio(true);

        HBox info = Interface.showSelected(prov, 0);
        Pane map = new Pane(imageView);
        ScrollPane scrollPane = new ScrollPane(map);
        
        imageView.setOnMousePressed(e -> {
            if (e.isPrimaryButtonDown()) {
                PixelReader pixelreader = mapImage.getPixelReader();
                Color color = pixelreader.getColor((int) e.getX(), (int) e.getY());
                int provinceColor = Integer.valueOf("" + (int) (color.getRed() * 255) + (int) (color.getGreen() * 255) + (int) (color.getBlue() * 255));
                System.out.println("RGB Value of the selection: " + provinceColor);
                prov = ProvinceParser.getProvince(provinceColor);
                System.out.println(prov);
                info.getChildren().clear(); 
                HBox info2 = Interface.showSelected(prov, provinceColor);
                info.getChildren().add(info2);
            }
        });
        
        HBox root = new HBox(scrollPane, info);
        stage.setScene(new Scene(root));
        stage.setTitle("Province Data Editor");
        stage.show();       
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
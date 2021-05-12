package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import json.FileSystem;
import json.ProvinceParser;
import org.json.simple.JSONObject;

public class SceneHandler {
    
    static JSONObject prov = new JSONObject();
    static FileSystem fileSystem = new FileSystem();
    private static Stage stage;
    
    public static void startScene(){
        
        HBox root = new HBox(Interface.startUI());
        root.setAlignment(Pos.CENTER);
        App.getStage().setScene(new Scene(root));
        App.getStage().setMinHeight(600);
        App.getStage().setMinWidth(800);
    }    
    
    public static void mainScene(Image image){
        
        ImageView imageView = new ImageView(image);

        imageView.setPreserveRatio(true);
        HBox info = Interface.displayInformation(prov, 0, 0, 0, 0, fileSystem);
        
        imageView.setOnMousePressed(e -> {
            if (e.isPrimaryButtonDown()) {
                
                if (fileSystem.jsonFile.getPath().length() > 0){
                    PixelReader pixelreader = image.getPixelReader();
                    Color color = pixelreader.getColor((int) e.getX(), (int) e.getY());
                    int provinceColor = Integer.valueOf("" + (int) (color.getRed() * 255) + (int) (color.getGreen() * 255) + (int) (color.getBlue() * 255));
                    prov = ProvinceParser.getProvince(provinceColor, fileSystem.jsonFile);
                    info.getChildren().clear(); 
                    HBox newInfo = Interface.displayInformation(prov, provinceColor, (int) (color.getRed() * 255), (int) (color.getGreen() * 255), (int) (color.getBlue() * 255), fileSystem);
                    info.getChildren().add(newInfo);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Ole hyvä ja valitse ensin JSON-tiedosto painamalla Avaa.");
                    alert.show();
                }
            }
        });
        
        Pane map = new Pane(imageView);
        ScrollPane scrollPane = new ScrollPane(map);
        scrollPane.setStyle("-fx-box-border: transparent;");
        info.setPadding(new Insets(10));
        info.setStyle("-fx-box-border: transparent;");
        HBox root = new HBox(scrollPane, info);
        App.getStage().setScene(new Scene(root));
    }
}

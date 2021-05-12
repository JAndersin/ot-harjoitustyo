package ui;

import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import json.ProvinceParser;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import json.FileSystem;
import org.json.simple.JSONObject;

/**
 * Luokka huolehtii ohjelman käyttöliittymän piirtämisestä.
 */

public class Interface {
    
    public static HBox displayInformation(JSONObject obj, int color, int r, int g, int b, FileSystem fileSystem) {
        
        Rectangle colorDisplay = new Rectangle(60, 20);
        Color c = Color.rgb(r, g, b);   
        colorDisplay.setFill(c);
        
        Text text1 = new Text("Province name: ");
        String provName = (String) obj.get("name");
        TextField textfield1 = new TextField(provName);
        VBox info1 = new VBox(10, text1, textfield1);
        
        Text text2 = new Text("ID: ");
        String provID = (String) obj.get("id");
        TextField textfield2 = new TextField(provID);
        VBox info2 = new VBox(10, text2, textfield2);
        
        Text text3 = new Text("Owner id: ");
        String provOwner = (String) obj.get("ownerid");
        TextField textfield3 = new TextField(provOwner);
        VBox info3 = new VBox(10, text3, textfield3);
        
        Text text4 = new Text("Terrain id: ");
        String provTerrain = (String) obj.get("terrainid");
        TextField textfield4 = new TextField(provTerrain);
        VBox info4 = new VBox(10, text4, textfield4);
        
        Text text5 = new Text("Population: ");
        String provPopulation = (String) obj.get("population");
        TextField textfield5 = new TextField(provPopulation);
        VBox info5 = new VBox(10, text5, textfield5);
        
        Text text6 = new Text("Culture id: ");
        String provCulture = (String) obj.get("cultureid");
        TextField textfield6 = new TextField(provCulture);
        VBox info6 = new VBox(10, text6, textfield6);
        
        Text text7 = new Text("Resource id: ");
        String provResource = (String) obj.get("resourceid");
        TextField textfield7 = new TextField(provResource);
        VBox info7 = new VBox(10, text7, textfield7);
        
        Button save = new Button("Save");
        save.setOnAction(e -> {
            JSONObject result = new JSONObject();
            result.put("color", Integer.toString(color));
            result.put("name", (textfield1.getText()));
            result.put("id", (textfield2.getText()));
            result.put("ownerid", (textfield2.getText()));
            result.put("terrainid", (textfield2.getText()));
            result.put("population", (textfield2.getText()));
            result.put("cultureid", (textfield2.getText()));
            result.put("resourceid", (textfield2.getText()));
            
            ProvinceParser.saveProvince(result, fileSystem.jsonFile);
        });
        
        Button open = new Button("Open new JSON");
        open.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File userDirectory = new File("./");
            fileChooser.setInitialDirectory(userDirectory);
            FileChooser.ExtensionFilter jsonFilter = new FileChooser.ExtensionFilter("JSON Files", "*.json");
            fileChooser.getExtensionFilters().add(jsonFilter);
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                FileSystem.setJsonFile(file);
            }
        });
        
        Button openImage = new Button("Open new map");
        openImage.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File userDirectory = new File("./");
            fileChooser.setInitialDirectory(userDirectory);
            FileChooser.ExtensionFilter jsonFilter = new FileChooser.ExtensionFilter("Bitmap Files", "*.bmp");
            fileChooser.getExtensionFilters().add(jsonFilter);
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                FileSystem.setImageFile(file);
                Image image = new Image(file.toURI().toString());
                SceneHandler.mainScene(image);
            }
        });
        
        Button reset = new Button("Reset all");

        reset.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Alert");
            alert.setHeaderText("Are you sure you want to reset everything?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    ProvinceParser.resetProvinceData(fileSystem.jsonFile);
                }
            });
            
        });
        

        VBox buttons = new VBox(save, reset, open, openImage);
        buttons.setSpacing(20);   
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        
        Pane spacer = new Pane();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(1, 20);
        
        VBox content = new VBox(10, colorDisplay, info1, info2, info3, info4, info5, info6, info7, spacer, buttons);
        ScrollPane scrollPane = new ScrollPane(content);
        HBox information = new HBox(40, scrollPane);
        return information;
    }
    
    public static HBox startUI(){
        
        TextField jsonField = new TextField ();
        jsonField.setPrefWidth(400);
        jsonField.setPromptText("Path to used JSON-file.");        
        
        Button openJson = new Button("Open JSON");
        openJson.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File userDirectory = new File("./");
            fileChooser.setInitialDirectory(userDirectory);
            FileChooser.ExtensionFilter jsonFilter = new FileChooser.ExtensionFilter("JSON Files", "*.json");
            fileChooser.getExtensionFilters().add(jsonFilter);
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                FileSystem.setJsonFile(file);
                jsonField.setText(file.toString());
            }
        });
        
        HBox jsonBox = new HBox(openJson, jsonField);
        jsonBox.setSpacing(10);
        
        TextField imageField = new TextField ();
        imageField.setPrefWidth(400);
        imageField.setPromptText("Path to used image file.");   
        
        Button openImage = new Button("Open map");
        openImage.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File userDirectory = new File("./");
            fileChooser.setInitialDirectory(userDirectory);
            FileChooser.ExtensionFilter jsonFilter = new FileChooser.ExtensionFilter("Bitmap Files", "*.bmp");
            fileChooser.getExtensionFilters().add(jsonFilter);
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                FileSystem.setImageFile(file);
                imageField.setText(file.toString());
            }
        });
        
        HBox imageBox = new HBox(openImage, imageField);
        imageBox.setSpacing(10);
        
        Button goToMain = new Button("Continue");
        goToMain.setOnAction(e -> {
                if (!FileSystem.jsonFile.exists()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Alert");
                    alert.setHeaderText("No JSON selected.");
                    alert.showAndWait();
                } else if(!FileSystem.imageFile.exists()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Alert");
                    alert.setHeaderText("No map image selected.");
                    alert.showAndWait(); 
                } else {
                    SceneHandler.mainScene(new Image(FileSystem.imageFile.toURI().toString()));
                }
        });
        
        
        VBox buttons = new VBox(jsonBox, imageBox, goToMain);
        buttons.setPadding(new Insets(15, 12, 15, 12));
        buttons.setSpacing(40);
        HBox information = new HBox(buttons);
        return information;
    }
    
}

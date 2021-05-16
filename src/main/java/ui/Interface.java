package ui;

import java.io.File;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import dao.ProvinceParser;
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
import dao.FileSystem;
import org.json.simple.JSONObject;

/**
 * Luokka huolehtii ohjelman käyttöliittymän piirtämisestä.
 */

public class Interface {
    
    /**
    * Metodi rakentaa käyttöliittymän oikean laidan osan.
    */
    
    public static HBox displayInformation(JSONObject obj, int color, int r, int g, int b, FileSystem fileSystem) {

        VBox info1 = propertyDisplay(obj, "Province name", "name");
        VBox info2 = propertyDisplay(obj, "ID", "id");
        VBox info3 = propertyDisplay(obj, "Owner id", "ownerid");
        VBox info4 = propertyDisplay(obj, "Terrain id", "terrainid");
        VBox info5 = propertyDisplay(obj, "Population", "population");
        VBox info6 = propertyDisplay(obj, "Culture id", "cultureid");
        VBox info7 = propertyDisplay(obj, "Resource id", "resourceid");
        
        Button save = new Button("Save");
        save.setOnAction(e -> {
            JSONObject result = new JSONObject();
            result.put("color", Integer.toString(color));
            result.put("name", (getPropertyValue(info1)));
            result.put("id", (getPropertyValue(info2)));
            result.put("ownerid", (getPropertyValue(info3)));
            result.put("terrainid", (getPropertyValue(info4)));
            result.put("population", (getPropertyValue(info5)));
            result.put("cultureid", (getPropertyValue(info6)));
            result.put("resourceid", (getPropertyValue(info7)));
            
            ProvinceParser.saveProvince(result, fileSystem.jsonFile);
        });
        
        Button openJSON = new Button("Open new JSON");
        openJSON.setOnAction(e -> {
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
        

        VBox buttons = new VBox(save, reset, openJSON, openImage);
        buttons.setSpacing(20);   
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        
        Pane spacer = new Pane();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        spacer.setMinSize(1, 20);
        
        VBox content = new VBox(10, colorDisplay(r, g, b), info1, info2, info3, info4, info5, info6, info7, spacer, buttons);
        ScrollPane scrollPane = new ScrollPane(content);
        HBox information = new HBox(40, scrollPane);
        return information;
    }
    
    /**
    * Metodi rakentaa sovelluksen aluksi näyttämän käyttöliittymän.
    */
    
    public static HBox startUI() {
        
        TextField jsonField = new TextField();
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
        
        TextField imageField = new TextField();
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
            if (!FileSystem.jsonFile.exists()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alert");
                alert.setHeaderText("No JSON selected.");
                alert.showAndWait();
            } else if (!FileSystem.imageFile.exists()) {
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
    
    /**
    * Metodi palauttaa annettuja RGB väriarvoja vastaavan Rectangle-olion.
    */
    
    private static Rectangle colorDisplay(int r, int g, int b) {
        Rectangle colorDisplay = new Rectangle(60, 20);
        Color c = Color.rgb(r, g, b);   
        colorDisplay.setFill(c);
        return colorDisplay;
    }
    
    /**
    * Metodi rakentaa ja palauttaa VBox-olion jonka sisälle on rakennettuna annetuista parametreistä Text- ja TextField-oliot.
    */
    
    private static VBox propertyDisplay(JSONObject obj, String label, String value) {
        Text text1 = new Text(label);
        String provName = (String) obj.get(value);
        TextField textfield1 = new TextField(provName);
        VBox info = new VBox(10, text1, textfield1);
        return info;
    }
    
    /**
    * Metodi palauttaa PropertyDisplay-metodin rakentamasta oliosta sen sisältämän TextField:n tekstimuuttujan.
    */
    
    private static String getPropertyValue(VBox info) {
        ObservableList<Node> childsHB = info.getChildren();
        TextField tf = (TextField) childsHB.get(1);
        String value = tf.getText();
        return value;
    }
}

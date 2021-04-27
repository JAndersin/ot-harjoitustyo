package ui;

import json.ProvinceParser;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.json.simple.JSONObject;

public class Interface {
    
    public static HBox displayInformation(JSONObject obj, int color, int r, int g, int b) {
        
        // create a rectangle to display currently selected color
        
        Rectangle colorDisplay = new Rectangle(60,20);
        Color c = Color.rgb(r,g,b);   
        colorDisplay.setFill(c);
        
        // create textfields to display information and to enable editing it 
        
        Text text1 = new Text("Provinssin nimi: ");
        String provName = (String) obj.get("name");
        TextField textfield1 = new TextField(provName);
        VBox info1 = new VBox(10, text1, textfield1);
        
        Text text2 = new Text("id: ");
        String provID = (String) obj.get("id");
        TextField textfield2 = new TextField(provID);
        VBox info2 = new VBox(10, text2, textfield2);
        
        Text text3 = new Text("omistajan id: ");
        String provOwner = (String) obj.get("ownerid");
        TextField textfield3 = new TextField(provOwner);
        VBox info3 = new VBox(10, text3, textfield3);
        
        Text text4 = new Text("maastotyyppi id: ");
        String provTerrain = (String) obj.get("terrainid");
        TextField textfield4 = new TextField(provTerrain);
        VBox info4 = new VBox(10, text4, textfield4);
        
        Text text5 = new Text("asukasmäärä: ");
        String provPopulation = (String) obj.get("population");
        TextField textfield5 = new TextField(provPopulation);
        VBox info5 = new VBox(10, text5, textfield5);
        
        Text text6 = new Text("kulttuuri id: ");
        String provCulture = (String) obj.get("cultureid");
        TextField textfield6 = new TextField(provCulture);
        VBox info6 = new VBox(10, text6, textfield6);
        
        Text text7 = new Text("tuotettu resurssi id: ");
        String provResource = (String) obj.get("resourceid");
        TextField textfield7 = new TextField(provResource);
        VBox info7 = new VBox(10, text7, textfield7);

        // create button to save current information to the JSON file
        // create JSONObject and input values from every textfield to it
        
        Button save = new Button("Tallenna");

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
            
            ProvinceParser.saveProvince(result);
        });
        
        // create a reset button to clear the JSON file, also display
        // a warning to user to avoid accidental wipes
        
        Button reset = new Button("Nollaa kaikki tiedot");

        reset.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Huomio");
            alert.setHeaderText("Oletko varma, että haluat nollata kaikki tiedot?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    ProvinceParser.resetProvinceData();
                }
            });
            
        });
        
        // stack every children to it's parent and return the whole panel
        
        VBox content = new VBox(10, colorDisplay, info1, info2, info3, info4, info5, info6, info7, save, reset);
        HBox information = new HBox(40, content);
        return information;
    }
    
}

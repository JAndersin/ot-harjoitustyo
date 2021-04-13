import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Image mapImage = new Image("file:src/main/java/ui/map.bmp");

        ImageView imageView = new ImageView(mapImage);
        imageView.setPreserveRatio(true);

        mouseListener(imageView,mapImage);

        HBox info = showSelected();

        Pane map = new Pane(imageView);
        ScrollPane scrollPane = new ScrollPane(map);
        HBox root = new HBox(scrollPane, info);

        stage.setScene(new Scene(root));
        stage.setTitle("Province Data Editor");
        stage.show();
    }
    
    private void mouseListener(ImageView imageView, Image map) {
        imageView.setOnMousePressed(e -> {
            if (e.isPrimaryButtonDown()) {
                
                PixelReader pixelreader = map.getPixelReader();
                Color color = pixelreader.getColor((int) e.getX(),(int) e.getY());
                System.out.println("RGB Value of the selection: "+(int)(color.getRed() * 255) +", "+ (int)(color.getGreen() * 255) +", "+ (int)(color.getBlue() * 255));
                
            }
        });
    }
    
    private HBox showSelected() {
        Text text1 = new Text("Provinssin nimi: ");
        TextField textfield1 = new TextField("");
        VBox info1 = new VBox(10, text1,textfield1);
        
        Text text2 = new Text("id: ");
        TextField textfield2 = new TextField("");
        VBox info2 = new VBox(10, text2,textfield2);
        
        Text text3 = new Text("omistajan id: ");
        TextField textfield3 = new TextField("");
        VBox info3 = new VBox(10, text3,textfield3);
        
        Text text4 = new Text("maastotyyppi: ");
        TextField textfield4 = new TextField("");
        VBox info4 = new VBox(10, text4,textfield4);
        
        Text text5 = new Text("asukasmäärä: ");
        TextField textfield5 = new TextField("");
        VBox info5 = new VBox(10, text5,textfield5);
        
        Text text6 = new Text("kulttuuri: ");
        TextField textfield6 = new TextField("");
        VBox info6 = new VBox(10, text6,textfield6);
        
        Text text7 = new Text("tuotettu resurssi: ");
        TextField textfield7 = new TextField("");
        VBox info7 = new VBox(10, text7,textfield7);

        Button save = new Button("Tallenna");

        VBox content = new VBox(10,info1,info2,info3,info4,info5,info6,info7, save);
        
        HBox information = new HBox(10,content);
        information.setPadding(new Insets(10));
        return information;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
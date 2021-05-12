package ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public static Stage stage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        stage = primaryStage;
        SceneHandler.startScene();
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.setTitle("Province Data Editor");
        stage.show();       
        
    }
    
    public static Stage getStage(){
        return stage;
    }

    
    public static void main(String[] args) {
        launch(args);
    }

}
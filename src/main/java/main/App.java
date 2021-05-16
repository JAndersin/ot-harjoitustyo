package main;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.SceneHandler;

/**
 * Luokka toimii sovelluksen varsinaisena pääluokkana jonka ainoa tehtävä on pitää huolta ohjelman stagen piirtämisestä ja tarvittaessa palauttaa se.
 */

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
    
    /**
    * Metodi palauttaa ohjelman nykyisen stage-muuttujan.
    */
    
    public static Stage getStage() {
        return stage;
    }

    
    public static void main(String[] args) {
        launch(args);
    }

}
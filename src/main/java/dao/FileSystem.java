package dao;

import java.io.File;

/**
 * Luokka pitää kirjaa ohjelman käyttämien tiedostojen sijainneista.
 */

public class FileSystem {
    
    /**
     * Kaksi julkista File-muuttujaa joiden arvo asetetaan Interface-luokalla.
     */
    
    public static File jsonFile = new File("");
    public static File imageFile = new File("");
        
    /**
    * Metodi asettaa File-muuttujan jsonFile.
    */
    
    public static void setJsonFile(File newFile) {
        jsonFile = newFile;
        System.out.println(jsonFile);
    }
    
    /**
    * Metodi asettaa File-muuttujan imageFile.
    */
    
    public static void setImageFile(File newFile) {
        imageFile = newFile;
        System.out.println(imageFile);
    }
    
    /**
    * Metodi palauttaa File-muuttujan jsonFile.
    */
    
    public File returnJsonFile() {
        return this.jsonFile;
    }   
    
    /**
    * Metodi palauttaa File-muuttujan imageFile.
    */
    
    public File returnImageFile() {
        return this.imageFile;
    }   
}

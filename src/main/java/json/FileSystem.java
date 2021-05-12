package json;

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
        
    public static void setJsonFile(File newFile) {
        jsonFile = newFile;
        System.out.println(jsonFile);
    }
    
    public static void setImageFile(File newFile) {
        imageFile = newFile;
        System.out.println(imageFile);
    }
    
    public File returnJsonFile() {
        return this.jsonFile;
    }    
    
    public File returnImageFile() {
        return this.imageFile;
    }   
}

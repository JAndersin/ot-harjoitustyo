package json;

import java.io.File;

/**
 * Luokka pitää kirjaa ohjelman käyttämien tiedostojen sijainneista.
 */

public class FileSystem {
    
    /**
     * Julkinen File-muuttuja joka asetetaan Interface-luokan open-napilla.
     */
    
    public static File jsonFile = new File("");
        
    public static void setJsonFile(File newFile) {
        jsonFile = newFile;
        System.out.println(jsonFile);
    }
    
    public File returnJsonFile() {
        return this.jsonFile;
    }    
}

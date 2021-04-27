package uitest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import json.ProvinceParser;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProvinssiEditoriTest {
    
    public ProvinssiEditoriTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void AddingProvinceToJSON() {
                
        JSONObject testObject = new JSONObject();
        testObject.put("color", "123456789");
        testObject.put("id", "1");
        testObject.put("name", "null");
        testObject.put("ownerid", "242");
        testObject.put("terrainid", "2");
        testObject.put("population", "511");
        testObject.put("cultureid", "2");
        testObject.put("resourceid", "2");
        
        ProvinceParser.saveProvince(testObject);
        JSONObject returnedObject = ProvinceParser.getProvince(123456789);
        String provOwner = (String) returnedObject.get("ownerid");
        int ownerID = Integer.valueOf(provOwner);
        assertEquals(242, ownerID);
        
    }
    
    @Test
    public void ResetProvinceJSON() {
        ProvinceParser.resetProvinceData();
        try {              
            String content = new String(Files.readAllBytes(Paths.get("src/main/java/json/provinces.json")));
            assertEquals("[]", content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

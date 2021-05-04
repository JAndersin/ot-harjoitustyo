package json;

import java.io.File;
import java.io.IOException;
import json.ProvinceParser;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProvinceParserTest {
    
    private JSONObject testObject = new JSONObject();
    private JSONObject testObjectNull = new JSONObject();
    
    public ProvinceParserTest() {

    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testObject.put("color", "2372836");
        testObject.put("id", "0");
        testObject.put("name", "aaaared");
        testObject.put("ownerid", "0");
        testObject.put("terrainid", "0");
        testObject.put("population", "0");
        testObject.put("cultureid", "0");
        testObject.put("resourceid", "0");
        
        testObjectNull.put("color", "0");
        testObjectNull.put("id", "0");
        testObjectNull.put("name", "null");
        testObjectNull.put("ownerid", "0");
        testObjectNull.put("terrainid", "0");
        testObjectNull.put("population", "0");
        testObjectNull.put("cultureid", "0");
        testObjectNull.put("resourceid", "0");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testASaveProvince() throws IOException {
        File file = new File("src/test/java/json/provinces.JSON");
        ProvinceParser.saveProvince(testObject, file);
    }
    
    @Test
    public void testBGetProvince() throws IOException {
        int color = 2372836;
        File file = new File("src/test/java/json/provinces.JSON");
        JSONObject result = ProvinceParser.getProvince(color, file);
        assertEquals(testObject, result);
    }
    
    @Test
    public void testCResetProvinceData() throws IOException {
        File file = new File("src/test/java/json/provinces.JSON");
        ProvinceParser.resetProvinceData(file);
        int color = 2372836;
        JSONObject result = ProvinceParser.getProvince(color, file);
        assertEquals(testObjectNull, result);
    }
   
}

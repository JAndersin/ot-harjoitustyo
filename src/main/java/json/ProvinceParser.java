package json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProvinceParser {
    
    public static void main(String[] args) {

    }
    
    public static JSONObject getProvince(int color) {

        JSONParser parser = new JSONParser();
        JSONObject nullResult = new JSONObject();
        nullResult.put("color", "0");
        nullResult.put("id", "0");
        nullResult.put("name", "null");
        nullResult.put("ownerid", "0");
        nullResult.put("terrainid", "0");
        nullResult.put("population", "0");
        nullResult.put("cultureid", "0");
        nullResult.put("resourceid", "0");

        try (Reader reader = new FileReader("src/main/java/json/provinces.json")) {

            JSONArray jsonObject = (JSONArray) parser.parse(reader);

            if (jsonObject != null) {
                for (int i = 0; i < jsonObject.size(); i++) {
                    JSONObject result = (JSONObject) jsonObject.get(i);
                    String provColor = (String) result.get("color");
                    if (Integer.valueOf(provColor) == color) {
                        return result;
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return nullResult;
    }
    
    public static void saveProvince(JSONObject obj) {

        JSONParser parser = new JSONParser();
        JSONArray jsonObject = new JSONArray();
        String color = (String) obj.get("color");
        int colorvalue = Integer.valueOf(color);
        
        try (Reader reader = new FileReader("src/main/java/json/provinces.json")) {
            jsonObject = (JSONArray) parser.parse(reader);
            if (jsonObject != null) {
                for (int i = 0; i < jsonObject.size(); i++) {
                    JSONObject result = (JSONObject) jsonObject.get(i);
                    String provColor = (String) result.get("color");
                    if (Integer.valueOf(provColor) == colorvalue) {
                        jsonObject.remove(result);
                    }

                }
            }
            jsonObject.add(obj);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        try (FileWriter file = new FileWriter("src/main/java/json/provinces.json")) {
            file.write(jsonObject.toJSONString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}

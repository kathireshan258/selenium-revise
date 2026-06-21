package JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.json.Json;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

class ReadWriteJson {
  static void main() {
    JSONObject english = addJsonObject("English", 80);
    JSONObject tamil = addJsonObject("Tamil", 81);
    JSONObject maths = addJsonObject("Maths", 85);
    JSONObject science = addJsonObject("Science", 90);
    JSONObject social = addJsonObject("Social", 85);

    JSONArray subjects = createJsonArray(new JSONObject[]{tamil, english, maths, science, social});

    JSONArray languages = createJsonArray(new String[]{"Tamil", "English"});


    JSONObject kathir = new JSONObject();
    kathir.put("name", "Kathir");
    kathir.put("language", languages);
    kathir.put("subjects", subjects);


    System.out.printf(kathir.toJSONString() + "%n");

    String folderName = "contents";
    String fileName = folderName + "/student.json";
    createDir(folderName);
    writeToFile(fileName, kathir.toJSONString());

    // ------------- Reading JSON -------------
    String testDataFile = System.getProperty("user.dir") + "/contents/testData.json";
    try (FileReader reader = new FileReader(testDataFile)) {
      JSONParser parser = new JSONParser();
      JSONArray overAllArray = (JSONArray) parser.parse(reader);

      for (int i = 0; i < overAllArray.size(); i++) {
        JSONObject testCase = (JSONObject) overAllArray.get(i);
        String testCaseId = testCase.get("id").toString();
        System.out.printf("Test Case Id: %s%n", testCaseId);
        String userName = ((JSONObject) testCase.get("input")).get("username").toString();

        System.out.printf("UserName: %s%n", userName);

        Set objectKeyValPairs = testCase.entrySet();
        Iterator itr = objectKeyValPairs.iterator();
        while (itr.hasNext()) {
          String key = itr.next().toString();
          System.out.println("Key: " + key);
        }
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException | ParseException e) {
      throw new RuntimeException(e);
    }
  }

  static JSONArray createJsonArray(Object[] arr) {
    JSONArray jsonArray = new JSONArray();
    boolean b = jsonArray.addAll(Arrays.asList(arr));
    if (!b) {
      System.out.printf("Not all elements are added, error is adding some elements%n");
    }
    return jsonArray;
  }

  static JSONObject addJsonObject(Map<Object, Object[]> object) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.putAll(object);
    return jsonObject;
  }

  static JSONObject addJsonObject(Object key, Object value) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put(key, value);
    return jsonObject;
  }

  static void writeToFile(String path, String content) {
    try (OutputStream out = new FileOutputStream(path)) {
      out.write(content.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void createDir(String dirName) {
    File file = new File(dirName);
    if (!file.exists()) {
      if (!file.mkdirs()) {
        System.out.printf("Error in creating dir%n");
      }
    }
  }
}

package ymlReadWrite;

import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.List;

class YamlRead {
  static void main() {
    String path = System.getProperty("user.dir") + "\\contents\\student.yaml";
    System.out.println(path);
    try(FileReader file = new FileReader(path)) {
      YamlReader reader = new YamlReader(file);
      Map data = (Map) reader.read();
      List student = (List) data.get("subjects");
      System.out.println(student);
      List list = (List) data.get("language");
      System.out.println(list);
      System.out.println(list.get(0));


    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

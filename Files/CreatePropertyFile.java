package Files;

import java.io.*;
import java.util.Properties;

class CreatePropertyFile {
  static void main() {
    String fileName = "config.properties";
    String folderName = "config";

    // method 1
    try (OutputStream outputStream = new FileOutputStream(fileName)) {
      Properties properties = new Properties();
      properties.setProperty("webdriver.chrome.driver", "chromeDriverPath");
      properties.setProperty("webdriver.edge.driver", "edgeDriverPath");
      properties.setProperty("webdriver.gecko.driver", "geckoDriverPath");

      properties.store(outputStream, "Setting web driver");
    } catch (IOException e) {
      e.printStackTrace();
    }

    //method 2
    String absFolderPath = createFolder(folderName);
    System.out.printf("Folder created at %s%n", absFolderPath);

    File propFile = new File(folderName, fileName);
    Properties props = new Properties();
    props.setProperty("webdriver.chrome.driver", "chromeDriverPath");
    props.setProperty("webdriver.edge.driver", "edgeDriverPath");
    props.setProperty("webdriver.gecko.driver", "geckoDriverPath");

    try (OutputStream writer = new FileOutputStream(propFile)) {
      props.store(writer, "WebDriver config");
    } catch (IOException e) {
      e.printStackTrace();
    }

    readFromPropFile(folderName + "/" + fileName);

  }


  static String createFolder(String folderName) {
    File folder = new File(folderName);
    String path = null;
    if (!folder.exists()) {
      if (folder.mkdirs()) {
        System.out.printf("Folder %s created successfully!%n", folderName);
        try {
          System.out.printf("Canonical folder path:%s%n", folder.getCanonicalPath());
        } catch (IOException e) {
          e.printStackTrace();

          System.out.printf("Absolute folder path:%s%n", folder.getAbsolutePath());
          path = folder.getAbsolutePath();
        }
      }
    } else {
      System.out.printf("Folder %s already exist!%n", folderName);
    }
    return path;
  }

  static void readFromPropFile(String path) {
    try (InputStream stream = new FileInputStream(path)) {
      String CHROME_DRIVER = "webdriver.chrome.driver";
      String EDGE_DRIVER = "webdriver.edge.driver";
      String GECKO_DRIVER = "webdriver.gecko.driver";
      Properties prop = new Properties();
      prop.load(stream);
      System.out.printf("Chrome Driver: %s%n",prop.getProperty(CHROME_DRIVER));
      System.out.printf("Edge Driver: %s%n",prop.getProperty(EDGE_DRIVER));
      System.out.printf("Firefox/ Gecko Driver: %s%n",prop.getProperty(GECKO_DRIVER));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

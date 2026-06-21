package selenium.test1;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

class VerifyLink {
  static void check(String link) {
    HttpClient client = HttpClient.newHttpClient();
    String jsonPayload = """
                {
                    "title": "foo",
                    "body": "bar",
                    "userId": 1
                }
                """;
    if (link == null || link.isEmpty() || !link.contains("http")) return;
    HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(link))
        .header("accept", "*/*")
//        .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
//        .header("Content-Type", "application/json")
        .build();
    HttpResponse<String> response = null;
    try {
      response = client.send(request, HttpResponse.BodyHandlers.ofString());

    if (response.statusCode() == 200) {
      System.out.println(response.body());
    } else {
      System.out.println("Invalid link::" + link);
    }
    } catch (IOException | InterruptedException e) {
      System.out.println("Malformed Link::" + link);
    }
    client.close();
  }


  private void verifyLink(String link) {
    HttpClient client = HttpClient.newHttpClient();
    if(link == null || link.isEmpty() || !link.contains("http")) return;
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(link))
        .GET().headers("accept", "*/*").build();
    HttpResponse<String> response = null;
    try {
      response = client.send(request, HttpResponse.BodyHandlers.ofString());
      if (response.statusCode() == 200) {
        System.out.println("Valid link::"+link);
      } else {
        System.out.println("Invalid link::"+link);
      }
    } catch (IOException | InterruptedException e) {
      System.out.println("Malformed Link::" + link);
    }

    try {
      URL url = URI.create(link).toURL();

      //Open HTTP Connection
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      //Set timeout
      connection.setConnectTimeout(5000);

      //Set Head to check only the headers, not the entire content
      connection.setRequestMethod("HEAD");

      //Connect the URL
      connection.connect();


      if (connection.getResponseCode() == 200) {
        System.out.println("Valid link::"+link);
      } else  {
        System.out.println("Invalid link::"+link + connection.getResponseMessage() + ":" + HttpURLConnection.HTTP_NOT_FOUND);
      }

      connection.disconnect();

    } catch (IOException e) {
      System.out.println("Malformed Link::" + link);
    } finally {
      client.close();
    }

  }

  private void postURL(String link, String body) {
    try {
      URL url = URI.create(link).toURL();

      //Connection open
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      //Connection Timeout
      connection.setConnectTimeout(5000);

      //Set Request method
      connection.setRequestMethod("POST");

      //Important: This enables the request body
      connection.setDoOutput(true);

      //Optional header
      connection.setRequestProperty("accept", "*/*");
      connection.setRequestProperty("Content-Type", "application/json");

      //Request body
      String jsonPayload = body;

      //Write body
      OutputStream os = connection.getOutputStream();
        byte[] input = jsonPayload.getBytes(StandardCharsets.UTF_8);
        os.write(input, 0, input.length);


    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

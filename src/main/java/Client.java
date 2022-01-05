import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Client {
public void login(User user) throws Exception{
    URL myURL = new URL("http://localhost:8080/Login_Servlet/login");
    HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();
    //transform user to gson format
    User loginUser = new User();
    Gson gson = new Gson();
    String jsonString = gson.toJson(loginUser);
    byte[] body = jsonString.getBytes(StandardCharsets.UTF_8);
    //set up the header
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Accept", "text/html");
    conn.setRequestProperty("charset", "utf-8");
    conn.setRequestProperty("Content-Length", Integer.toString(body.length));
    conn.setDoOutput(true);
//write the body of the login request
    try (OutputStream outputStream = conn.getOutputStream()) {
        outputStream.write(body, 0, body.length);
    }

//
    BufferedReader bufferedReader = new BufferedReader(new
            InputStreamReader(conn.getInputStream(), "utf-8"));
    String inputLine;//responded text from servlet
// Read the body of the login response
    while ((inputLine = bufferedReader.readLine()) != null) {
        System.out.println(inputLine);
    }
    bufferedReader.close();

}

public void register(User user) throws Exception{
    URL myURL = new URL("http://localhost:8080/Login_Servlet/register");
    HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();
    //transform user to gson format
    User registerUser = new User();
    Gson gson = new Gson();
    String jsonString = gson.toJson(registerUser);
    byte[] body = jsonString.getBytes(StandardCharsets.UTF_8);
    //set up the header
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Accept", "text/html");
    conn.setRequestProperty("charset", "utf-8");
    conn.setRequestProperty("Content-Length", Integer.toString(body.length));
    conn.setDoOutput(true);
    //write the body of the register request
    try (OutputStream outputStream = conn.getOutputStream()) {
        outputStream.write(body, 0, body.length);
    }

    BufferedReader bufferedReader = new BufferedReader(new
            InputStreamReader(conn.getInputStream(), "utf-8"));
    String inputLine;//responded text from servlet
// Read the body of the login response
    while ((inputLine = bufferedReader.readLine()) != null) {
        System.out.println(inputLine);
    }
    bufferedReader.close();
}
}

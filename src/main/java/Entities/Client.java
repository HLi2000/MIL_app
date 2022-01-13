package Entities;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * The Entities.Client is used to communicate with the servlet
 *
 * @author  Hao Li
 * @since   2021-12-05
 */
public class Client {

    /**
     * The login method post a User object to the servlet and get result as response
     *
     * @param user info
     * @return result
     */
    public String login(User user) throws Exception{
        //set up connection
        URL myURL = new URL("https://mil-servlet.herokuapp.com/login");

        return getResult(user, myURL);
    }

    /**
     * The register method post a User object to the servlet and get result as response
     *
     * @param user info
     * @return result
     */
    public String register(User user) throws Exception{
        //set up connection
        URL myURL = new URL("https://mil-servlet.herokuapp.com/register");

        return getResult(user, myURL);
    }

    /**
     * The delete method post a User object to the servlet and get result as response
     *
     * @param user info
     * @return result
     */
    public String delete(User user) throws Exception{
        //set up connection
        URL myURL = new URL("https://mil-servlet.herokuapp.com/delete");

        return getResult(user, myURL);
    }

    /**
     * The search method posts searchInfo to the servlet and return the search result
     * of an array of Img which contain all info about each image
     *
     * @param searchInfo search info
     * @return UI.Entities.Img[], an array of UI.Entities.Img which contain all info about each image
     */
    public Img[] search(SearchInfo searchInfo) throws Exception{

        // Set up the body data
        Gson gson = new Gson();
        String jsonString = gson.toJson(searchInfo);

        // Set up the Connection
        URL myURL = new URL("https://mil-servlet.herokuapp.com/search");
        HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();

        // Set up the header
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        // Write the body of the request
        try(OutputStream os = conn.getOutputStream()) {
            byte[] body = jsonString.getBytes(StandardCharsets.UTF_8);
            os.write(body, 0, body.length);
        }

        // Read the body of the response
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                conn.getInputStream(), StandardCharsets.UTF_8));
        String resp;
        while ((resp = bufferedReader.readLine()) != null) {
            Gson gson2 = new Gson();
            Img[] img_a=gson2.fromJson(resp,Img[].class);
            for (Img img : img_a) {
                img.setThumbnail(getThumbnail(img));
            }

            return img_a;
        }
        bufferedReader.close();

        return new Img[]{};
    }

    /**
     * The getThumbnail method posts a certain Img to the servlet to get its thumbnail
     *
     * @param img image info
     * @return InputStream of the thumbnail
     */
    public InputStream getThumbnail(Img img) throws Exception{

        // Set up the body data
        String filename= img.getFile_name();
        byte[] body = filename.getBytes(StandardCharsets.UTF_8);

        // Set up the Connection
        URL myURL = new URL("https://mil-servlet.herokuapp.com/thumbnail");

        return getInputStream(body, myURL);
    }

    /**
     * The getImg method posts a certain Img to the servlet to get its raw image
     *
     * @param img image info
     * @return InputStream of the raw image
     */
    public InputStream getImg(Img img) throws Exception{
        // Set up the body data
        String filename= img.getFile_name();
        byte[] body = filename.getBytes(StandardCharsets.UTF_8);

        // Set up the Connection
        URL myURL = new URL("https://mil-servlet.herokuapp.com/img");

        return getInputStream(body, myURL);
    }

    /**
     * Extracted method for post user info and get result resp
     *
     * @param user info
     * @param myURL url
     * @return result
     */
    private String getResult(User user, URL myURL) throws IOException {
        //set up conn
        HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();

        //transform user to gson format
        Gson gson = new Gson();
        String jsonString = gson.toJson(user);

        //set up the header
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        //write the body of the request
        try (OutputStream outputStream = conn.getOutputStream()) {
            byte[] body = jsonString.getBytes(StandardCharsets.UTF_8);
            outputStream.write(body, 0, body.length);
        }
        catch(Exception e){
            return e.getMessage();
        }

        BufferedReader bufferedReader = new BufferedReader(new
                InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
        String inputLine;//responded text from servlet

        // Read the body of the response
        inputLine = bufferedReader.readLine();
        bufferedReader.close();

        return inputLine;
    }

    /**
     * Extracted method for post req of filename and get img or thumbnail
     *
     * @param body req body
     * @param myURL url
     * @return InputStream of img or thumbnail
     */
    private InputStream getInputStream(byte[] body, URL myURL) throws IOException {
        //set up conn
        HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();

        // Set up the header
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Accept", "text/html");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(body.length));
        conn.setDoOutput(true);

        // Write the body of the request
        try (OutputStream outputStream = conn.getOutputStream()) {
            outputStream.write(body, 0, body.length);
        }

        // Read and return the body of the response
        return conn.getInputStream();
    }
}

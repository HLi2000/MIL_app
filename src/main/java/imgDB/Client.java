import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * The Client is used to communicate with the servlet
 *
 * @author  Hao Li
 * @since   2021-12-05
 */
public class Client {

    public Client(){
    }

    public void login() {


    }

    /**
     * The search method posts searchInfo to the servlet and return the search result
     * of an array of Img which contain all info about each image
     *
     * @param searchInfo search info
     * @return Img[], an array of Img which contain all info about each image
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

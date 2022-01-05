import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns={"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet{
    private boolean registerresult;
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Gson gson = new Gson();
        User registerUser = gson.fromJson(reqBody,User.class);//user received from client for registration
        DBDao d2 = new DBDao();
        registerresult = d2.Register(registerUser);
        resp.setContentType("text/html");
        if(registerresult = true) {

            resp.getWriter().write("you are registered");
        }
        else{
            resp.getWriter().write("registration failed");
        }
    }
}

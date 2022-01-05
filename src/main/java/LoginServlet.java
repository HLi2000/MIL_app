import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(urlPatterns={"/login"},loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
    private boolean loginresult;
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String reqBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Gson gson = new Gson();
        User loginUser = gson.fromJson(reqBody,User.class);//user received from client for login
        DBDao d1 = new DBDao();
        loginresult = d1.Login(loginUser);

        //response to client
        resp.setContentType("text/html");
        if(loginresult = true) {

            resp.getWriter().write("correct username and password");
        }
        else{
            resp.getWriter().write("wrong username or password");
        }

    }

}

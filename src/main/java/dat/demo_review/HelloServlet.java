package dat.demo_review;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "hello", value = "/hello")
public class HelloServlet extends HttpServlet
{
    private String message;

    public void init()
    {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");

        request.setAttribute("message", "Her er en hilsen fra din servlet");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void destroy()
    {
    }
}
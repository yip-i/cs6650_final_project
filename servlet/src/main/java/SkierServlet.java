
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeoutException;






@WebServlet(name = "SkierServlet", value = "/SkierServlet")
public class SkierServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        String urlPath = req.getPathInfo();
        System.out.println(urlPath);
        res.setStatus(HttpServletResponse.SC_CREATED);

    }

    /**
     * Checks if the url is valid.
     * @param urlPath
     * @return
     */
    private boolean isUrlValid(String[] urlPath) {
        // TODO: validate the request url path according to the API spec
        // urlPath  = "/1/seasons/2019/days/1/skiers/123"
        // urlParts = [, 1, seasons, 2019, day, 1, skier, 123]
//        System.out.println(urlPath[1]);
        if(!urlPath[2].equalsIgnoreCase("seasons")) {
            return false;
        } else if(!urlPath[4].equalsIgnoreCase("days")){
            return false;
        } else if(!urlPath[6].equalsIgnoreCase("skiers")){
            return false;
        }


        if(!isInt(urlPath[1]) || !isInt(urlPath[7])){
            return false;
        }

        return true;
    }

    /**
     * Checks if a string is an integer or not.
     * @param s String value that we are checking.
     * @return True if it s is an int, false otherwise.
     */
    private boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        String urlPath = req.getPathInfo();
        res.setStatus(HttpServletResponse.SC_CREATED);

    }




}

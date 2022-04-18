

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ResortServlet", value = "/ResortServlet")
public class ResortServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        res.setStatus(HttpServletResponse.SC_OK);

    }

    /**
     * Two separate url paths.
     * @param urlPath
     * @return
     */
    private boolean isUrlValidDays(String[] urlPath) {
        // TODO: validate the request url path according to the API spec
        // urlPath  = "/1/seasons/2019/days/1/skiers/123"
        // urlParts = [, 1, seasons, 2019, day, 1, skier, 123]


        if (!urlPath[2].equalsIgnoreCase("seasons")) {
//            System.out.println(urlPath[2]);

            return false;
        } else if (!urlPath[4].equalsIgnoreCase("day")) {
            System.out.println(urlPath[4]);

            return false;
        } else if (!urlPath[6].contains("skiers")) {
            //Equals ignore case does not work.
            System.out.println(urlPath[6]);

            return false;
        }

        return true;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        res.setStatus(HttpServletResponse.SC_CREATED);
    }
}

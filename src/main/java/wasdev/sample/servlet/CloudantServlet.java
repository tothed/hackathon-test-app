package wasdev.sample.servlet;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.views.AllDocsResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("SimpleServlet")
public class CloudantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Database client = CloudantClientMgr.getDB("myDb");
        AllDocsResponse resp = client.getAllDocsRequestBuilder().includeDocs(true).build().getResponse();


        response.setContentType("text/html");
        response.getWriter().print("Hello World!" + "Do It (4) result is " + Hello.doIt(4));
    }

}

package servlet;

import dao.BlogCollectDao;
import impl.BlogCollectDaoImpl;
import net.sf.json.JsonConfig;
import util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;

@WebServlet("/showCollectServlet")
public class showCollectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BigDecimal showcol = new BigDecimal(request.getParameter("userid"));
        BlogCollectDao blogCollectDao = new BlogCollectDaoImpl();
//        List<BlogCollect> blogCollects = blogCollectDao.showcollect(showcol);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
//        JSONArray array = JSONArray.fromObject(blogCollects,jsonConfig);
        PrintWriter out = response.getWriter();
//        out.print(array);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

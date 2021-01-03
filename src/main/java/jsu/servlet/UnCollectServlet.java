package jsu.servlet;

import jsu.dao.CollectDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/UnCollectServlet")
public class UnCollectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符
        response.setContentType("text/html;charset=UTF-8");
        Integer playerId = Integer.parseInt(request.getParameter("playerId"));
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        CollectDao collectDao = new CollectDao();
        boolean t = collectDao.deleteCollect(userId,playerId);
//        boolean t = true;
        if(t == true){
            PrintWriter out = response.getWriter();
            JSONArray jsonArray = JSONArray.fromObject( 1 );
            out.write(String.valueOf(jsonArray));
        }
    }
}

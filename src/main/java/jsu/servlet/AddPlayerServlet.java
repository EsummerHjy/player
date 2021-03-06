package jsu.servlet;

import jsu.bean.Commentary;
import jsu.bean.Player;
import jsu.dao.CommentaryDao;
import jsu.dao.PlayerDao;
import jsu.dao.TopicDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/AddPlayerServlet")
public class AddPlayerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符
        response.setContentType("text/html;charset=UTF-8");
        String information = request.getParameter("information");
        Integer typeId = Integer.valueOf(request.getParameter("typesId"));
        PlayerDao playerDao = new PlayerDao();
        boolean t = playerDao.savePlayer(information,typeId);
        List<Player> list = playerDao.getPlayer();
        if(t == true){
            PrintWriter out = response.getWriter();
            JSONArray jsonArray = JSONArray.fromObject( list );
            out.write(String.valueOf(jsonArray));
        }
    }
}

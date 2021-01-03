package jsu.servlet;

import jsu.bean.Player;
import jsu.bean.SuperManager;
import jsu.bean.User;
import jsu.dao.PlayerDao;
import jsu.dao.SuperManagerDao;
import jsu.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/PlayerTypeServlet")
public class PlayerTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符
        response.setContentType("text/html;charset=UTF-8");
        //获取邮箱密码
//        int type = (int)request.getSession().getAttribute("type");
//        System.out.println(type);
        Player player = new Player();
        PlayerDao playerDao = new PlayerDao();
        List<Player> list = playerDao.getPlayerInformation();
        request.getSession().setAttribute("playersList",list);
        PrintWriter out = response.getWriter();
        for(int i = 0;i < list.size();i++) {
            out.write("<div class='infomation'>");
            out.print(list.get(i).getInformation());
            out.write("</div>");
            out.write("<hr>");
//        out.write("</c:forEach>");
        }
    }
}

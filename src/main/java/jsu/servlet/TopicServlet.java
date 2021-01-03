package jsu.servlet;

import jsu.bean.Commentary;
import jsu.bean.Player;
import jsu.bean.Topic;
import jsu.dao.CommentaryDao;
import jsu.dao.PlayerDao;
import jsu.dao.TopicDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/TopicServlet")
public class TopicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符
        response.setContentType("text/html;charset=UTF-8");
        String information = request.getParameter("search");
        TopicDao topicDao = new TopicDao();
        List<Topic> list = topicDao.getTopicByPlayerInformation(information);
        Integer playerId = list.get(0).getPlayerId();
        request.getSession().setAttribute("playerId",playerId);
        PlayerDao playerDao = new PlayerDao();
        Integer typeId = playerDao.gettypeIdByPlayerId(playerId).getTypeId();
        request.getSession().setAttribute("typeId",typeId);
        if(list.get(0)!=null){
            request.getSession().setAttribute("information",information);
            List<Topic> top = new ArrayList<>();
            List<Topic> untop = new ArrayList<>();
            for(Topic t : list){
                if(t.isIfTop() == true){
                    top.add(t);
                }else{
                    untop.add(t);
                }
            }
            request.getSession().setAttribute("topictopList",top);
            request.getSession().setAttribute("topicuntopList",untop);
            response.sendRedirect("/player_war_exploded/jsp/topic.jsp");
        }else{
            //如果为空返回登陆页面
            //通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('查询不到，请重新输入');");
            writer.write("window.location.href = '/player_war_exploded/jsp/user.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }
}

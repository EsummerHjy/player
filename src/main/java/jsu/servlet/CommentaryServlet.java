package jsu.servlet;

import jsu.bean.Commentary;
import jsu.bean.Player;
import jsu.bean.Topic;
import jsu.dao.CommentaryDao;
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

@WebServlet(urlPatterns = "/CommentaryServlet")
public class CommentaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符
        response.setContentType("text/html;charset=UTF-8");
        Integer topicId = Integer.parseInt(request.getParameter("search"));
        System.out.println(topicId);
        CommentaryDao commentaryDao = new CommentaryDao();
        TopicDao topicDao = new TopicDao();
        List<Commentary> list = commentaryDao.getCommentaryBytopicId(topicId);
        Topic topic = topicDao.getSessionByTopicId(topicId);
        String information = topic.getSession();
        if(list.get(0)!=null){
            request.getSession().setAttribute("information",information);
            request.getSession().setAttribute("commentaryList",list);
            list = (List<Commentary>) request.getSession().getAttribute("commentaryList");
            for (Commentary p : list){
                System.out.println(p);
            }
            response.sendRedirect("/player_war_exploded/jsp/commentary.jsp");
        }else{
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('查询不到，请重新输入');");
            writer.write("window.location.href = '/player_war_exploded/jsp/player.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }
}

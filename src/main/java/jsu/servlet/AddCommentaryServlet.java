package jsu.servlet;

import jsu.bean.Commentary;
import jsu.bean.Topic;
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
import java.util.List;

@WebServlet(urlPatterns = "/AddCommentaryServlet")
public class AddCommentaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符
        response.setContentType("text/html;charset=UTF-8");
        String content = request.getParameter("content");
        CommentaryDao commentaryDao = new CommentaryDao();
        TopicDao topicDao = new TopicDao();
        String informations = (String)request.getSession().getAttribute("information");
        Integer topicId = topicDao.getTopicBySession(informations).getTopicId();
        Integer userId = (Integer)request.getSession().getAttribute("userId");
        commentaryDao.saveCommentary(content,userId,topicId);
        List<Commentary> list = commentaryDao.getCommentaryBytopicId(topicId);
        if(list.get(0)!=null){
            request.getSession().setAttribute("content",content);
            PrintWriter out = response.getWriter();
            JSONArray jsonArray = JSONArray.fromObject( list );
            out.write(String.valueOf(jsonArray));
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

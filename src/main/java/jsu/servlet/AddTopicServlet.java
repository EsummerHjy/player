package jsu.servlet;

import jsu.bean.Topic;
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

@WebServlet(urlPatterns = "/AddTopicServlet")
public class AddTopicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符
        response.setContentType("text/html;charset=UTF-8");
        String information = request.getParameter("information");
        TopicDao topicDao = new TopicDao();
        PlayerDao playerDao = new PlayerDao();
        String informations = (String)request.getSession().getAttribute("information");
        Integer playerId = playerDao.getPlayerByPlayerInformation(informations).getPlayerId();
        Integer userId = (Integer)request.getSession().getAttribute("userId");
        topicDao.saveTopic(information,userId,playerId);
        List<Topic> list = topicDao.getTopicByPlayerId(playerId);
        if(list.get(0)!=null){
            request.getSession().setAttribute("information",information);
//            List<Topic> top = new ArrayList<>();
//            List<Topic> untop = new ArrayList<>();
//            for(Topic t : list){
//                if(t.isIfTop() == true){
//                    top.add(t);
//                }else{
//                    untop.add(t);
//                }
//            }
            PrintWriter out = response.getWriter();
            JSONArray jsonArray = JSONArray.fromObject( list );
            out.write(String.valueOf(jsonArray));
//            for(int i = 0;i < top.size();i++) {
//                out.write("<div class='infomation'>");
//                out.print("话题Id："+top.get(i).getTopicId());
//                out.write("<br>");
//                out.print("话题标题："+top.get(i).getSession());
//                out.write("<br>");
//                out.print("发起用户Id："+top.get(i).getUserId());
//                out.write("<br>");
//                out.print("已置顶");
//                out.write("</div>");
//                out.write("<hr>");
//            }
//            for(int i = 0;i < top.size();i++) {
//                out.write("<div class='infomation'>");
//                out.print("话题Id："+untop.get(i).getTopicId());
//                out.write("<br>");
//                out.print("话题标题："+untop.get(i).getSession());
//                out.write("<br>");
//                out.print("发起用户Id："+untop.get(i).getUserId());
//                out.write("</div>");
//                out.write("<hr>");
//            }
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

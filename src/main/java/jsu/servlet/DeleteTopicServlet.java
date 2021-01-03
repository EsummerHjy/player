package jsu.servlet;

import jsu.bean.Topic;
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

@WebServlet(urlPatterns = "/DeleteTopicServlet")
public class DeleteTopicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符
        response.setContentType("text/html;charset=UTF-8");
        Integer topicId = Integer.parseInt(request.getParameter("topicId"));
        String session = (String)request.getParameter("session");
        TopicDao topicDao = new TopicDao();
        boolean t = topicDao.deleteTopic(topicId);
        List<Topic> list = topicDao.getTopicByPlayerInformation(session);
//        boolean t = true;
        if(t == true){
            PrintWriter out = response.getWriter();
            JSONArray jsonArray = JSONArray.fromObject( list );
            out.write(String.valueOf(jsonArray));
        }
    }
}

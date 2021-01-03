package jsu.servlet;

import com.alibaba.druid.support.json.JSONUtils;
import jsu.bean.*;
import jsu.dao.PlayerDao;
import jsu.dao.SuperManagerDao;
import jsu.dao.TopicDao;
import jsu.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置字符
        response.setContentType("text/html;charset=UTF-8");
        //获取邮箱密码
        String Email = request.getParameter("email");
        String Password = request.getParameter("password");
        String Identity = request.getParameter("identity");
        if(Identity.equals("User")) {
            //插入DAO
            UserDao userDAO = new UserDao();
            User user = userDAO.getUserByEmailAndPassword(Email, Password);
            if(user!=null){
                //不为空，进入主页面,用户名和密码正确
                //登录成功跳转页面
                request.getSession().setAttribute("identity",Identity);
                request.getSession().setAttribute("userName",user.getUserName());
                request.getSession().setAttribute("userId",user.getUserId());
                request.getSession().setAttribute("email",user.getEmail());
                request.getSession().setAttribute("password",user.getPassword());
                request.getSession().setAttribute("money",user.getMoney());
                if(user.getTypeId()!=null) {
                    request.getSession().setAttribute("utypeId", user.getTypeId());
                }else
                    request.getSession().setAttribute("utypeId", 0);
                if(user.getPlayerId()!=null)
                    request.getSession().setAttribute("uplayerId",user.getPlayerId());
                else
                    request.getSession().setAttribute("uplayerId",0);
                if(user.getCharacter() == 1){
                    request.getSession().setAttribute("character","普通会员");
                }
                else if(user.getCharacter() == 2) {
                    request.getSession().setAttribute("character", "管理者");
                }
                else if(user.getCharacter() == 3) {
                    request.getSession().setAttribute("character", "管理员");

                }
                List<Player> list = userDAO.getInformationByUserId(user.getUserId());
                request.getSession().setAttribute("playerList",list);
                response.sendRedirect("/player_war_exploded/jsp/user.jsp");
            }else{
                //如果为空返回登陆页面
                //通过response对象给客户端一个错误提示
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('您的账号或密码错误，请重新输入');");
                writer.write("window.location.href = '/player_war_exploded/html/login.html'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
        else if(Identity.equals("SuperManager")){
            //插入DAO
            SuperManagerDao superManagerDao = new SuperManagerDao();
            SuperManager superManager = superManagerDao.getSuperManagerByEmailAndPassword(Email, Password);
            if(superManager!=null){
                //不为空，进入主页面,用户名和密码正确
                //登录成功跳转页面
                UserDao userDao = new UserDao();
                TopicDao topicDao = new TopicDao();
                PlayerDao playerDao = new PlayerDao();
                List<User> usersList = userDao.getUser();
                List<Topic> topicList = topicDao.getTopic();
                List<Player> playersList = playerDao.getPlayer();
                List<Topic> reportList = new ArrayList<>();
                List<Topic> unreportList = new ArrayList<>();
                for(Topic t : topicList){
                    if(t.isIfReported() == true){
                        reportList.add(t);
                    }else{
                        unreportList.add(t);
                    }
                }
                request.getSession().setAttribute("usersList",usersList);
                request.getSession().setAttribute("playersList",playersList);
                request.getSession().setAttribute("reportList",reportList);
                request.getSession().setAttribute("unreportList",unreportList);
                response.sendRedirect("/player_war_exploded/jsp/supermanagermain.jsp");
            }else{
                //如果为空返回登陆页面
                //通过response对象给客户端一个错误提示
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('您的账号或密码错误，请重新输入');");
                writer.write("window.location.href = '/player_war_exploded/html/login.html'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
        else {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('您未选择角色，请重新输入');");
            writer.write("window.location.href = '/player_war_exploded/html/login.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }
}
package jsu.servlet;


import jsu.bean.User;
import jsu.dao.UserDao;
import jsu.bean.User;
import jsu.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符
        response.setContentType("text/html;charset=UTF-8");
        //获取前台邮箱和密码
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //插入到数据库封装对象
        User user = new User(userName, email, password, 1, 0);
        //插入DAO
        UserDao userDao = new UserDao();

        //判断是否有相同的Email
        Integer count = userDao.selectUserEmailCount(email);
        if(count>0){
            //说明数据库已有相同的Email
            //通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('申请注册的Email已被使用');");
            writer.write("window.location.href = '/player_war_exploded/html/register.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
        else{
            boolean flag =  userDao.saveUser(user);
            //判定是否注册成功
            if (flag){
                //注册成功跳转页面
                response.sendRedirect("/player_war_exploded/html/login.html");
            }
            else {
                //否则返回注册
                response.sendRedirect("/player_war_exploded/html/register.html");
                //RequestDispatcher dispatcher = request.getRequestDispatcher("/html/register.html");
                //dispatcher.forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost( request,  response);
    }
}

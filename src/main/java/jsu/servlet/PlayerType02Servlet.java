package jsu.servlet;

import jsu.bean.Player;
import jsu.dao.PlayerDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/PlayerType02Servlet")
public class PlayerType02Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符
        response.setContentType("text/html;charset=UTF-8");
        //获取邮箱密码
//        int type = (int)request.getSession().getAttribute("type");
//        System.out.println(type);
        String ty = request.getParameter("type");
        int typeId = 1;
        if(ty.equals("PG")){
            typeId = 1;
        }else if(ty.equals("SG")){
            typeId = 2;
        }else if(ty.equals("SF")){
            typeId = 3;
        }else if(ty.equals("PF")){
            typeId = 4;
        }else if(ty.equals("C")){
            typeId = 5;
        }
        Player player = new Player();
        PlayerDao playerDao = new PlayerDao();
        List<Player> list = playerDao.getPlayerInformationByTypeId(typeId);
        for(Player p : list){
            System.out.println(p);
        }
//        request.getSession().setAttribute("playersList",list);
        PrintWriter out = response.getWriter();
        JSONArray jsonArray = JSONArray.fromObject( list );
        out.write(String.valueOf(jsonArray));
//        for(int i = 0;i < list.size();i++) {
//
//            System.out.println(jsonArray.get(i));
//            System.out.println(jsonArray);
//        }
//        for(int i = 0;i < list.size();i++) {
//            out.write("<div class='infomation'>");
//            out.print(list.get(i).getInformation());
//            out.write("</div>");
//            out.write("<hr>");
//        out.write("</c:forEach>");
//        }
    }
}

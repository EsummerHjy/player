package jsu.dao;
import jsu.bean.Collect;
import jsu.bean.Player;
import jsu.bean.User;
import jsu.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public boolean saveUser(User user) {
        String sql = "INSERT INTO [User](userName,email,password,character,money)" +
                "VALUES (?,?,?,?,?)";
        return DBUtils.save(sql, user.getUserName(),user.getEmail(),user.getPassword(),user.getCharacter(),user.getMoney());
    }

    public User getUserByEmailAndPassword(String Email, String Password) {
        String  sql = "select userId,userName,email,password,character,playerId,typeId,money" +
                    " from [User] where email=? and password=?";
        return DBUtils.getSingleObj(User.class,sql,Email,Password);
    }

    public Integer selectUserEmailCount(String email) {
        String sql = "select count(*) from [User] where email = ?";
        Integer count = DBUtils.getCount(sql,email);
        return count;
    }

    public List<Player> getInformationByUserId(Integer userId){
        String sql = "select information from [User],Collect,Player " +
                "where [User].userId=? and [User].userId=Collect.userId and Collect.playerId=Player.playerId";
        return DBUtils.getList(Player.class,sql,userId);
    }

    public List<Player> getPlayerIdByUserId(Integer userId){
        String sql = "select Player.playerId playerId from [User],Collect,Player " +
                "where [User].userId=? and [User].userId=Collect.userId and Collect.playerId=Player.playerId";
        return DBUtils.getList(Player.class,sql,userId);
    }

    public List<User> getUser(){
        String sql = "select userId,userName,email,character,money from [User]";
        return DBUtils.getList(User.class,sql);
    }

    public boolean updateGLZ(Integer userId,Integer playerId){
        String sql = "update [User] set character=2,playerId=?,typeId=null where userId=?";
        return DBUtils.updata(sql,playerId,userId);
    }

    public boolean updateGLY(Integer userId,Integer typeId){
        String sql = "update [User] set character=3,typeId=?,playerId=null where userId=?";
        return DBUtils.updata(sql,typeId,userId);
    }

    public boolean deleteUser(Integer userId){
        String sql = "delete from [User] where userId=?";
        return DBUtils.updata(sql,userId);
    }
}

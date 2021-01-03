package jsu.dao;

import jsu.bean.Player;
import jsu.bean.Topic;
import jsu.bean.User;
import jsu.utils.DBUtils;

import java.util.List;

public class PlayerDao {
    public List<Player> getPlayerInformation(){
        String sql = "select information from Player";
        return DBUtils.getList(Player.class,sql,null);
    }

    public List<Player> getPlayerInformationByTypeId(Integer Id){
        String sql = "select playerId,information,typeId from Player where typeId=?";
        return DBUtils.getList(Player.class,sql,Id);
    }



    public List<Player> getPlayerInformationByPlayerId(Integer playerId){
        String sql = "select information from Player where playerId=?";
        return DBUtils.getList(Player.class,sql,playerId);
    }

    public Player gettypeIdByPlayerId(Integer playerId){
        String sql = "select typeId from Player where playerId=?";
        return DBUtils.getSingleObj(Player.class,sql,playerId);
    }

    public Topic getPlayerByPlayerInformation(String information) {
        StringBuffer  sql = new StringBuffer("select Topic.topicId,session,userId,Topic.playerId,ifTop,ifReported" +
                " from Topic,Player where information like '%");
        sql.append(information).append("%' and Player.playerId=Topic.playerId");
        return DBUtils.getSingleObj(Topic.class,sql.toString());
    }

    public List<Player> getPlayer(){
        String sql = "select playerId,information,typeId from Player";
        return DBUtils.getList(Player.class,sql);
    }

    public List<Player> getPlayers(){
        String sql = "select information,typeId from Player";
        return DBUtils.getList(Player.class,sql);
    }

    public boolean updateTypeId(Integer typeId,Integer playerId){
        String sql = "update Player set typeId=? where playerId=?";
        return DBUtils.updata(sql,typeId,playerId);
    }

    public boolean savePlayer(String information,Integer typeId) {
        String sql = "INSERT INTO Player( information , typeId ) " +
                "VALUES (?,?)";
        return DBUtils.save(sql, information, typeId);
    }
}

package jsu.dao;

import jsu.bean.Player;
import jsu.bean.Topic;
import jsu.bean.User;
import jsu.utils.DBUtils;

import java.util.List;

public class TopicDao {
    public List<Topic> getTopicByPlayerInformation(String information) {
        StringBuffer  sql = new StringBuffer("select Topic.topicId,session,userId,Topic.playerId,ifTop,ifReported" +
                " from Topic,Player where information like '%");
        sql.append(information).append("%' and Player.playerId=Topic.playerId");
        List<Topic> list = DBUtils.getList(Topic.class,sql.toString());
        return list;
    }
    public List<Topic> getTopicByPlayerId(Integer Id) {
        String sql = "select topicId,session,userId,playerId,ifTop,ifReported" +
                " from Topic where playerId=?";
        List<Topic> list = DBUtils.getList(Topic.class,sql,Id);
        return list;
    }

    public Topic getSessionByTopicId(Integer Id) {
        String sql = "select session " +
                "from Topic where topicId=?";
        return DBUtils.getSingleObj(Topic.class,sql,Id);
    }

    public List<Topic> getTopic(){
        String sql = "select topicId,session,userId,playerId,ifTop,ifReported from Topic";
        return DBUtils.getList(Topic.class,sql);
    }

    public boolean saveTopic(String session,Integer userId,Integer playerId) {
        String sql = "INSERT INTO Topic(session,userId,playerId,ifTop,ifReported)" +
                "VALUES (?,?,?,?,?)";
        return DBUtils.save(sql, session, userId, playerId, false, false);
    }

    public boolean deleteTopic(Integer topicId){
        String sql = "delete from Topic where topicId=?";
        return DBUtils.updata(sql,topicId);
    }

    public boolean updateReport(Integer topicId){
        String sql = "update Topic set ifReported='true' where topicId=?";
        return DBUtils.updata(sql,topicId);
    }
    public Topic getTopicBySession(String information) {
        StringBuffer  sql = new StringBuffer("select topicId,session,userId,playerId,ifTop,ifReported" +
                " from Topic where session like '%");
        sql.append(information).append("%'");
        return DBUtils.getSingleObj(Topic.class,sql.toString());
    }

    public List<Topic> getReport() {
        String sql = "select topicId,session,userId,playerId,ifTop,ifReported from Topic where ifReported='True'";
        return DBUtils.getList(Topic.class, sql);
    }

    public boolean cancelReport(Integer topicId){
        String sql = "update Topic set ifReported='false' where topicId=?";
        return DBUtils.updata(sql,topicId);
    }
}

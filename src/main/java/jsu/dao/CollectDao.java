package jsu.dao;

import jsu.utils.DBUtils;

public class CollectDao {
    public boolean saveCollect(Integer userId,Integer playerId) {
        String sql = "INSERT INTO Collect(userId,playerId)" +
                "VALUES (?,?)";
        return DBUtils.save(sql,userId, playerId);
    }

    public boolean deleteCollect(Integer userId,Integer playerId){
        String sql = "delete from Collect where userId=? and playerId=?";
        return DBUtils.updata(sql,userId,playerId);
    }
}

package jsu.dao;

import jsu.bean.Commentary;
import jsu.bean.Topic;
import jsu.utils.DBUtils;

import java.util.List;

public class CommentaryDao {
    public List<Commentary> getCommentaryBytopicId(Integer Id) {
        String sql = "select commentaryId,content,userId,topicId from Commentary where topicId=?";
        List<Commentary> list = DBUtils.getList(Commentary.class,sql.toString(),Id);
        return list;
    }

    public boolean saveCommentary(String content,Integer userId,Integer topicId) {
        String sql = "INSERT INTO Commentary(content,userId,topicId) " +
                "VALUES (?,?,?)";
        return DBUtils.save(sql, content, userId, topicId);
    }
}

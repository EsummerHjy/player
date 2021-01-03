package jsu.bean;

public class Commentary {
    private Integer commentaryId;
    private String content;
    private Integer userId;
    private Integer topicId;

    public Commentary() {
    }

    public Commentary(Integer commentaryId, String content, Integer userId, Integer topicId) {
        this.commentaryId = commentaryId;
        this.content = content;
        this.userId = userId;
        this.topicId = topicId;
    }

    public Integer getCommentaryId() {
        return commentaryId;
    }

    public void setCommentaryId(Integer commentaryId) {
        this.commentaryId = commentaryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return "Commentary{" +
                "commentaryId=" + commentaryId +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", topicId=" + topicId +
                '}';
    }
}

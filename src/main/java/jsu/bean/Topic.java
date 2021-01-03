package jsu.bean;

public class Topic {
    private Integer topicId;
    private String session;
    private Integer userId;
    private Integer playerId;
    private Boolean ifTop;
    private Boolean ifReported;

    public Topic(Integer topicId, String session, Integer userId, Integer playerId, Boolean ifTop, Boolean ifReported) {
        this.topicId = topicId;
        this.session = session;
        this.userId = userId;
        this.playerId = playerId;
        this.ifTop = ifTop;
        this.ifReported = ifReported;
    }

    public Topic() {
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Boolean isIfTop() {
        return ifTop;
    }

    public void setIfTop(Boolean ifTop) {
        this.ifTop = ifTop;
    }

    public Boolean isIfReported() {
        return ifReported;
    }

    public void setIfReported(Boolean ifReported) {
        this.ifReported = ifReported;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", session='" + session + '\'' +
                ", userId=" + userId +
                ", playerId=" + playerId +
                ", ifTop=" + ifTop +
                ", ifReported=" + ifReported +
                '}';
    }
}

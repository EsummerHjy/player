package jsu.bean;

public class Player {
    private Integer playerId;
    private String information;
    private Integer typeId;

    public Player() {
    }

    public Player(Integer playerId, String information, Integer typeId) {
        this.playerId = playerId;
        this.information = information;
        this.typeId = typeId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", information='" + information + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}

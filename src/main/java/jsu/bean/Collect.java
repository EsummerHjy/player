package jsu.bean;

public class Collect {
    private Integer collectedId;
    private Integer playerId;

    public Collect() {
    }

    public Collect(Integer collectedId, Integer playerId) {
        this.collectedId = collectedId;
        this.playerId = playerId;
    }

    public Integer getCollectedId() {
        return collectedId;
    }

    public void setCollectedId(Integer collectedId) {
        this.collectedId = collectedId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }
}

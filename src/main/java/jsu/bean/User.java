package jsu.bean;

public class User {
    private Integer userId;
    private String userName;
    private String email;
    private String password;
    private Integer character;//1.普通会员，2.管理者，3.管理员
    private Integer playerId;//管理者才有
    private Integer typeId;//管理员才有
    private Integer money;

    public User() {
    }

    public User(String userName, String email, String password, Integer character, Integer money) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.character = character;
        this.money = money;
        this.playerId = 0;
        this.typeId = 0;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCharacter() {
        return character;
    }

    public void setCharacter(Integer character) {
        this.character = character;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", character=" + character +
                ", playerId=" + playerId +
                ", typeId=" + typeId +
                ", money=" + money +
                '}';
    }
}

package jsu.bean;

public class SuperManager {
    private Integer superId;
    private String superName;
    private String email;
    private String password;

    public SuperManager() {
    }

    public SuperManager(Integer superId, String superName, String email, String password) {
        this.superId = superId;
        this.superName = superName;
        this.email = email;
        this.password = password;
    }

    public Integer getSuperId() {
        return superId;
    }

    public void setSuperId(Integer superId) {
        this.superId = superId;
    }

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
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
}

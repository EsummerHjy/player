package jsu.dao;

import jsu.bean.SuperManager;
import jsu.bean.User;
import jsu.utils.DBUtils;

public class SuperManagerDao {
    public SuperManager getSuperManagerByEmailAndPassword(String Email, String Password) {
        String sql = "select superName,email,password" +
                    " from SuperManager where email=? and password=?";
        return DBUtils.getSingleObj(SuperManager.class,sql,Email,Password);
    }
}

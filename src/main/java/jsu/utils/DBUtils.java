package jsu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class DBUtils {
    //数据库连接
    public static Connection getConnection() throws Exception {
        //读取文件
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(in);

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        return dataSource.getConnection();
    }
    //获取数据
    public static<T> List<T> getList(Class<T> clazz, String sql, Object...args ) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> userlist = null;
        try{
            //读取配置文件
            con = getConnection();

            ps = con.prepareStatement(sql);
            if(args!=null&&args.length>0){
                for(int i=0;i<args.length;i++){
                    ps.setObject(1+i,args[i]);
                    //比一个数字表示第一个问号，第二个数字表示值为1；
                }
            }


            rs=ps.executeQuery();
            //获取结果集的原数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取当前结果集的列数
            int colnum = rsmd.getColumnCount();

            userlist = new ArrayList<>();

            while(rs.next()){

                //key存放列名，value存放列值，for循环完成之后，rowmap存放一条记录
                Map<String,Object> rowMap = new HashMap<String,Object>();
                for(int i = 1; i <= colnum ; i++){
                    String columName = rsmd.getColumnLabel(i);
                    Object columValue = rs.getObject(columName);
                    //判断查询出来的列的类型，如果是java.sql.Date转化成java.util.Date
                    if(columValue instanceof java.sql.Date){
                        java.sql.Date date = (java.sql.Date)columValue;
                        columValue = new Date(date.getTime());
                    }
                    rowMap.put(columName,columValue);
                }
                T bean = clazz.newInstance();
                for(Map.Entry<String,Object> entry : rowMap.entrySet()){
                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();
                    //获取给propertName属性赋值的set方法//setId
                    String methodName = "set"+propertyName.substring(0,1).toUpperCase()+propertyName.substring(1);
                    //对象获取自己对应的字节码文件
                    Method method = clazz.getMethod(methodName, propertyValue.getClass());
                    method.invoke(bean,propertyValue);
                }

                userlist.add(bean);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            close(con, ps, rs);
        }

        return userlist;
    }
    //关闭连接
    public static void close(Connection con, Statement ps, ResultSet rs) {
        if(rs !=null){
            try{
                rs.close();
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        if(ps !=null){
            try{
                ps.close();
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        if(con !=null){
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }
    //保存对象
    public static boolean save(String sql, Object...args ) {
        Connection con = null;
        PreparedStatement ps = null;
        Integer cont =null;
        try{
            //读取配置文件
            con = getConnection();

            ps = con.prepareStatement(sql);
            if(args!=null&&args.length>0){
                for(int i=0;i<args.length;i++){
                    ps.setObject(1+i,args[i]);
                    //第一个数字表示第一个问号，第二个数字表示值为1；
                }
            }


            cont=ps.executeUpdate();
        }catch (Exception e){

            e.printStackTrace();
        }finally{
            close(con, ps, null);
        }

        return cont!=null&&cont>0?true:false;
    }
    //获取数据
    public static<T> T getSingleObj(Class<T> clazz, String sql, Object...args ) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        T bean = null;
        try{
            //读取配置文件
            con = getConnection();
            ps = con.prepareStatement(sql);
            if(args!=null&&args.length>0){
                for(int i=0;i<args.length;i++){
                    ps.setObject(1+i,args[i]);
                    //比一个数字表示第一个问号，第二个数字表示值为1；
                }
            }
            rs=ps.executeQuery();
            //获取结果集的原数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取当前结果集的列数
            int colnum = rsmd.getColumnCount();


            while(rs.next()){

                //key存放列名，value存放列值，for循环完成之后，rowmap存放一条记录
                Map<String,Object> rowMap = new HashMap<String,Object>();
                for(int i = 1; i <= colnum ; i++){
                    String columName = rsmd.getColumnLabel(i);
                    Object columValue = rs.getObject(columName);
                    //判断查询出来的列的类型，如果是java.sql.Date转化成java.util.Date
                    if(columValue instanceof java.sql.Date){
                        java.sql.Date date = (java.sql.Date)columValue;
                        columValue = new Date(date.getTime());
                    }
                    rowMap.put(columName,columValue);

                }
                bean = clazz.newInstance();

                for(Map.Entry<String,Object> entry : rowMap.entrySet()){
                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();
                    //获取给propertName属性赋值的set方法

                    String methodName = "set"+propertyName.substring(0,1).toUpperCase()+propertyName.substring(1);
                    //对象获取自己对应的字节码文件
                    if(propertyValue != null){
                        Method method = clazz.getMethod(methodName, propertyValue.getClass());
                        method.invoke(bean,propertyValue);
                    }
                }
            }
        }catch (Exception e){

            e.printStackTrace();
        }finally{
            close(con, ps, rs);
        }

        return bean;
    }

    //查询记录数量
    public static Integer getCount(String sql, Object...args) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer count = null;
        //ResultSetMetaData rsmd=null;
        try{
            //读取配置文件
            con = getConnection();

            ps = con.prepareStatement(sql);


            if(args!=null&&args.length>0){
                for(int i=0;i<args.length;i++){
                    ps.setObject(1+i,args[i]);
                    //比一个数字表示第一个问号，第二个数字表示值为1；
                }
            }


            rs=ps.executeQuery();

            while(rs.next()){
                count = rs.getInt(1);

            }
        }catch (Exception e){

            e.printStackTrace();
        }finally{
            close(con, ps, rs);
        }

        return count;
    }

    //更新操作
    public static boolean updata(String sql, Object...args ) {
        Connection con = null;
        PreparedStatement ps = null;
        Integer count = 0;
        try {
            //读取配置文件
            con = getConnection();
            ps = con.prepareStatement(sql);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    //判断当前类型是不是java.util.Date,转换成java.sql.Date
                    if(args[i] instanceof java.util.Date){
                        java.util.Date date = (java.util.Date)args[i];
                        //转换成java.sql.Date
                        args[i] = new java.sql.Date(date.getTime());
                    }
                    ps.setObject(1 + i, args[i]);
                }
            }
            count = ps.executeUpdate();
        }catch (Exception e){

            e.printStackTrace();
        }finally{
            close(con, ps,null);
        }

        return count>0?true:false;
    }

    //更新操作同时得到主键
    public static Integer updataForPrimaty(String sql, Object...args ) {
        Connection con = null;
        PreparedStatement ps = null;
        Integer primaryKey = null;
        ResultSet rs = null;
        try {
            //读取配置文件
            con = getConnection();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    //判断当前类型是不是java.util.Date,转换成java.sql.Date
                    if(args[i] instanceof java.util.Date){
                        java.util.Date date = (java.util.Date)args[i];
                        //转换成java.sql.Date
                        args[i] = new java.sql.Date(date.getTime());
                    }
                    ps.setObject(1 + i, args[i]);
                }
            }
            ps.executeUpdate();

            //生成主键
            rs = ps.getGeneratedKeys();

            if (rs.next()){
                primaryKey = (Integer) rs.getInt(1);
            }
        }catch (Exception e){

            e.printStackTrace();
        }finally{
            close(con, ps, rs);
        }

        return primaryKey;
    }
}

package top.one.jiemo.util;

import java.sql.*;
import java.util.List;

public class Jdbc {

    private static final String URL = "jdbc:mysql://localhost:3306/bilibili";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection conn = null;

    static {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库的连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }
    //保存数据到数据库
    public void saveDbData_V(List<String> title_list, List<String> img_list, List<String> url_list,String database, String type){
        Connection conn = Jdbc.getConnection();
        String sql = "INSERT INTO "+database+" (title,url,img,type) VALUES (?,?,?,?)";
        for (int i = 0; i <title_list.size() ; i++) {
            try {
                PreparedStatement ptmt = conn.prepareStatement(sql);
                ptmt.setString(1,title_list.get(i));
                ptmt.setString(3,img_list.get(i));
                ptmt.setString(2,"https://www.acfun.cn"+url_list.get(i));
                ptmt.setString(4,type);
                ptmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void saveDbData_click(List<String> title_list,List<String> click_list,String database){
        Connection conn = Jdbc.getConnection();
        String sql = "update  "+database+" set click=? where title=?";
        for (int i = 0; i <title_list.size() ; i++) {
            try {
                PreparedStatement ptmt = conn.prepareStatement(sql);
                ptmt.setString(1,click_list.get(i));
                ptmt.setString(2,title_list.get(i));
                ptmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void saveDbData_R(List<String> title_list,List<String> url_list,String database,String type){
        Connection conn = Jdbc.getConnection();
        String sql = "INSERT INTO "+database+" (title,url,type) VALUES (?,?,?)";
        for (int i = 0; i <title_list.size() ; i++) {
            try {
                PreparedStatement ptmt = conn.prepareStatement(sql);
                ptmt.setString(1,title_list.get(i));
                ptmt.setString(2,"https://www.acfun.cn"+url_list.get(i));
                ptmt.setString(3,type);
                ptmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
package com.iu2java.tmall.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTmall {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
            Connection conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/tmall_springboot?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8","root","root");
            Statement stmt = conn.createStatement();
            )
        {
            for (int i = 1; i <= 10; i++) {
                String sqlFormat = "insert into category values (null,'test%d')";
                String sql = String.format(sqlFormat,i);
                stmt.execute(sql);
            }
            System.out.println("成功创建10条分类测试数据");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

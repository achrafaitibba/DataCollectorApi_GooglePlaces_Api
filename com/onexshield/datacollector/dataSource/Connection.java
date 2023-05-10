//package com.onexshield.datacollector.dataSource;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//@Component
//public class Connection {
//    @Value("${database.url}")
//    private String url;
//
//
//    @Value("${dataBase.user}")
//    private String user;
//
//
//    @Value("${dataBase.password}")
//    private String password;
//
//
//    public java.sql.Connection getConnected() throws SQLException,ClassNotFoundException, IOException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        return DriverManager.getConnection(url,user,password);
//    }
//
//
//}

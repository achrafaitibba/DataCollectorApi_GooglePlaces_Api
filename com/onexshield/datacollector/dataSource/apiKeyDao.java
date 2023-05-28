package com.onexshield.datacollector.dataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class apiKeyDao {

    private Connection connection;

    @Autowired
    public apiKeyDao(Connection connection){
        this.connection = connection;
    }


    public String getApiKey() throws Exception{
//        String sql = "select keyString from keysValues where id = ?";
//        PreparedStatement statement = connection.getConnected().prepareStatement(sql);
//        statement.setInt(1,1);
//        ResultSet resultSet = statement.executeQuery();
//        String key = "";
//        while(resultSet.next()){
//            key = resultSet.getString(1);
//        }
        return  "AIzaSyD9udnfPUdObJh1qj3QuZkwtyY5riSP95w";
    }
}

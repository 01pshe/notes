package com.vol.notes.dao.sql.postgre;

import com.vol.notes.dao.BaseDAO;
import com.vol.notes.entities.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostgreBaseDAO implements BaseDAO {

    private BasicDataSource dataSource;

    @Autowired
    public PostgreBaseDAO(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users");
            try(ResultSet resultSet = pstmt.executeQuery()){
                while (resultSet.next()){

                    User user = new User();
                    user.setId(resultSet.getLong("id"));
                    user.setName(resultSet.getString("name"));
                    user.setPassword("password");
                    user.setDateCreate(resultSet.getDate("datecreate"));
                    user.setLocked(resultSet.getBoolean("locked"));
                    user.setDateLock(resultSet.getDate("datelock"));
                    System.out.println(user.getId()+", "+user.getName());
                    users.add(user);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}

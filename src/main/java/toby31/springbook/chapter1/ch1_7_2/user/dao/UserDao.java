package toby31.springbook.chapter1.ch1_7_2.user.dao;

import toby31.springbook.chapter1.ch1_7_2.user.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private static UserDao INSTANCE;

    private ConnectionMaker cm;

    private UserDao(ConnectionMaker cm) {
        this.cm = cm;
    }

    public static synchronized UserDao getInstance(ConnectionMaker cm) {
        if (INSTANCE == null) INSTANCE = new UserDao(cm);
        return INSTANCE;
    }


    public void add(User user) throws ClassNotFoundException, SQLException {

        Connection c = cm.makeConnection();

        PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values (?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = cm.makeConnection();

        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
}
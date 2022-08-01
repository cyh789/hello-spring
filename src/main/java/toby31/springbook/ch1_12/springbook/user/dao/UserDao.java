package toby31.springbook.ch1_12.springbook.user.dao;

import toby31.springbook.ch1_12.springbook.user.domain.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

//    private ConnectionMaker cm;
    private DataSource ds;
    private Connection c;
    private User user;

    public void setDataSource(DataSource dataSource) {
        this.ds = dataSource;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        this.c = ds.getConnection();

        PreparedStatement ps = this.c.prepareStatement("insert into users(id, name, password) values (?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        this.c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        this.c = ds.getConnection();

        PreparedStatement ps = this.c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        this.user = new User();
        this.user.setId(rs.getString("id"));
        this.user.setName(rs.getString("name"));
        this.user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        this.c.close();

        return this.user;
    }
}
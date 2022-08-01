package toby31.springbook.ch1_6.springbook.user;

import toby31.springbook.ch1_6.springbook.user.dao.DaoFactory;
import toby31.springbook.ch1_6.springbook.user.dao.UserDao;
import toby31.springbook.ch1_6.springbook.user.domain.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao dao = DaoFactory.userDao();

        User user = new User();
        user.setId("test66");
        user.setName("테스트");
        user.setPassword("1234");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공");
    }
}

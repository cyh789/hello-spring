package toby31.springbook.ch1_8.springbook.user;

import toby31.springbook.ch1_8.springbook.user.dao.UserDao;
import toby31.springbook.ch1_8.springbook.user.domain.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        ApplicationContext ac = new AnnotationConfigApplicationContext(DaoFactory.class);
//        UserDao dao = ac.getBean("userDao", UserDao.class);
        UserDao dao = new UserDao();

        User user = new User();
        user.setId("test88");
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

package toby31.ch1_10_2.springbook.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import toby31.ch1_10_2.springbook.user.dao.CountingDaoFactory;
import toby31.ch1_10_2.springbook.user.dao.UserDao;
import toby31.ch1_10_2.springbook.user.domain.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao dao = ac.getBean("userDao", UserDao.class);
//        UserDao dao = new UserDao();

        User user = new User();
        user.setId("test102");
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

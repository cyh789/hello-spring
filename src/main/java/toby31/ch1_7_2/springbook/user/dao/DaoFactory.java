package toby31.ch1_7_2.springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory<E> {

    @Bean
    public static UserDao userDao() {
        return UserDao.getInstance(connectionMaker());
    }

    private static ConnectionMaker connectionMaker() {
        return new NConnectionMaker();
    }

    @Bean
    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    @Bean
    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }
}

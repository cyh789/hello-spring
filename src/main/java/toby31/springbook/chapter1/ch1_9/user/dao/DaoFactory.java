package toby31.springbook.chapter1.ch1_9.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory<E> {

    @Bean
    public static ConnectionMaker connectionMaker() {
        return new NConnectionMaker();
    }
}

package toby31.ch1_9.springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory<E> {

    @Bean
    public static ConnectionMaker connectionMaker() {
        return new NConnectionMaker();
    }
}

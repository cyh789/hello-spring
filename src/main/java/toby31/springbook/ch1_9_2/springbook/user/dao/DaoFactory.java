package toby31.springbook.ch1_9_2.springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory<E> {

    @Bean
    public static ConnectionMaker connectionMaker() {
        //return new NConnectionMaker();    //local
        return new ProductionDBConnectionMaker();
    }
}

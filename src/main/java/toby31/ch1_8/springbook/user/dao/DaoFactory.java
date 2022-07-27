package toby31.ch1_8.springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class DaoFactory<E> {

    public static ConnectionMaker connectionMaker() {
        return new NConnectionMaker();
    }
}

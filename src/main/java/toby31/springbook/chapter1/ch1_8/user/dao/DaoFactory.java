package toby31.springbook.chapter1.ch1_8.user.dao;

public class DaoFactory<E> {

    public static ConnectionMaker connectionMaker() {
        return new NConnectionMaker();
    }
}

package toby31.springbook.ch1_8.springbook.user.dao;

public class DaoFactory<E> {

    public static ConnectionMaker connectionMaker() {
        return new NConnectionMaker();
    }
}

package toby31.ch1_6.springbook.user.dao;

public class DaoFactory<E> {

    public static UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    private static ConnectionMaker connectionMaker() {
        return new NConnectionMaker();
    }

    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }
}

package toby31.springbook.chapter1.ch1_11_2.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class CountingConnectionMaker implements ConnectionMaker {

    int counter = 0;
    private ConnectionMaker cm;

    public void setCountingConnectionMaker(ConnectionMaker realConnectionMaker) {
        this.cm = realConnectionMaker;
    }

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        this.counter++;
        return cm.makeConnection();
    }

    public int getCounter() {
        return this.counter;
    }
}

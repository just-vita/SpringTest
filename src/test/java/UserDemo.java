import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.test.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyVetoException;
import java.sql.Connection;

public class UserDemo {
    @Test
    public void test1() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///travel?serverTimezone=UTC&Unicode=true&characterEncoding=UTF-8");
        dataSource.setUser("root");
        dataSource.setPassword("zxc758203");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}

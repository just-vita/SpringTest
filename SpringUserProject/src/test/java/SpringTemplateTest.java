import com.dao.impl.RoleDaoImpl;
import com.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class SpringTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test1(){
        List<Role> query = jdbcTemplate.query("select * from sys_role",new BeanPropertyRowMapper<>(Role.class));
        for (Role role : query) {
            System.out.println(role.getRoleName());
        }
    }

}

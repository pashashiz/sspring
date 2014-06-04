import com.pm.smvc.modelHibernate.persistence.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static junit.framework.Assert.*;

/**
 * User test
 */
public class UserTest {

    User user;

    @Before
    public void setUp() {
        user = new User();
        user.setId(1);
        user.setName("Pasha");
        user.setRole("ADMIN_ROLE");
        user.setPassword("*");
    }

    @After
    public void tearDown() {
        user = null;
    }

    @Category(Unit.class)
    @Test
    public void testRole() {
        assertEquals("ADMIN_ROLE", user.getRole());
    }

}

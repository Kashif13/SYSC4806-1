import com.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class UserTest {

    User user1;
    String testEmail = "test@test.com";
    String testName = "Donald";

    @Before
    public void setUp() throws Exception {
        user1 = new User();
    }
    @Test
    public void testSetEmail() throws Exception {
        user1.setEmail("test@test.com");
        assertEquals(user1.getEmail(), testEmail);
    }
    @Test
    public void testSetName() throws Exception {
        user1.setName("Donald");
        assertEquals(user1.getName(), testName);

    }



}

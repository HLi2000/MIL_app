import Entities.User;
import UI.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLogin {
    @Test
        public void testLoop() {
            //set up a user
        Login l = new Login();
        l.username =
            User user = new User();
            user.setUsername("ABC");
            user.setPassword("123");
            user.hashcode();

            Assertions.assertEquals("ABC", user.getUsername());
            Assertions.assertEquals("123", user.getPassword());
            Assertions.assertEquals(65826, user.getH_username());
            Assertions.assertEquals(49938, user.getH_password());
        }
    }
}

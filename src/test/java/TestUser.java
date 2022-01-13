import org.junit.Assert;
import org.junit.Test;

import Entities.*;

/**
 * Test the User object class
 */

public class TestUser {
    @Test
    public void TestAUser() {
        //set up a user
        User user = new User();
        user.setUsername("ABC");
        user.setPassword("123");
        user.hashcode();

        Assert.assertEquals("ABC", user.getUsername());
        Assert.assertEquals("123", user.getPassword());
        Assert.assertEquals(65826, user.getH_username());
        Assert.assertEquals(49938, user.getH_password());
    }
}

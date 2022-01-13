import Entities.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test the Client with different input cases
 *
 * downloading functions are not fully tested because they require image files
 */

public class TestClient {
    @Test
    public void testDelete() throws Exception {
        //set up a user
        User user = new User();
        user.setUsername("ABC");
        user.setPassword("123");
        user.hashcode();

        //test
        Client client=new Client();
        String res=client.delete(user);

        //output should be
        String res_should_be="Deleted Successfully";

        Assert.assertEquals(res_should_be,res);
    }
    @Test
    public void testRegister1() throws Exception {
        //set up a user
        User user = new User();
        user.setUsername("ABC");
        user.setPassword("123");
        user.hashcode();

        //test
        Client client=new Client();
        client.delete(user);
        String res=client.register(user);

        //output should be
        String res_should_be="Registered Successfully";

        Assert.assertEquals(res_should_be,res);
    }
    @Test
    public void testRegister2() throws Exception {
        //set up a user
        User user = new User();
        user.setUsername("ABC");
        user.setPassword("123");
        user.hashcode();

        //test
        Client client=new Client();
        client.register(user);
        String res=client.register(user);

        //output should be
        String res_should_be="Username Already Exists";

        Assert.assertEquals(res_should_be,res);
    }
    @Test
    public void testLogin1() throws Exception {
        //set up a user
        User user = new User();
        user.setUsername("ABC");
        user.setPassword("123");
        user.hashcode();

        //test
        Client client=new Client();
        client.register(user);
        String res=client.login(user);

        //output should be
        String res_should_be="Login Successful";

        Assert.assertEquals(res_should_be,res);
    }
    @Test
    public void testLogin2() throws Exception {
        //set up a user
        User user1 = new User();
        user1.setUsername("ABC");
        user1.setPassword("12");
        user1.hashcode();

        User user2 = new User();
        user2.setUsername("ABC");
        user2.setPassword("123");
        user2.hashcode();

        //test
        Client client=new Client();
        client.register(user2);
        String res=client.login(user1);

        //output should be
        String res_should_be="Wrong Password";

        Assert.assertEquals(res_should_be,res);
    }
    @Test
    public void testLogin3() throws Exception {
        //set up a user
        User user = new User();
        user.setUsername("TestOnly");
        user.setPassword("123");
        user.hashcode();

        //test
        Client client=new Client();
        String res=client.login(user);

        //output should be
        String res_should_be="Unknown Username";

        Assert.assertEquals(res_should_be,res);
    }

    @Test
    public void testSearch1() throws Exception {
        String[] modality_a={"CT","MRI"};
        String[] region_a={};
        String patient_name="Peter";
        SearchInfo searchInfo=new SearchInfo(modality_a,region_a,patient_name);

        Client cl=new Client();
        Img[] img_a=cl.search(searchInfo);

        List<String> file_name_l=new ArrayList<>();
        for (Img img : img_a) {
            file_name_l.add(img.getFile_name());
        }
        String[] file_name_a=file_name_l.toArray(new String[0]);
        String[] file_name_a_should_be={"ct arm 2.png","ct head 2.jfif",
                "ct heart 2.png","ct leg 2.jpg","mri arm 2.jpg","mri head 2.jfif",
                "mri heart 2.gif","mri leg 2.jfif","ct body 2.dcm","ct head 2.dcm"};
        Assert.assertArrayEquals(file_name_a,file_name_a_should_be);
    }

    @Test
    public void testSearch2() throws Exception {
        String[] modality_a={};
        String[] region_a={"Arm"};
        String patient_name="Peter";
        SearchInfo searchInfo=new SearchInfo(modality_a,region_a,patient_name);

        Client cl=new Client();
        Img[] img_a=cl.search(searchInfo);

        List<String> file_name_l=new ArrayList<>();
        for (Img img : img_a) {
            file_name_l.add(img.getFile_name());
        }
        String[] file_name_a=file_name_l.toArray(new String[0]);
        String[] file_name_a_should_be={"ct arm 2.png","mri arm 2.jpg",
                "us arm 2.jpg","xray arm 2.jpg"};
        Assert.assertArrayEquals(file_name_a,file_name_a_should_be);
    }

    @Test
    public void testSearch3() throws Exception {
        String[] modality_a={"CT"};
        String[] region_a={"Arm"};
        String patient_name="";
        SearchInfo searchInfo=new SearchInfo(modality_a,region_a,patient_name);

        Client cl=new Client();
        Img[] img_a=cl.search(searchInfo);

        List<String> file_name_l=new ArrayList<>();
        for (Img img : img_a) {
            file_name_l.add(img.getFile_name());
        }
        String[] file_name_a=file_name_l.toArray(new String[0]);
        String[] file_name_a_should_be={"ct arm 1.jpg","ct arm 2.png","ct arm 3.jfif"};
        Assert.assertArrayEquals(file_name_a,file_name_a_should_be);
    }
}

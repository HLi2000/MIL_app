public class Main {
    public static void main(String[] args) throws Exception{
        User u = new User();
        u.getUsername("peter");
        u.getPassword("123");
        u.hashcode();

        Client c = new Client();
        c.register(u);

    }
}

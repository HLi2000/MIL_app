package imgDB;

public class User {
    //unhashed
    public String rawUsername;
    public String rawPassword;
    //hashed
    public int username;
    public int password;


    public void getUsername(String username){
        this.rawUsername = username;
    }

    public void getPassword(String password){
        this.rawPassword = password;
    }

    public void hashcode(){
        username = rawUsername.hashCode() + 1248;
        password = rawPassword.hashCode() + 1248;
    }
}
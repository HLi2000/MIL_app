public class User {
    //unhashed
    private String rawUsername;
    private String rawPassword;
    //hashed
    private int h_username=0;
    private int h_password=0;


    public void setUsername(String username){
        this.rawUsername = username;
    }

    public void setPassword(String password){
        this.rawPassword = password;
    }

    public void hashcode(){
        h_username = rawUsername.hashCode() + 1248;
        h_password = rawPassword.hashCode() + 1248;
    }

    public void setH_password(int h_password) {
        this.h_password = h_password;
    }

    public void setH_username(int h_username) {
        this.h_username = h_username;
    }

    public int getH_username() {
        return h_username;
    }

    public int getH_password() {
        return h_password;
    }
}
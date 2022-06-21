package login;

public class Mlogin {
    private String username;

    public Mlogin(){

        username = "unbekannt";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username!=""){

            this.username = username;
        }
    }
}

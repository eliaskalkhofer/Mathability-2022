package user;

public class Player {

    private String name;
    private String eMail;
    private String password;

    Player(String name, String eMail,String password) {
        this.name = name;
        this.eMail = eMail;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPassword() {
        return password;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        if(password.length() < 8) {
            System.out.println("Error!");
        }
        else
        this.password = password;
    }
}

package login;

public class Mlogin {
    private String username;

    //Beim erstellen wird er Benutzername auf Unbekannt gestellt
    public Mlogin(){

        username = "unbekannt";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        //Nur wenn ein gültiger Username eingegeben wurde wird er auch gespeichert
        if (username!=""){

            this.username = username;
        }
    }
}

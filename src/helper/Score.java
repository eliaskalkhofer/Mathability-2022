package helper;

import java.io.Serializable;

public class Score implements Serializable, Comparable {

    private int amount;
    private Gamemode type;
    private String id;
    private String name;



    //Score in welchem SpielID Gamemode Scoreamount und Username gespeichert werden können
    public Score(int amount, String name, Gamemode type){

        setAmount(amount);
        setName(name);
        setType(type);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gamemode getType() {
        return type;
    }

    public void setType(Gamemode type) {
        this.type = type;
    }


    //Darstellung für die Highscorelisten
    @Override
    public String toString() {
        return getName()+": "+getAmount();
    }


    @Override
    public int compareTo(Object o) {
        return((Score)o).getAmount()- this.getAmount();
    }



}

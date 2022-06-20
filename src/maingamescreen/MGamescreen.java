package maingamescreen;

import helper.Gamemode;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.Timer;
import java.util.TimerTask;




public class MGamescreen {
    private Gamemode current;   //Welchen Gamemode man spielen möchte
    private String id;             //Welche Id dieses Spiel hat
    private int score;          //Welchen Score dieses Spiel erreicht hat

    private String[] gameInfos;
    private int rightans;
    private static int MAX =100;


    private static int ANSWERTIME = 10000; //in ms
    private static int PROGRESSBARUPDATE = 10; //in ms
    private  int timepassed=0;
    private DoubleProperty timeleft;


    //Zeitproaufgabe
    private Timer gametimer;    //Gametimer während des Spieles
    TimerTask task = new TimerTask()
    {
        @Override
        public void run(){


            timepassed+=PROGRESSBARUPDATE;
            timeleftProperty().set((timepassed+0.0) / ANSWERTIME);


            if(timepassed>ANSWERTIME){
                stopTimer();
            }
        }

    };

    public void resetTimer(){
        timepassed =0;
    }



    public final DoubleProperty timeleftProperty(){
        if(timeleft==null){
            timeleft = new SimpleDoubleProperty(1);
        }
        return timeleft;
    }

    public final double gettimeleft(){
        if(timepassed==0){
            return 0;
        }
        return timeleft.get();
    }


    public MGamescreen(Gamemode mode){
        setCurrent(mode);
        setScore(0);
        gametimer = new Timer();
        startTimer();
        setId("DefaultUser");
    }

    //Getter und Setter
    public Gamemode getCurrent() {
        return current;
    }

    public void setCurrent(Gamemode current) {
        this.current = current;
    }

    public String getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Timer getGametimer() {
        return gametimer;
    }

    public void setGametimer(Timer gametimer) {
        this.gametimer = gametimer;
    }

    public String[] getGameInfos() {
        return gameInfos;
    }

    public int getRightans() {
        return rightans;
    }



    public void startTimer(){
        gametimer.schedule(task, PROGRESSBARUPDATE,10);
    }
    public void stopTimer(){ gametimer.purge();}

    //erzeugen einer neuen Rechnung anhand des Spielmodus
    public void getnewRechung(){

        switch (current){
            case ADD :
                gameInfos=  getADD();
                break;

            case SUB:
                gameInfos= getSUB();
                break;

            case MUL:
                gameInfos= getMUL();
                break;

            case DIV:
                gameInfos =getDIV();
                break;

            case MIX:
                switch (ZufZaint(0,3)){//Zufälliger Spielmodus
                    case 0:
                        gameInfos = getADD();
                        break;
                    case 1:
                        gameInfos = getSUB();
                        break;
                    case 2:
                        gameInfos = getMUL();
                        break;
                    case 3:
                        gameInfos = getDIV();
                        break;
                }
                break;

            default:
                gameInfos=null;
                break;
        }
    }

   //Adition
    private String[] getADD(){

        String paket[] = new String[5]; //Paket welches später übermittelt wird
        int a,b; //Summanten

        //Erzeugung (Prototyp)
        rightans = (int)ZufZa(2, MAX);
        a = rightans- (int)ZufZa(1,(int)rightans/2);
        b = rightans- a;


        //Verpakung in einem Paket
        paket[0]=a+"+"+b;
        paket[ZufZaint(1,4)]=rightans+"";
        for(int i=1;i<5;i++){
            if(paket[i]==null){
                paket[i]=(rightans+ZufZaint(-10,10))+"";
            }
        }
        return paket;
    }//getADD


    //Subtraktion (siehe Add)
    private String[] getSUB(){
        String paket[] = new String[5];
        int a,b;

        //Erzeugung (Prototyp)
        a = (int)ZufZa(2, MAX);
        rightans = a- (int)ZufZa(1,(int)rightans/2);
        b = a - rightans ;


        paket[0]=a+"-"+b;
        paket[ZufZaint(1,4)]=rightans+"";
        for(int i=1;i<5;i++){
            if(paket[i]==null){
                paket[i]=(rightans+ZufZaint(-10,10))+"";
            }
        }
        return paket;
    }//getSUB


    private String[] getMUL(){
        String paket[] = new String[5]; //Paket welches später übermittelt wird
        int a,b;

        //Erzeugung (Prototyp)
        rightans=ZufZaint(2, MAX);
        a =  ZufZaint(1,(int)rightans/2);
        b = rightans /a;
        rightans = a*b;


        paket[0]=a+"*"+b;
        paket[ZufZaint(1,4)]=rightans+"";
        for(int i=1;i<5;i++){
            if(paket[i]==null){
                paket[i]=(rightans+ZufZaint(-10,10))+"";
            }
        }
        return paket;
    }//getMUL


    private String[] getDIV(){
        String paket[] = new String[5]; //Paket welches später übermittelt wird
        int a,b;

        //Erzeugung (Prototyp)
        rightans = ZufZaint(2, (int)MAX/10);
        b =  ZufZaint(1,(int)MAX/10);
        a = rightans*b;


        paket[0]=a+"/"+b;
        paket[ZufZaint(1,4)]=rightans+"";
        for(int i=1;i<5;i++){
            if(paket[i]==null){
                paket[i]=(rightans+ZufZaint(-10,10))+"";
            }
        }

        return paket;
    }//getDiv



    private double ZufZa(double min, double max){
        return Math.random()*(max-min)+min;
    }//Zufällige Zahl
    private int ZufZaint (double min, double max){
        return (int) Math.floor(ZufZa(min, max+1));
    }//Zufällige ganze Zahl

}



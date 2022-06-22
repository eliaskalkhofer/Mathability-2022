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

    private String[] gameInfos;     //Spielinfos für Controller
    private int rightans;           //richtige Antwort
    private static int MAX =100;    //Welche Reichweite haben die Rechungne zb


    //Für den Timer
    private static final double TIMEPERSCORE = 0.10; //bei jedem richtigen Score wird die aktuelle answertime um 10% reduziert.
    private static final int ANSWERTIME = 10000; //in ms
    private static final int PROGRESSBARUPDATE = 10; //in ms
    private  int timepassed=0;
    private DoubleProperty timeleft;
    private int actmaxtime = ANSWERTIME;


    //Gametimer während des Spieles
    private Timer gametimer;
    TimerTask task = new TimerTask()
    {
        @Override
        public void run(){


            timepassed+=PROGRESSBARUPDATE;
            timeleftProperty().set((timepassed+0.0) / actmaxtime);

        }

    };

    //Timer-Funktionen
    public void resetTimer(){
        timepassed =0;
    }
    public void startTimer(){
        gametimer.schedule(task, PROGRESSBARUPDATE,10);
    }
    public void stopTimer(){
        gametimer.cancel();
        gametimer.purge();
    }


    //Für Binding
    public final DoubleProperty timeleftProperty(){
        if(timeleft==null){
            timeleft = new SimpleDoubleProperty(1);
        }
        return timeleft;
    }


    public MGamescreen(Gamemode mode, String username){
        setCurrent(mode);//Spielmodus
        setScore(0);
        setId(username);
        gametimer = new Timer();
        //Timer starten
        startTimer();

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



    //erzeugen einer neuen Rechnung anhand des Spielmodus
    public void getnewRechung(){

        //Auswahl von welcher Funktion wird die Gameinfo erstellt
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

                //eventuell todo: redunanz einführen
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

   //Addition
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


    public void incScore(){
        actmaxtime = (int)(actmaxtime *(1.0-TIMEPERSCORE));//geschwindigkeit erhöhen
        score++;//score erhöhen
    }


    //Zufällige Zahlen erstellen siehe Klasse eins
    private double ZufZa(double min, double max){
        return Math.random()*(max-min)+min;
    }//Zufällige Zahl
    private int ZufZaint (double min, double max){
        return (int) Math.floor(ZufZa(min, max+1));
    }//Zufällige ganze Zahl

}



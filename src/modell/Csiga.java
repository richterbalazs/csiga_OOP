package modell;

public class Csiga {
    private static final char UT_SZIMPLA = '-';
    private static final char UT_DUPLA = '=';
    private static final String ABRA_CSIGA_EMOJI = "\ud83d\udc0c";
    private static final String ABRA_KUKAC_JEL = "@";

    public static char getUTJEL_1() {
        return UT_SZIMPLA;
    }

    public static char getUTJEL_2() {
        return UT_DUPLA;
    }

    public static String getABRA_1() {
        return ABRA_CSIGA_EMOJI;
    }

    public static String getABRA_2() {
        return ABRA_KUKAC_JEL;
    }
    
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    
    private String szin;
    private String szinKod;
    private String megtettUt;
    private boolean gyorsito;

    public Csiga(String szin) {
        this.szin = szin;
        setSzinKod();
        megtettUt = "";
        gyorsito = false;
    }

    public String getSzin() {
        return szin;
    }

    public String getSzinKod() {
        return szinKod;
    }

    public String getMegtettUt() {
        return megtettUt;
    }

    public boolean isGyorsito() {
        return gyorsito;
    }

    public void setGyorsito(boolean gyorsito) {
        this.gyorsito = gyorsito;
    }
    
    private void setSzinKod() {
        switch(szin){
            default: 
                szinKod = RED;
                break;
            case "piros":
                szinKod = RED;
                break;
            case "kék":
                szinKod = BLUE;
                break;
            case "zöld":
                szinKod = GREEN;
                break;
        }
    }
    
    public void megy(){
        int tav = (int)(Math.random()*4);
        tav = gyorsito ? tav*2 : tav;
        tav = gyorsito && tav == 0 ? 1 : tav;
        char jel = gyorsito ? Csiga.UT_DUPLA : Csiga.UT_SZIMPLA;
        for (int i = 0; i < tav; i++) {
            megtettUt += jel;
        }
    }
    
}

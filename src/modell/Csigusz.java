package modell;

public class Csigusz {
    /** ADATTAGOK */
    public enum Szinek{PIROS, ZOLD, KEK};
    
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    
    private String nev;
    //private String szinNev;
    private Szinek szinNev;
    private String szinKod;
    
    /** TAGFÜGGVÉNYEK */
    /* GENERÁLHATÓ szinte minden tagfüggvény az adattagokból */
    /* generálás: ALT + INSERT */

    /* nem logikus a név nélküli létrehozás: */
//    public Csigusz() throws Exception{
//        this("Csigusz Doe");
//        //this("Csigusz Doe", "fekete");
//    }
    
    public Csigusz(String nev) throws Exception {
        //this("vmlyen név", "vmilyen szín");
        //this(nev, "fekete");
        //this(nev, "piros");
        this(nev, Szinek.PIROS);
        
        /* kódduplikálás pl a nev ellenőrzése */
        //this.nev = nev;
        //this.szin = "fekete";
    }

    //public Csigusz(String nev, String szinNev) throws Exception {
    public Csigusz(String nev, Szinek szinNev) throws Exception {
        //this.nev = nev;
        setNev(nev);
        
        this.szinNev = szinNev;
        this.szinKod = RESET;
        setSzin();
        //this.szin = szin;
    }

    /* nem lehet a létrehozás után nevet változtatni */
    private void setNev(String nev) throws Exception {
        /* név ellenőrzése:
        ne jöjjön létre, ha a nev.length < 3
        az első betű legyen nagy --> csere, ha nem jó */
        if (nev.length() >= 3) {
            char nevElsoBetuje = nev.charAt(0);
            if (Character.isLowerCase(nevElsoBetuje)) {
                nevElsoBetuje = Character.toUpperCase(nevElsoBetuje);
                nev = nevElsoBetuje + nev.substring(1);
            }
            this.nev = nev;
        } else {
            throw new Exception("rövid a név!");
        }
    }

    /* nem lehet a létrehozás után nevet változtatni */
    private void setSzin() {
        //if(szinKod == "piros"){
//        if(szinKod.equals("piros")){
//            this.szinKod = Csigusz.RED;
//            this.szinNev = "piros";
//        }
        
        switch(szinNev){
            //case "piros":
            case PIROS:
                this.szinKod = Csigusz.RED;
                break;
            //case "kék":
            case KEK:
                this.szinKod = Csigusz.BLUE;
                break;
            //case "zöld":
            case ZOLD:
                this.szinKod = Csigusz.GREEN;
                break;
        }
        
    }
    
    
    public String getNev() {
        return nev;
    }

	/* ez inkább: getSzinKod() */
    public String getSzin() {
        return szinKod;
    }

	/* vagy lehetne: */
	public String getSzinNev() {
        return szinNev.toString();
    }

    @Override
    public String toString() {
        return szinKod + "Csigusz{" + "nev=" + nev + ", szinNev=" + szinNev + '}' + RESET;
    }
    
}

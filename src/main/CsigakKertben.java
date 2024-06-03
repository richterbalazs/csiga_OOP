package main;

import modell.Csiga;

/* MILYEN HIBÁK találhatóak a programban? */

public class CsigakKertben {
    private final Csiga[] csigak;
    private final char[][] kert = new char[6][8];

    public static void main(String[] args) {
        new CsigakKertben();
    }
    
    public CsigakKertben() {
        System.out.println("***** Csigá(k) a kertben *****");
        uresKert();
        csigak = new Csiga[3];
        csigak[0] = new Csiga("piros");
        csigak[1] = Math.random() > 0.3 ? new Csiga("kék") : null;
        kert[1][0] = '|';
        kert[1][1] = ' ';
        kert[1][2] = Csiga.getABRA_2().charAt(0);
        kert[1][3] = ' ';
        
        char cs2 = csigak[1] == null ? ' ' : Csiga.getABRA_2().charAt(0);
        kert[1][4] = ' ';
        kert[1][5] = cs2;
        kert[1][6] = ' ';
        kert[1][7] = '|';
        
        mutat();
        System.out.println("*** mozgatás után ***");
        mozgat();
        mutat();
    }

    private void mutat() {
        for (char sor[] : kert) {
            for (char c : sor) {
                System.out.print(c);
            }
            System.out.println("");
        }
    }

    private void uresKert() {
        kert[0][0] = '|';
        for (int i = 1; i <= 6; i++) {
            kert[0][i] = '-';
        }
        kert[0][7] = '|';
        
        for (int i = 1; i < kert.length; i++) {
            kert[i][0] = '|';
            for (int j = 1; j < 7; j++) {
                kert[i][j] = ' ';
            }
            kert[i][7] = '|';
        }
        
        kert[5][0] = '|';
        for (int i = 1; i <= 6; i++) {
            kert[5][i] = '-';
        }
        kert[5][7] = '|';
    }

    private void mozgat() {
        csigak[0].megy();
        int oszlop = 2;
        int hanyatLep = csigak[0].getMegtettUt().length();
        for (int i = 1; i < hanyatLep; i++) {
            kert[i][oszlop] = '.';
        }
        kert[hanyatLep][oszlop] = Csiga.getABRA_2().charAt(0);
        
        Csiga csiga = csigak[1];
        if(csiga != null){
            oszlop = 5;
            hanyatLep = csiga.getMegtettUt().length();
            for (int i = 1; i < hanyatLep; i++) {
                kert[i][oszlop] = '.';
            }
            kert[hanyatLep][oszlop] = Csiga.getABRA_2().charAt(0);
        }
    }
}

package main;

import java.util.Scanner;
import modell.Csiga;

public class CsigaVerseny {

    private static final Scanner sc = new Scanner(System.in);
    private static final String RESET = "\u001B[0m";
    
    private final Csiga[] csigak;
    private final String[] palya;
    private int fogadas;
    
    public static void main(String[] args) {
        new CsigaVerseny();
    }

    public CsigaVerseny() {
        csigak = new Csiga[3];
        palya = new String[csigak.length];
        csigak[0] = new Csiga("piros");
        csigak[1] = new Csiga("kék");
        csigak[2] = new Csiga("zöld");
        indit();
    }

    private void indit() {
        kezdoAllapot();
        fogadas();
        verseny();
        allastMutat();
        mutatKonzolon(eredmeny());
    }

    private void kezdoAllapot() {
        for (int i = 0; i < csigak.length; i++) {
            Csiga csiga = csigak[i];
            String kod = csiga.getSzinKod();
            String ki = "%s%d. %5s |%s\n".formatted(kod, i+1, csiga.getSzin(), Csiga.getABRA_1());
            mutatKonzolon(ki);
        }
    }

    private void fogadas() {
        mutatKonzolon("Melyik csigára fogadsz? Add meg a sorszámát (1-3): ");
        fogadas = sc.nextInt() - 1;
    }
    
    private void verseny(){
        verseny(5);
    }
    
    private void verseny(int kor) {
        mutatKonzolon("A(z) %d körös verseny állapota:\n".formatted(kor));
        for (int i = 0; i < kor; i++) {
            boolean gyorsito = Math.random() > 0.5;
            for (int j = 0; j < csigak.length; j++) {
                Csiga csiga = csigak[j];
                csiga.setGyorsito(gyorsito);
                csiga.megy();
            }
        }
        for (int i = 0; i < csigak.length; i++) {
            palya[i] = csigak[i].getMegtettUt();
        }
    }
    
    private void allastMutat() {
        for (int i = 0; i < csigak.length; i++) {
            Csiga csiga = csigak[i];
            String kod = csiga.getSzinKod();
            String ki = "%s%s%s\n".formatted(kod, csiga.getMegtettUt(), Csiga.getABRA_1());
            mutatKonzolon(ki);
        }
    }

    private String eredmeny() {
        if(fogadas == leghosszabbUt()){
            return "Nyertél!";
        }else{
            return "Vesztettél!";
        }
    }
    
    private int leghosszabbUt() {
        int m = 0;
        for (int i = 1; i < palya.length; i++) {
            if(palya[i].length() > palya[m].length()){
                m = i;
            }
        }
        return m;
    }
    
    private void mutatKonzolon(String info) {
        System.out.print(RESET + info);
    }
}

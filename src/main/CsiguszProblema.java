package main;

import java.util.logging.Level;
import java.util.logging.Logger;
import modell.Csigusz;

public class CsiguszProblema {
    public static void main(String[] args) {
        try {
            /* ha nincs alapértelmezett kstr, nem hívható: */
            //Csigusz cs0 = new Csigusz();
            //feladat(cs0);
            
            /* ha nics minden adattag beállítva,
            lehetséges NullPointerException: */
            Csigusz cs1 = new Csigusz("cs-1");
            feladat(cs1);
            
            //Csigusz cs2 = new Csigusz("cs-2", "zöld");
            Csigusz cs2 = new Csigusz("cs-2", Csigusz.Szinek.ZOLD);
            feladat(cs2);
            
            /* nem jön létre, a rövid név miatt kivételt dob : */
            //Csigusz cs3 = new Csigusz("X3", "kék");
            
            //Csigusz cs3 = new Csigusz("Xy3", "kék");
            Csigusz cs3 = new Csigusz("Xy3", Csigusz.Szinek.KEK);
            feladat(cs3);
            
            /* bármilyen szín megadható */
            //Csigusz cs4 = new Csigusz("Cs-4", "RED");
            //feladat(cs4);
            
            //Csigusz cs5 = new Csigusz("Cs-5", "RókaRudi");
            //feladat(cs5);
            
            
        } catch (Exception ex) {
            //Logger.getLogger(CsiguszProblema.class.getName()).log(Level.SEVERE, null, ex);
            
            /* nem feltétlen egymás alá írja: */
            System.err.println(" --- egy Csigusz nem jött létre! --- ");
            System.err.println("a hiba oka: " + ex.getMessage());
        }
    }

    private static void feladat(Csigusz cs1) {
        System.out.println(cs1.toString());
        /* ha nincs beállítva a szín, akkor: NullPointerException */
        char elso = cs1.getSzin().charAt(0);
        //System.out.println("a szín első betűje = " + elso);
    }
}

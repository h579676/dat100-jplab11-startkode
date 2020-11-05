package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

    public static boolean skriv(Blogg samling, String mappe, String filnavn) {

        PrintWriter pw = null;

        try {
            pw = new PrintWriter(mappe+filnavn);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }


        pw.print(samling.toString());
        pw.close();


        return true;

    }
}
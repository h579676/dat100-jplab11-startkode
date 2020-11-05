package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

    private static String TEKST = "TEKST";
    private static String BILDE = "BILDE";

    public static Blogg les(String mappe, String filnavn) {
        Blogg blogg = new Blogg();
        File file = new File(mappe + filnavn);
        Scanner reader = null;


        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int nesteLedig;
        String type;
        int id;
        String bruker;
        String dato;
        int likes;
        String tekst;
        String url;

        Innlegg i;

        nesteLedig = Integer.parseInt(reader.nextLine());
        while (reader.hasNextLine()) {
            type = reader.nextLine();
            id = Integer.parseInt(reader.nextLine());
            bruker = reader.nextLine();
            dato = reader.nextLine();
            likes = Integer.parseInt(reader.nextLine());
            tekst = reader.nextLine();
            if (type.equals(TEKST)) {
                i = new Tekst(id, bruker, dato, likes, tekst);
            } else {
                url = reader.nextLine();
                i = new Bilde(id, bruker, dato, likes, tekst, url);
            }
            blogg.leggTilUtvid(i);
        }

        System.out.println(blogg.toString());
        System.out.println("Neste ledig: " + blogg.getAntall());


        return blogg;
    }
}
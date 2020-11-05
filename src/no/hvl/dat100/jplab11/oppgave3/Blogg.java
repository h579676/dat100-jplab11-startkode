
package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

    // TODO: objektvariable

    private Innlegg[] innleggtabell;
    private int nesteledig = 0;

    public Blogg() {
        innleggtabell = new Innlegg[20];
    }

    public Blogg(int lengde) {
        innleggtabell = new Innlegg[lengde];
    }

    public int getAntall() {
        return nesteledig;
    }

    public Innlegg[] getSamling() {
        return innleggtabell;

    }

    public int finnInnlegg(Innlegg innlegg) {


        for (int i = 0; i < nesteledig; i++) {
            if (innleggtabell[i].erLik(innlegg)) {
                return i;
            }

        }

        return -1;

    }

    public boolean finnes(Innlegg innlegg) {
        if (finnInnlegg(innlegg) == -1) return false;
        return true;
    }

    public boolean ledigPlass() {
        if (nesteledig >= innleggtabell.length) {
            return false;
        }
        return true;

    }

    public boolean leggTil(Innlegg innlegg) {

        if (ledigPlass()) {
            if (!finnes(innlegg)) {
                innleggtabell[nesteledig] = innlegg;
                nesteledig++;
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String s = nesteledig + "\n";
        for (int i = 0; i < nesteledig; i++) {
            s += innleggtabell[i].toString();
        }
        return s;
    }

    // valgfrie oppgaver nedenfor

    public void utvid() {
        Innlegg[] inntemp = new Innlegg[innleggtabell.length * 2];

        for (int i = 0; i < nesteledig; i++) {
            inntemp[i] = innleggtabell[i];
        }

        innleggtabell = inntemp;

    }

    public boolean leggTilUtvid(Innlegg innlegg) {

        if (ledigPlass()) {
            return leggTil(innlegg);
        } else {
            utvid();
            return leggTil(innlegg);
        }


    }

    public boolean slett(Innlegg innlegg) {

        if (finnes(innlegg)) {
            for (int i = finnInnlegg(innlegg); i < nesteledig - 1; i++) {
                innleggtabell[i] = innleggtabell[i + 1];
            }
            nesteledig--;
            innleggtabell[nesteledig] = null;
            return true;
        }
        return false;
    }

    public int[] search(String keyword) {

        throw new UnsupportedOperationException(TODO.method());

    }
}
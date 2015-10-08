package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko A, B, C;
    private static final String help = "Komennot ovat:\n"
            + "lisää(li), poista(p), kuuluu(k),\n"
            + "yhdiste(y), erotus(e), leikkaus(le),\n"
            + "lopetus(quit)(q).\n"
            + "Joukon kirjain (a/b/c) komentona tulostaa joukon.";

    private static String luku() {
        Scanner lukija = new Scanner(System.in, "utf-8");
        String luettu = lukija.nextLine();
        return luettu;
    }

    private static IntJoukko mikaJoukko() {
        String luettu;
        luettu = luku();
        while (true) {
            if (luettu.equals("A") || luettu.equals("a")) {
                return A;
            } else if (luettu.equals("B") || luettu.equals("b")) {
                return B;
            } else if (luettu.equals("C") || luettu.equals("c")) {
                return C;
            } else {
                System.out.println("Virheellinen joukko! " + luettu);
                System.out.print("Yritä uudelleen!");
                luettu = luku();
            }
        }
    }

    private static void lisaa() {
        int lisLuku;
        IntJoukko joukko;
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mihin joukkoon? ");
        joukko = mikaJoukko();
        System.out.println("");
        System.out.print("Mikä luku lisätään? ");
        lisLuku = lukija.nextInt();
        joukko.lisaa(lisLuku);
        return;

    }

    private static void yhdiste() {
        IntJoukko aJoukko, bJoukko, c;
        System.out.print("1. joukko? ");
        aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        bJoukko = mikaJoukko();
        c = IntJoukko.yhdiste(aJoukko, bJoukko);
        System.out.println("A yhdiste B = " + c.toString());
        return;
    }

    private static void leikkaus() {
        IntJoukko aJoukko, bJoukko, c;
        System.out.print("1. joukko? ");
        aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        bJoukko = mikaJoukko();
        c = IntJoukko.leikkaus(aJoukko, bJoukko);
        System.out.println("A leikkaus B = " + c.toString());
        return;
    }

    private static void erotus() {
        IntJoukko aJoukko, bJoukko, c;
        System.out.print("1. joukko? ");
        aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        bJoukko = mikaJoukko();
        c = IntJoukko.erotus(aJoukko, bJoukko);
        System.out.println("A erotus B = " + c.toString());
        return;
    }

    private static void poista() {
        IntJoukko joukko;
        int lisLuku;
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mistä joukosta? ");
        joukko = mikaJoukko();
        System.out.print("Mikä luku poistetaan? ");
        lisLuku = lukija.nextInt();
        joukko.poista(lisLuku);
        return;
    }

    private static void kuuluu() {
        IntJoukko joukko;
        int kysLuku;
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mihin joukkoon? ");
        joukko = mikaJoukko();
        System.out.print("Mikä luku? ");
        kysLuku = lukija.nextInt();
        boolean kuuluuko = joukko.kuuluu(kysLuku);
        if (kuuluuko) {
            System.out.println(kysLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysLuku + " ei kuulu joukkoon ");
        }
        return;
    }


    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        String luettu;

        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komento h näyttää ohjeen.");

        Scanner lukija = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            luettu = lukija.nextLine();
            if (luettu.equals("lisää") || luettu.equals("li")) {
                lisaa();
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                poista();
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluu();
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                yhdiste();
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                leikkaus();
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                erotus();
            } else if (luettu.equalsIgnoreCase("A")) {
                System.out.println(A);
            } else if (luettu.equalsIgnoreCase("B")) {
                System.out.println(B);
            } else if (luettu.equalsIgnoreCase("C")) {
                System.out.println(C);
            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else if (luettu.equalsIgnoreCase("h")) {
                System.out.println(help);
            } else {
                System.out.println("Virheellinen komento! " + luettu);
                System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
            }
            
        }
    }
}

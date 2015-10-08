package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5,
            OLETUSKASVATUS = 5;

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }

        return z;
    }

    private int kasvatuskoko;
    private int[] ljono;
    private int alkioidenLkm;

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        validoiKonstruktorinParametrit(kapasiteetti, kasvatuskoko);
        initLjono(kapasiteetti);
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    private void initLjono(int kapasiteetti) {
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
    }

    private void validoiKonstruktorinParametrit(int kapasiteetti, int kasvatuskoko1) throws IllegalArgumentException {
        if (kapasiteetti < 1) {
            throw new IllegalArgumentException("Kapasiteetti pitää olla vähintään yksi");
        }
        if (kasvatuskoko1 < 1) {
            throw new IllegalArgumentException("Kasvatuskoko pitää olla vähintään yksi");
        }
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == ljono.length) {
                kasvataLjono();
            }
            return true;
        }
        return false;
    }

    private void kasvataLjono() {
        int[] uusiLjono = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(ljono, uusiLjono);
        ljono = uusiLjono;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;

    }

    public boolean poista(int luku) {
        int kohta = hae(luku);
        if (kohta != -1) {
            ljono[kohta] = 0;
            alkioidenLkm--;
            taytaReika(kohta);
            ljono[alkioidenLkm] = 0;
            return true;
        }
        return false;
    }

    private void taytaReika(int kohta) {
        ljono[kohta] = ljono[alkioidenLkm];
    }

    private int hae(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return i;
            }
        }
        return -1;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(alkioidenLkm * 5);
        sb.append('{');
        if (alkioidenLkm > 1) {
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                sb.append(ljono[i]).append(", ");
            }
        }
        if (alkioidenLkm > 0) {
            sb.append(ljono[alkioidenLkm - 1]);
        }
        sb.append('}');
        return sb.toString();
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(ljono, 0, taulu, 0, taulu.length);
        return taulu;
    }

}

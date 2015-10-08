/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author arvy
 */
abstract class Komento {

    protected Sovelluslogiikka sl;
    protected JTextField i;
    protected JTextField o;
    protected String edellinenArvo;

    public Komento(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.o = tuloskentta;
        this.i = syotekentta;
        this.sl = sovellus;
    }

    void suorita() {
        tallennaEdellinen();
    }

    void peru() {
        o.setText(edellinenArvo);
    }

    private void tallennaEdellinen() {
        edellinenArvo = o.getText();
    }
}

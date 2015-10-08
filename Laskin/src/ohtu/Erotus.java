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
class Erotus extends Komento {

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }

    @Override
    public void suorita() {
        super.suorita();
        sl.miinus(Integer.parseInt(i.getText()));
        o.setText(Integer.toString(sl.tulos()));
    }

}

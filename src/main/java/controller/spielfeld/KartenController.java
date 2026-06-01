package main.java.controller.spielfeld;

import main.java.controller.*;
import main.java.service.*;

import javax.enterprise.context.*;
import javax.inject.*;
import java.util.*;

@Named
@RequestScoped
public class KartenController extends BaseController {
    @Inject
    private ZugValidationService zugController;

    public void umdrehen(int zeile, int reihe) {
        int karte = zeile * getSpielfeld().getReihe().size() + reihe;
        if (!getKartenListe().get(karte).isAufgedeckt()) {
            getKartenListe().get(karte).setAufgedeckt(true);
            zugController.spielzug(karte);
        }
    }
    
    public String kartenInhalt(int zeile, int reihe) {
        int karte = zeile * getSpielfeld().getReihe().size() + reihe;
        if (getKartenListe().get(karte).isAufgedeckt()) {
            return getKartenListe().get(karte).getBild();
        } else {
            return getKartenListe().get(karte).getBack();
        }
    }


    //Getter und Setter
    public ArrayList<Integer> getZeile() {
        return getSpielfeld().getZeile();
    }

    public ArrayList<Integer> getReihe() {
        return getSpielfeld().getReihe();
    }

    public boolean getAufgedeckt(int zeile, int reihe) {
        return getKartenListe().get(zeile * 5 + reihe).isAufgedeckt();
    }

    public String getGewinnNachricht() {
        return getSpieler().getGewinnNachricht();
    }

    public int getPunkte1() {
        return getSpieler().getPunkte1();
    }

    public int getPunkte2() {
        return getSpieler().getPunkte2();
    }

}

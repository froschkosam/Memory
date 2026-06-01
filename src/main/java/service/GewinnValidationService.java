package main.java.service;

import main.java.controller.*;

import java.util.*;

public class GewinnValidationService extends BaseService {

    public void gewinnValidierung() {
        applikation.setEnde(true);
        for (int i = 0; i < getKartenListe().size(); i++) {
            if (!Objects.equals(getBild(i), "leer.jpg") && !Objects.equals(getBild(i), getBild(getLetzteKarte2()))) {
                applikation.setEnde(false);
                break;
            }
        }
        if (applikation.isEnde()) {
            getKartenListe().get(getLetzteKarte1()).setBild("leer.jpg");
            getKartenListe().get(getLetzteKarte2()).setBild("leer.jpg");
            if (getSpieler().getPunkte1() > getSpieler().getPunkte2()) {
                getSpieler().setGewinnNachricht("Glückwunsch Spieler 1, du hast Gewonnen!");
            } else if (getSpieler().getPunkte1() < getSpieler().getPunkte2()) {
                getSpieler().setGewinnNachricht("Glückwunsch Spieler 2, du hast Gewonnen!");
            } else {
                getSpieler().setGewinnNachricht("Unentschieden, jeder hat Gewonnen!");
            }
        }
    }
}

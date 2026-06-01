package main.java.service;

import javax.inject.*;
import java.util.*;

public class ZugValidationService extends BaseService{
    @Inject
    private GewinnValidationService gewinnController;

    public void spielzug(int karte) {
        getKartenSpeicher().setZug(getKartenSpeicher().getZug() + 1);

        if (getKartenSpeicher().getZug() >= 3) {
            getKartenSpeicher().setZug(1);
            //Prüft ob es die gleichen Bilder sind und "entfernt" sie vom Spielfeld
            if (Objects.equals(getBild(getLetzteKarte1()),getBild(getLetzteKarte2()))) {
                 getKartenListe().get(getLetzteKarte1()).setBild("leer.jpg");
                getKartenListe().get(getLetzteKarte2()).setBild("leer.jpg");
            }
            //Dreht die Karten wieder um wenn sie nicht zusammen passen
            else {
                getKartenListe().get(getLetzteKarte1()).setAufgedeckt(false);
                getKartenListe().get(getLetzteKarte2()).setAufgedeckt(false);
            }
        }
        //Speichert die letzte Karte
        else {
            getKartenSpeicher().setLetzteKarte2(karte);
        }

        if (getKartenSpeicher().getZug() >= 2) {
            //Prüft ob es die gleichen Bilder sind und "entfernt" sie vom Spielfeld
            if (Objects.equals(getBild(getLetzteKarte1()), getBild(karte))) {
                //Setzt Punkte
                if (getSpieler().isSpieler1()) {
                    getSpieler().setPunkte1(getSpieler().getPunkte1() + 1);
                } else {
                    getSpieler().setPunkte2(getSpieler().getPunkte2() + 1);
                }
                gewinnController.gewinnValidierung();
            }
            else {
                //Spielerwechsel
                getSpieler().setSpieler1(!getSpieler().isSpieler1());
            }
        }
        //Speichert die letzte Karte
        else {
            getKartenSpeicher().setLetzteKarte1(karte);
        }
    }

}

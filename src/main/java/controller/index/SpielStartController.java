package main.java.controller.index;

import main.java.controller.*;
import main.java.model.data.*;

import javax.enterprise.context.*;
import javax.inject.*;
import java.util.*;

@Named
@RequestScoped
public class SpielStartController extends BaseController {

    public void spielStart(int karten) {
        applikation.setSchwierigkeit(false);
        applikation.setSpielfeld(new Spielfeld());
        applikation.setSpieler(new Spieler());
        applikation.setKarte(new Karte("", "", false));
        applikation.setKartenSpeicher(new KartenSpeicher());
        applikation.setStart(true);
        applikation.setEnde(false);
        getSpielfeld().setKartenNummerierung(initializeKartenMischen());
        getSpielfeld().setKartenList(initializeKartenList(karten));
        getSpielfeld().setReihe(initializeReihe(karten));
        getSpielfeld().setZeile(initializeZeile(karten));
        getSpieler().setSpieler1(true);
        getSpieler().setPunkte1(0);
        getSpieler().setPunkte2(0);
    }

    public ArrayList<Integer> initializeKartenMischen() {
        ArrayList<Integer> kartenListe = new ArrayList<>();
        for (int i = 0; i <= 19; i++) {
            kartenListe.add(i);
        }
        Collections.shuffle(kartenListe);
        return kartenListe;
    }

    public ArrayList<Karte> initializeKartenList(int karten) {
        ArrayList<Karte> kartenList = new ArrayList<>();
        for (int i = 0; i < karten/2; i++) {
            kartenList.add(new Karte("back.jpg", "pepe" + getSpielfeld().getKartenNummerierung().get(i) + ".jpg", false));
            kartenList.add(new Karte("back.jpg", "pepe" + getSpielfeld().getKartenNummerierung().get(i) + ".jpg", false));
        }
        Collections.shuffle(kartenList);
        return kartenList;
    }

    public ArrayList<Integer> initializeZeile(int karten) {
        ArrayList<Integer> zeile = new ArrayList<>();
        int index= 0;
        if (karten == 12){ index = 3;}
        else if (karten == 20) { index = 4;}
        else if (karten == 40) { index = 5;}


        for (int i = 0; i < index; i++) {
            zeile.add(i);
        }
        return zeile;
    }

    public ArrayList<Integer> initializeReihe(int karten) {
        ArrayList<Integer> reihe = new ArrayList<>();
        int index= 0;
        if (karten == 12){ index = 4;}
        else if (karten == 20) { index = 5;}
        else if (karten == 40) { index = 6;}

        for (int i = 0; i < index; i++) {
            reihe.add(i);
        }
        return reihe;
    }

    public boolean isStart() {
        return applikation.isStart();
    }

    public boolean isEnde() {
        return applikation.isEnde();
    }
}

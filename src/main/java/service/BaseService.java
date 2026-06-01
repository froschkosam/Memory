package main.java.service;

import main.java.model.*;
import main.java.model.data.*;

import javax.inject.*;
import java.util.*;

public class BaseService {
    @Inject
    protected Applikation applikation;
    protected KartenSpeicher getKartenSpeicher(){
        return applikation.getKartenSpeicher();
    }
    protected ArrayList<Karte> getKartenListe() {
        return applikation.getSpielfeld().getKartenList();
    }
    protected int getLetzteKarte1(){
        return getKartenSpeicher().getLetzteKarte1();
    }
    protected int getLetzteKarte2(){
        return getKartenSpeicher().getLetzteKarte2();
    }
    protected String getBild(int index){
        return getKartenListe().get(index).getBild();
    }
    protected Spieler getSpieler(){
        return applikation.getSpieler();
    }


}

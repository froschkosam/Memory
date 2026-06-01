package main.java.controller;

import main.java.model.*;
import main.java.model.data.*;

import javax.enterprise.context.*;
import javax.inject.*;
import java.util.*;

@Named
@RequestScoped
public class BaseController {

    @Inject
    protected Applikation applikation;

    protected ArrayList<Karte> getKartenListe() {
        return applikation.getSpielfeld().getKartenList();
    }
    protected Spielfeld getSpielfeld(){
        return applikation.getSpielfeld();
    }
    protected Spieler getSpieler(){
        return applikation.getSpieler();
    }
}

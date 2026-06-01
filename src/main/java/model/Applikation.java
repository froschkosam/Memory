package main.java.model;

import lombok.*;
import main.java.model.data.*;

import javax.enterprise.context.*;

@Getter
@Setter
@ApplicationScoped
public class Applikation {

    //benötigte Objekte
    private boolean schwierigkeit;
    private boolean ende;
    private boolean start;
    private Karte karte;
    private Spielfeld spielfeld;
    private KartenSpeicher kartenSpeicher;
    private Spieler spieler;
}

package main.java.model.data;

import lombok.*;

import java.util.*;

@Getter
@Setter
public class Karte {

    private String back;
    private String bild;
    private boolean aufgedeckt;

    public Karte(String back, String bild, boolean aufgedeckt) {
        this.back = back;
        this.bild = bild;
        this.aufgedeckt = aufgedeckt;
    }


}

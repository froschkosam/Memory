package main.java.model.data;

import lombok.*;

import java.util.*;

@Getter
@Setter
public class Spielfeld {
    ArrayList<Integer> kartenNummerierung;
    ArrayList<Karte> kartenList;
    ArrayList<Integer> reihe;
    ArrayList<Integer> zeile;
}

package main.java.service;

import com.google.gson.*;
import main.java.controller.*;
import main.java.model.*;

import javax.enterprise.context.*;
import javax.inject.*;
import java.io.*;

@Named
@RequestScoped
public class SpielstandService extends BaseService {

    public void save() {
        Gson gson = new Gson();
        Applikation speichern = new Applikation();
        speichern.setSchwierigkeit(applikation.isSchwierigkeit());
        speichern.setEnde(applikation.isEnde());
        speichern.setStart(applikation.isStart());
        speichern.setKartenSpeicher(getKartenSpeicher());
        speichern.setKarte(applikation.getKarte());
        speichern.setSpieler(getSpieler());
        speichern.setSpielfeld(applikation.getSpielfeld());

        String jsonArray = gson.toJson(speichern);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Spielstand.json"));
            writer.write(jsonArray);
            writer.close();
        } catch (Exception ignored) {
            System.out.println("not saved");
        }

    }

    public void load() {
        Gson gson = new Gson();
        Applikation laden = new Applikation();
        try {
            laden = gson.fromJson(new FileReader("Spielstand.json"), laden.getClass());

        } catch (Exception ignored) {
            System.out.println("not loaded");
        }
        applikation.setSchwierigkeit(laden.isSchwierigkeit());
        applikation.setEnde(laden.isEnde());
        applikation.setStart(laden.isStart());
        applikation.setKartenSpeicher(laden.getKartenSpeicher());
        applikation.setKarte(laden.getKarte());
        applikation.setSpieler(laden.getSpieler());
        applikation.setSpielfeld(laden.getSpielfeld());

    }


}

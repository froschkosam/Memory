package main.java.controller.index;

import main.java.model.*;
import main.java.service.*;

import javax.enterprise.context.*;
import javax.inject.*;

@Named
@RequestScoped
public class SpielstandController {

    @Inject
    private SpielstandService spielstandservice;


    public void save() {
        spielstandservice.save();
    }

    public void load() {
        spielstandservice.load();
    }


}

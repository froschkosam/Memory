package main.java;

import com.google.gson.*;
import main.java.model.*;

import javax.enterprise.context.*;
import javax.enterprise.event.*;
import javax.inject.*;
import javax.servlet.*;
import java.util.*;

@ApplicationScoped
public class ModuleInitializer {

    @Inject
    private Applikation applikation;


    //Initializiert beim Start des Webservers benötigte Objekte
    public void initializeModels(@Observes @Initialized(ApplicationScoped.class) ServletContext context) {
        //SpielStartController Variable
        applikation.setStart(false);
        applikation.setEnde(false);
    }
}

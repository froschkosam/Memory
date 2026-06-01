package main.java.controller.index;

import main.java.controller.*;

import javax.enterprise.context.*;
import javax.inject.*;

@Named
@RequestScoped
public class SchwierigkeitController extends BaseController {

    public void setSchwierigkeit(){
        applikation.setSchwierigkeit(true);
        applikation.setStart(false);
        applikation.setEnde(false);
    }
    public boolean isSchwierigkeit(){
        return applikation.isSchwierigkeit(); }
}

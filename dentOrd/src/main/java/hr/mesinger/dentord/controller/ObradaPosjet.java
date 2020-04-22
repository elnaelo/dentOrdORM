/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mesinger.dentord.controller;

import hr.mesinger.dentord.model.Pacijent;
import hr.mesinger.dentord.model.Posjet;
import hr.mesinger.dentord.util.EdunovaException;
import java.util.List;

/**
 *
 * @author Zvonimir
 */
public class ObradaPosjet extends Obrada<Posjet>{

    public ObradaPosjet(){
        super();
    }
    public ObradaPosjet(Posjet entitet){
        super(entitet);
    }
    
    @Override
    protected void kontrolaCreate() throws EdunovaException {
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }

    @Override
    public List<Posjet> getPodaci() {
        return session.createQuery("from Posjet").list();
    }
    
    @Override
    protected void nakonSpremanja() throws EdunovaException {
    }
    
    
}

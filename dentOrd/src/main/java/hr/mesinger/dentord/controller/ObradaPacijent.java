/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mesinger.dentord.controller;

import hr.mesinger.dentord.model.Pacijent;
import hr.mesinger.dentord.util.EdunovaException;
import java.util.List;

/**
 *
 * @author Zvonimir
 */
public class ObradaPacijent extends Obrada<Pacijent>{
    
    public ObradaPacijent(){
        super();
    }
    public ObradaPacijent(Pacijent entitet){
        super(entitet);
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaBrojZdravstvene();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }

    @Override
    public List<Pacijent> getPodaci() {
        return session.createQuery("from Pacijent").list();
    }
    public List<Pacijent> getPodaci(String uvjet){
        return session.createQuery("from Pacijent p "
                + " where concat(p.ime, ' ', p.prezime) like :uvjet "
                + " or concat(p.prezime, ' ', p.ime) like :uvjet ")
                .setParameter("uvjet", "%" + uvjet + "%")
                .setMaxResults(20).list();
    }

    @Override
    protected void nakonSpremanja() throws EdunovaException {
    }
     private void kontrolaBrojZdravstvene() throws EdunovaException{
        if(!(entitet.getBrojZdravstvene()==null || entitet.getBrojZdravstvene().trim().length() > 10 || entitet.getBrojZdravstvene().length() < 10)){
            throw new EdunovaException("Broj zdravstvene nije valjan!");
        }
        
    }   
    
     
     
    
}

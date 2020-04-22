/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mesinger.dentord.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Zvonimir
 */
@Entity
@Table(name = "posjet")
public class Posjet extends Entitet{
    
    private String razlog;
    private String zahvat;
    private BigDecimal predvidenoTrajanje;
    private Date pocetak;
    private boolean izvrsen;
    
    @ManyToOne
    private Stomatolog stomatolog;
    
    @ManyToOne
    private Pacijent pacijent;
    
    @ManyToOne
    private Prostorija prostorija;

    public String getRazlog() {
        return razlog;
    }

    public void setRazlog(String razlog) {
        this.razlog = razlog;
    }

    public String getZahvat() {
        return zahvat;
    }

    public void setZahvat(String zahvat) {
        this.zahvat = zahvat;
    }

    public BigDecimal getPredvidenoTrajanje() {
        return predvidenoTrajanje;
    }

    public void setPredvidenoTrajanje(BigDecimal predvidenoTrajanje) {
        this.predvidenoTrajanje = predvidenoTrajanje;
    }

    public Date getPocetak() {
        return pocetak;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public Stomatolog getStomatolog() {
        return stomatolog;
    }

    public void setStomatolog(Stomatolog stomatolog) {
        this.stomatolog = stomatolog;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public Prostorija getProstorija() {
        return prostorija;
    }

    public void setProstorija(Prostorija prostorija) {
        this.prostorija = prostorija;
    }

    public boolean isIzvrsen() {
        return izvrsen;
    }

    public void setIzvrsen(boolean izvrsen) {
        this.izvrsen = izvrsen;
    }


    

 
  

    
    @Override
    public String toString() {
        return this.pacijent + " - " + this.pocetak;
    }

    
    
    
    
}

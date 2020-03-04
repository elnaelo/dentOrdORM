/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mesinger.dentord.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Zvonimir
 */
@Entity
public class Posjet extends Entitet{
    
    private String razlog;
    private String zahvat;
    private BigDecimal predvidenoTrajanje;
    private Date pocetak;
    
    @ManyToOne
    private Stomatolog stomatolog;
    
    @ManyToOne
    private Pacijent pacijent;
    
    @ManyToOne
    private Prostorija prostorija;

    public void setRazlog(String razlog) {
        this.razlog = razlog;
    }

    public void setZahvat(String zahvat) {
        this.zahvat = zahvat;
    }

    public void setPredvidenoTrajanje(BigDecimal predvidenoTrajanje) {
        this.predvidenoTrajanje = predvidenoTrajanje;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public void setStomatolog(Stomatolog stomatolog) {
        this.stomatolog = stomatolog;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public void setProstorija(Prostorija prostorija) {
        this.prostorija = prostorija;
    }
    
    
    
}

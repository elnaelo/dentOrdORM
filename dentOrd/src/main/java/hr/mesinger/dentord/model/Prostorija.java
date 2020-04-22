/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mesinger.dentord.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Zvonimir
 */
@Entity
@Table(name = "prostorija")
public class Prostorija extends Entitet{
    
    private String naziv;
    private String adresa;
    private BigDecimal duzina;
    private BigDecimal sirina;
    private BigDecimal visina;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public BigDecimal getDuzina() {
        return duzina;
    }

    public void setDuzina(BigDecimal duzina) {
        this.duzina = duzina;
    }

    public BigDecimal getSirina() {
        return sirina;
    }

    public void setSirina(BigDecimal sirina) {
        this.sirina = sirina;
    }

    public BigDecimal getVisina() {
        return visina;
    }

    public void setVisina(BigDecimal visina) {
        this.visina = visina;
    }
    
  
    @Override
    public String toString() {
        return this.naziv + " - " + this.adresa;
    }
    
    
    
}

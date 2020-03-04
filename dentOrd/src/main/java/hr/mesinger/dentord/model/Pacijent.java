/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mesinger.dentord.model;

import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author Zvonimir
 */
@Entity
public class Pacijent extends Entitet{
    
    private String ime;
    private String prezime;
    private Date datumRodenja;
    private String brojTelefona;
    private String brojZdravstvene;
    private String email;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodenja() {
        return datumRodenja;
    }

    public void setDatumRodenja(Date datumRodenja) {
        this.datumRodenja = datumRodenja;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getBrojZdravstvene() {
        return brojZdravstvene;
    }

    public void setBrojZdravstvene(String brojZdravstvene) {
        this.brojZdravstvene = brojZdravstvene;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}

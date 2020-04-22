/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mesinger.dentord.util;


import hr.mesinger.dentord.controller.ObradaMedicinskaSestra;
import hr.mesinger.dentord.controller.ObradaOperater;
import hr.mesinger.dentord.controller.ObradaPacijent;
import hr.mesinger.dentord.controller.ObradaPosjet;
import hr.mesinger.dentord.controller.ObradaProstorija;
import hr.mesinger.dentord.controller.ObradaStomatolog;
import hr.mesinger.dentord.model.MedicinskaSestra;
import hr.mesinger.dentord.model.Operater;
import hr.mesinger.dentord.model.Pacijent;
import hr.mesinger.dentord.model.Posjet;
import hr.mesinger.dentord.model.Prostorija;
import hr.mesinger.dentord.model.Stomatolog;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Profesor
 */
public class Pomocno {
    
    public static Operater LOGIRAN;
   
    private final static DecimalFormat df = df();
    
     private static DecimalFormat df(){
        NumberFormat nf = NumberFormat.
                getNumberInstance(new Locale("hr","HR"));
         DecimalFormat dfl = (DecimalFormat) nf;
         dfl.applyPattern("#,###.00");
    return dfl;
    }
     
      public static Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
          .atZone(ZoneId.systemDefault())
            .toInstant());
    }
    
    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
}
   
     
    public static String getFormatCijelogBroja(long i){
        //https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html
        DecimalFormat dfCijeliBroj = new DecimalFormat("#");
        return dfCijeliBroj.format(i);
    }
    
    public static int getCijeliBrojIzStringa(String s){
         try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
    
    public static String getFormatDecimalniBroj(BigDecimal b){
       
        return df.format(b);
    }
    
    public static BigDecimal getDecimalniBrojIzStringa(String s){
        try {
            return new BigDecimal(df.parse(s).doubleValue());
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
           
    }
  
    
    public static void PocetniInsert(){
        Operater o = new Operater();
        o.setEmail("zvonimir.mesinger@gmail.com");
        o.setIme("Zvonimir");
        o.setPrezime("Mesinger");
        o.setLozinka(BCrypt.hashpw("z", BCrypt.gensalt()));
        
        ObradaOperater oo = new ObradaOperater(o);
        
        try {
            oo.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        Stomatolog s = new Stomatolog();
        
        s.setIme("Jozo");
        s.setPrezime("Jozic");
        s.setOib("32308542666");
        s.setIban("HR9824020066879519758");
        s.setEmail("jozo.jozic@gmail.com");
        s.setBrojTelefona("0919819832");
        
        ObradaStomatolog os = new ObradaStomatolog(s);
        
        try {
            os.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        
        
        
        MedicinskaSestra ms = new MedicinskaSestra();
        
        ms.setIme("Mara");
        ms.setPrezime("Marić");
        ms.setEmail("mara.maric@gmail.com");
        ms.setIban("HR6523400098767267526");
        ms.setBrojTelefona("0924567124");
        ms.setOib("32308542666");
        ms.setStomatolog(s);
        
        ObradaMedicinskaSestra oms= new ObradaMedicinskaSestra(ms);
        
        try {
            oms.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        
        Pacijent p = new Pacijent();
        
        p.setIme("Marko");
        p.setPrezime("Marić");
        p.setDatumRodenja(new Date(1999, 2, 4));
        p.setBrojZdravstvene("123456789");
        p.setEmail("mmaric@gmail.com");
        p.setBrojTelefona("0978956773");
        
        ObradaPacijent op = new ObradaPacijent(p);
        
        try {
            op.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        Prostorija prostorija = new Prostorija();
        
        prostorija.setNaziv("A1");
        prostorija.setAdresa("Istarska 18");
        prostorija.setDuzina(new BigDecimal(11));
        prostorija.setSirina(new BigDecimal(4));
        prostorija.setVisina(new BigDecimal(3));
        
        ObradaProstorija obradaprostorija= new ObradaProstorija(prostorija);
        
        try {
            obradaprostorija.create();
        } catch (EdunovaException ex) {
           System.out.println(ex.getPoruka());
        }
        
        Posjet posjet = new Posjet();
        
        posjet.setPacijent(p);
        posjet.setPocetak(new Date());
        posjet.setPredvidenoTrajanje(new BigDecimal(45));
        posjet.setRazlog("Zubobolja");
        posjet.setProstorija(prostorija);
        posjet.setStomatolog(s);
        posjet.setZahvat("Tretman lijekom");
        
        ObradaPosjet obradaPosjet = new ObradaPosjet(posjet);
        
        try {
            obradaPosjet.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        
        
        
        
        
    
    
    }
    
    
    public static String getNazivAplikacije(){
        return "Dentalna Ordinacija";
    }
    
   
    
    public static boolean isOibValjan(String oib) {
        
        if(oib==null){
            return false;
        }
            
            

        if (oib.length() != 11)
            return false;

        try {
            Long.parseLong(oib);
        } catch (NumberFormatException e) {
            return false;
        }

        int a = 10;
        for (int i = 0; i < 10; i++) {
            a = a + Integer.parseInt(oib.substring(i, i+1));
            a = a % 10;
            if (a == 0)
                a = 10;
            a *= 2;
            a = a % 11;
        }
        int kontrolni = 11 - a;
        if (kontrolni == 10)
            kontrolni = 0;

        return kontrolni == Integer.parseInt(oib.substring(10));
    }
  
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mesinger.dentord;

import hr.mesinger.dentord.util.Pomocno;
import hr.mesinger.dentord.view.SplashScreen;

/**
 *
 * @author Zvonimir
 */
public class Start {
    
    public Start(){
        
        //Pomocno.PocetniInsert();
        new SplashScreen().setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new Start();
    }
    
}

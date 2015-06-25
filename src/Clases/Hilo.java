/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Ventanas.Juego;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pato
 */
public class Hilo implements Runnable
{
    Juego oJuego;
    int iVelocidad;
    public Hilo (Juego oJuego)
    {
        this.oJuego = oJuego;
        iVelocidad = 1;
    }
    @Override
    public void run() 
    {
        try 
        {
            Thread.sleep(1000*iVelocidad);
        } catch (InterruptedException ex) {}
        
    }
    
}

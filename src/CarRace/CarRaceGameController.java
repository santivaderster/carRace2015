/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarRace;

import Beat.ControllerInterface;
import Ventanas.Juego;

/**
 *
 * @author Pato
 */

public class CarRaceGameController implements ControllerInterface
{
    CarRaceModel Modelo ;
    Juego Vista ;

    public CarRaceGameController(CarRaceModel modelo) 
    {
        this.Modelo = modelo;
        this.Vista = new Juego(this,modelo);
        modelo.initialize();
    }
    
    @Override
    public void start() 
    {
         Modelo.initialize();
         Modelo.on();
    }

    @Override
    public void stop() 
    {
        Modelo.off();
    }

    @Override
    public void increaseBPM() 
    {
        Modelo.setBPM(Modelo.getBPM()+1);
    }

    @Override
    public void decreaseBPM() 
    {
        Modelo.setBPM(Modelo.getBPM()-1);
    }

    @Override
    public void setBPM(int bpm) 
    {
        Modelo.setBPM(bpm);
    }
    
    public void MoverIzquierda() 
    {
        //Modelo.setPosicionX(-Vista.getiMovimientoX(),Vista.getiLimiteXIzquierda(),Vista.getiLimiteXDerecha());
    }

    public void MoverDerecha() 
    {
//        Modelo.setPosicionX(Vista.getiMovimientoX(),Vista.getiLimiteXIzquierda(),Vista.getiLimiteXDerecha());
    }

    public void Reiniciar() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void FlechaIzquierda() 
    {
        String sIconoActual = Modelo.FlechaIzquierda(Vista.getsIconoActual());
        switch(sIconoActual)
        {
            case "Amarillo":
                Vista.getLblAuto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAma.png")));
                break;
            case "Rojo":
                Vista.getLblAuto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoRojo.png")));
                break;
            case "Azul":
                Vista.getLblAuto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAzul.png")));
                break;
        }
        Vista.setsIconoActual(sIconoActual);
    }


    public void FlechaDerecha() 
    {
        String sIconoActual = Modelo.FlechaDerecha(Vista.getsIconoActual());
        switch(sIconoActual)
        {
            case "Amarillo":
                Vista.getLblAuto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAma.png")));
                break;
            case "Rojo":
                Vista.getLblAuto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoRojo.png")));
                break;
            case "Azul":
                Vista.getLblAuto().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAzul.png")));
                break;
        }
        Vista.setsIconoActual(sIconoActual);
    }
    
}

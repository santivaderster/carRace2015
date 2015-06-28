/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CarRaceModel;
import Controller.ControllerInterface;
import View.Juego;

/**
 *
 * @author Pato
 */

public class CarRaceGameController implements ControllerInterface
{
    private CarRaceModel Modelo ;
    private Juego Vista ;

    public CarRaceGameController(CarRaceModel modelo, Juego vista) 
    {
        this.Modelo = modelo;
        this.Vista = vista;
        Modelo.notifyModelObservers("todo");
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
        Modelo.setPosicionX(-1);
    }

    public void MoverDerecha() 
    {
        Modelo.setPosicionX(1);
    }

    public void Reiniciar() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void FlechaIzquierda() 
    {
        Modelo.FlechaIzquierda();

    }


    public void FlechaDerecha() 
    {
        Modelo.FlechaDerecha();
    }

    public void setVista(Juego Vista) {
        this.Vista = Vista;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarRace;

import Ventanas.Juego;

/**
 *
 * @author Pato
 */

public class CarRaceGameController implements CarRaceGameControllerInterface{
    CarRaceModel Modelo ;
    Juego Vista ;

    public CarRaceGameController(CarRaceModel model, Juego vista) {
        this.Modelo = model;
        this.Vista = vista;
    }
    
    @Override
    public void MoverIzquierda() 
    {
        Modelo.setPosicionX(-Vista.getiMovimientoX(),Vista.getiLimiteXIzquierda(),Vista.getiLimiteXDerecha());
    }

    @Override
    public void MoverDerecha() 
    {
        Modelo.setPosicionX(Vista.getiMovimientoX(),Vista.getiLimiteXIzquierda(),Vista.getiLimiteXDerecha());
    }

    @Override
    public void Pausa() {
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Reiniciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void FlechaIzquierda() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void FlechaDerecha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Comenzar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

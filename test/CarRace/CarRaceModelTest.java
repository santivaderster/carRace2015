/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarRace;

import Observer.BPMObserver;
import Observer.BeatObserver;
import Model.CarRaceModel;
import Class.Car;
import java.util.ArrayList;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ariel
 */
public class CarRaceModelTest 
{

    Car autoTest = new Car(80, 460, "Amarillo", true);
    ArrayList<Car> autosContra = new ArrayList<>();
    Car oAuto;
    String sColor = null;
    int iLimiteXIzquierda = 80;
    int iLimiteXDerecha = 480;
    int iLimiteYArriba = 0;
    int iLimiteYAbajo = 460;
    int iMovimientoX = 100;
    int iMovimientoY = 50;
    CarRaceModel model = new CarRaceModel(autoTest, autosContra);

    @Before
    public void iniciar() 
    {
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    sColor = "Amarillo";
                    break;
                case 1:
                    sColor = "Rojo";
                    break;
                case 2:
                    sColor = "Azul";
                    break;
                case 3:
                    sColor = "Amarillo";
                    break;
                case 4:
                    sColor = "Azul";
                    break;
            }
            oAuto = new Car(i * iMovimientoX + iLimiteXIzquierda, iLimiteYAbajo, sColor, false);
            autosContra.add(oAuto);
            oAuto = null;
        }
        model.initialize();
        model.on();
    }

    @Test
    public void testFuelNegativa() 
    {
        int iPositiva = 5;
        int iNegativa = -5;
        autoTest.setFuel(iPositiva);
        autoTest.setFuel(iNegativa);
        assertEquals(iPositiva, autoTest.getFuel());
    }
    
    @Test
    public void testChoque() 
    {
        autoTest.setPosicionx(80);
        autosContra.get(0).setVisible(true);
        autosContra.get(0).setPosiciony(100);
        assertTrue(model.detectorChoque());
    }

    @Test
    public void testPasarLimiteX() 
    {
        int iAceptable = 1;
        int iSuperaLimite = 5000;
        int esperada = 180;

        model.setPosicionX(iAceptable);
        model.setPosicionX(iSuperaLimite);
        assertEquals(esperada, model.getMiauto().getPosicionx());
    }

    @After
    public void finalizar() 
    {
        model.off();
    }
}
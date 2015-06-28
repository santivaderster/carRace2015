/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarRace;

import Beat.BPMObserver;
import Beat.BeatObserver;
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
public class CarRaceModelTest {
    
    Tesoro tesoro = new Tesoro();
    DetectorModel model = new DetectorModel(tesoro);

    @Before
    public void inicializar(){
            model.initialize();
            model.on();
    }
}

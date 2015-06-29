/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beat;

import Model.BeatModel;
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
public class BeatModelTest {
    
    BeatModel model = new BeatModel();
    
    @Before
    public void iniciar()
    {
        model.initialize();
        model.on();        
    }
    
    @Test
    public void testSetBPM() 
    {
            int BPM=60;               
            model.setBPM(BPM);

            assertEquals(BPM, model.getBPM());
    }   
        
    @After
    public void terminar()
    {
        model.off();
    }
}

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
    
    @Test
        public void testBPM() {
                int var=60;
                BeatModel model = new BeatModel();
                model.initialize();
                model.on();
                model.setBPM(var);
                assertEquals(var, model.getBPM());
                model.off();
        }   
}

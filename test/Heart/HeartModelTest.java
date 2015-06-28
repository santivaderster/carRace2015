/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heart;

import Beat.BPMObserver;
import Beat.BeatObserver;
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
public class HeartModelTest {
    
    @Test
        public void testContador() {
                
                HeartModel heart = HeartModel.getInstance();
                assertNotNull(heart);
                
                int esperado = heart.getHeartRate();
                HeartModel heart2 = HeartModel.getInstance();
                int actual = heart2.getHeartRate();
                assertEquals(esperado, actual-1);
        }

        @Test
        public void testSingleton() {
                HeartModel aux = HeartModel.getInstance();
                assertEquals(aux, HeartModel.getInstance());
                assertEquals(aux, HeartModel.getInstance());
                assertEquals(aux, HeartModel.getInstance());
                assertEquals(aux, HeartModel.getInstance());
        }
        
}

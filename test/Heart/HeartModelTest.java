/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heart;

import Model.HeartModel;
import Observer.BPMObserver;
import Observer.BeatObserver;
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
    public void testSingleton() {
            HeartModel aux = HeartModel.getInstance();

            for (int i = 0; i < 5; i++) {
            assertEquals(aux, HeartModel.getInstance());
        }
    }
        
}

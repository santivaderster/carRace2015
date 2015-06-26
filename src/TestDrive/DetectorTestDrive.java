package TestDrive;

import Beat.ControllerInterface;
 
import CarRace.CarRaceController;
 
import CarRace.CarRaceModel;
 

 
public class DetectorTestDrive {
 

 
        public static void main(String[] args) {
 
                CarRaceModel carModel = new CarRaceModel() {};
 
        ControllerInterface model = new CarRaceController(carModel);
 
        }
 

 
} 

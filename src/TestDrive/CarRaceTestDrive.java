package TestDrive;

import Beat.ControllerInterface;
import CarRace.CarRaceController;
import CarRace.CarRaceModel;
import CarRace.CarRaceGameController;

 
public class CarRaceTestDrive 
{ 
    public static void main(String[] args) 
    {
        CarRaceModel Modelo = new CarRaceModel() {};
        ControllerInterface controladorBeat = new CarRaceController(Modelo);
        ControllerInterface controladorJuego = new CarRaceGameController(Modelo);
    }
} 

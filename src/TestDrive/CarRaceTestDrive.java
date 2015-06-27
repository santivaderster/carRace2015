package TestDrive;

import Beat.ControllerInterface;
import CarRace.Autos;
import CarRace.CarRaceController;
import CarRace.CarRaceModel;
import CarRace.CarRaceGameController;
import java.util.ArrayList;

 
public class CarRaceTestDrive 
{ 
    public static void main(String[] args) 
    {
       CarRaceModel Modelo = new CarRaceModel(new Autos(80,0,null,false) ,new ArrayList<Autos>());
       ControllerInterface controladorJuego = new CarRaceController(Modelo);
    }
} 

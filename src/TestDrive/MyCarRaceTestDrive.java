package TestDrive;

import Controller.ControllerInterface;
import Class.Car;
import Controller.CarRaceController;
import Model.CarRaceModel;
import Controller.CarRaceGameController;
import java.util.ArrayList;

 
public class MyCarRaceTestDrive 
{ 
    public static void main(String[] args) 
    {
       CarRaceModel Modelo = new CarRaceModel(new Car(80,0,"eventTestDrive",false) ,new ArrayList<Car>());
       ControllerInterface controladorJuego = new CarRaceController(Modelo);
    }
} 

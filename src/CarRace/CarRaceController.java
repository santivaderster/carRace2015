/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarRace;
import Beat.ControllerInterface;
import Beat.DJView;

/**
 *
 * @author Ariel
 */
public class CarRaceController implements ControllerInterface
{
    CarRaceModel model;
    DJView view;

    public CarRaceController(CarRaceModel model) {
        this.model = model;
        view = new DJView(this, new CarRaceAdapter(model));
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
        model.initialize();   // ver inicializacion de modelo 
    }

    public CarRaceController(CarRaceModel model, DJView view) 
    {
        this.model = model;
        this.view = view;
        this.view.disableStopMenuItem();
        this.view.enableStartMenuItem();
        this.model.initialize();  // ver inicializacion del modelo 
    }

    public void start() {
        model.on();  // ver on del modelo 
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    public void stop() {
        model.off();  // ver off del modelo 
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    public void increaseBPM() {
        int fuel = model.getfuel();
        model.setfuel(fuel + 1);
    }

    public void decreaseBPM() {
        int fuel = model.getfuel();
        model.setfuel(fuel - 1);
    }

    public void setBPM(int bpm) {
        //	model.setDistancia(bpm); // ver este metodo por el momento no hace nada porque ya tiene el increase y decrease
        model.setfuel(bpm);
    }

    public void setView(DJView view) {
        this.view = view;
    }
} 
	
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarRace;
import Beat.ControllerInterface;

/**
 *
 * @author Ariel
 */
public class CarRaceController implements ControllerInterface{
        
        CarRaceModel model;
        DJView view;
        
        public CarRaceController(CarRaceModel model){
                this.model=model;
                view = new DJView(this, new CarRaceAdapter(model));
        view.createView();
        view.createControls();
                view.disableStopMenuItem();
                view.enableStartMenuItem();
                model.initialize();
        }
        
        public DetectorController(CarRaceModel model, DJView view){
                this.model = model;
                this.view = view;
                this.view.disableStopMenuItem();
                this.view.enableStartMenuItem();
                this.model.initialize();
                
        }
        public void start() {
                model.on();
                view.disableStartMenuItem();
                view.enableStopMenuItem();
        }
  
        public void stop() {
                model.off();
                view.disableStopMenuItem();
                view.enableStartMenuItem();
        }
    
        @Override
        public void increaseBPM() {
        int nafta = model.getFuel();
        model.setFuel(nafta + 1);
        }
        
        @Override
        public void decreaseBPM() {
        int nafta = model.getFuel();
        model.setFuel(nafta - 1);
        }
        
        @Override
        public void setBPM(int bpm) {
                model.setFuel(bpm);
        }
        
        public void setView(DJView view){
                this.view = view;
        }
}
	
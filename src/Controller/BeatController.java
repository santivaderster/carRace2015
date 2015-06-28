package Controller;

import View.DJView;
import Model.BeatModelInterface;
import Model.BeatModel;
import View.StrategyView;





public class BeatController implements ControllerInterface {
 
	BeatModelInterface model;
 
	DJView view;
 
   
 
	public BeatController(BeatModelInterface model) {
 
		this.model = model;
 
		view = new DJView(this, model);
 
        view.createView();
 
        view.createControls();
 
		view.disableStopMenuItem();
 
		view.enableStartMenuItem();
 
		model.initialize();
 
	}
 
	
 
	public BeatController(BeatModel model, StrategyView view) {
 
		this.view = view;
 
		this.view.disableStopMenuItem();
 
		this.view.enableStartMenuItem();
 
		this.model = model;
 
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
 
    
 
	public void increaseBPM() {
 
        int bpm = model.getBPM();
 
        model.setBPM(bpm + 1);
 
	}
 
    
 
	public void decreaseBPM() {
 
        int bpm = model.getBPM();
 
        model.setBPM(bpm - 1);
 
  	}
 
  
 
 	public void setBPM(int bpm) {
 
		model.setBPM(bpm);
 
	}
 
 	
 
 	public void setView(DJView view){
 
 		this.view = view;
 
 	}
 
} 

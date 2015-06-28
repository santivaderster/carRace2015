package View;

import Model.BeatModelInterface;

import Controller.ControllerInterface;
 
import View.DJView;
 

 
public class HeartView extends DJView {
 
	
 
	public HeartView(ControllerInterface controller, BeatModelInterface model) {	
 
		super(controller, model);
 
    }
 
	
 
	public void updateBPM() {
 
		if (model != null) {
 
			if (bpmOutputLabel != null) {
 
        			bpmOutputLabel.setText("Numero de Instancias: " + model.getBPM());
 
			}
 
		}
 
	}
 
} 

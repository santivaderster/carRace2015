
package CarRace;

import Beat.BPMObserver;
import Beat.BeatModelInterface;
import Beat.BeatObserver;


public class CarRaceAdapter implements BeatModelInterface {
   
    CarRaceModel car;
 
	
 
	public CarRaceAdapter(CarRaceModel car){
 
		this.car=car;
 
	}
 

 
	public void initialize() {
 
		this.car.initialize();
 
	}
 

 
	public void on() {
 
		this.car.on();		
 
	}
 

 
	public void off() {
 
		this.car.off();
 
	}
 

 
	public void setBPM(int bpm) {
 
		this.car.setfuel(bpm);
 
	}
 

 
	public int getBPM() {
 
		return this.car.getfuel();
 
	}
 

 
	public void registerObserver(BeatObserver o) {
 
		this.car.registerObserver(o);
 
	}
 

 
	public void removeObserver(BeatObserver o) {
 
		this.car.removeObserver(o);
 
	}
 

 
	public void registerObserver(BPMObserver o) {
 
		this.car.registerObserver(o);
 
	}
 

 
	public void removeObserver(BPMObserver o) {
 
		this.car.removeObserver(o);
 
	} 

    

}

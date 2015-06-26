package CarRace;

import Beat.BPMObserver;
import Beat.BeatObserver;

public interface CarRaceModelInterface {

  
	void comenzar();	
	
	void start ();
	void stop ();
   
	void setTamaño ();
    void setPosicionx();
    void setPosiciony();
    int getPosicionx();
    int getPosiciony();
	
    void setDistancia(int distancia);
    
	void registerObserver(BeatObserver o);

	void removeObserver(BeatObserver o);	  

	void registerObserver(BPMObserver o);	  

	void removeObserver(BPMObserver o);


}

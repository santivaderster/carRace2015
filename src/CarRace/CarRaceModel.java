package CarRace;

import javax.sound.midi.*;

import Beat.*;
//import Ca.ModelObserver;


import java.util.*;


public class CarRaceModel implements CarRaceModelInterface, MetaEventListener{

	int xposicion;
	int yposicion;
	
	boolean colicion;
	
	
	
	// Limites de la pista
	
	int pistaX1;
	int pistaX2;
	int pistaY1;
	int pistaY2;
	
	
	
	Autos contra1 ;
	Autos contra2 ; 
	Autos contra3 ;
	Autos contra4 ;
	Autos contra5 ;
	
	Autos miauto ;
	
	
	
	
	
	int fuel ;
	
	
	Sequencer sequencer;
	 
	int bpm = 60;
 
    Sequence sequence;
 
    Track track;
	
	
	ArrayList<BeatObserver> beatObservers;
	 
	ArrayList<BPMObserver> bpmObservers;
 
	ArrayList<ModelObserver> modelObservers;
	
	
	public void CarRaceModel (){
		
		beatObservers = new ArrayList<BeatObserver>();
		bpmObservers = new ArrayList<BPMObserver>();
		modelObservers = new ArrayList<ModelObserver>();
		
		fuel  = 0; 
		colicion =false ;
             
             // Limite de la pista 
                
		 pistaX1 = 80;     //derecha
		 pistaX2 = 480;    //izquierda
		 pistaY1 = 100;    // Arriba
		 pistaY2 = 460;    // abajo
		
	    // Creacion de los Autos 
		 
		 contra1 = new Autos (); // constructos de auto en contramano
		 contra2 = new Autos ();
		 contra3 = new Autos ();
		 contra4 = new Autos ();
		 contra5 = new Autos ();
		
		 miauto = new Autos (1,0);  //  mi auto donde el primer valor es la posicion  X en la pista y el segundo la posicion Y     
		
		
		
		
	}
	
	
	
	public int CargarCombustible (int posicion,int f){
		
	    if  (((miauto.getPosicionx () == 10)||(miauto.getPosicionx () == 50 ))&&(fuel<100)){
	    	
	    	//si se encuentra sobre la posicion de recarga 
	    	
	    	fuel = f + 10;
	    }
	    else 
	    	fuel = f-20; 
		return fuel ;
		
	}
	
	
	
	
	
	public void comenzar() {
	
		 setUpMidi();
		  
	     buildTrackAndStart();
	        
		
	}



    public void on() {
    	 
        sequencer.start();
 
        if(fuel<=100) setBPM(500-44*fuel);
 
		//else setBPM(60);
 
    }
 
    
 
    public void off() {
 
  		setBPM(0);
 
		sequencer.stop();
 
    }
	
	
	
    
    public void setBPM(int bpm) {
    	 
    			this.bpm = bpm;
    	 
    			sequencer.setTempoInBPM(getBPM());
    	 
    			notifyBPMObservers();
    	 
    	    }
    	 
    	  
    	 
    		public int getBPM() {
    	 
    			return bpm;
    	 
    		}
    
    		public void notifyBeatObservers() {
    			 
    			for(int i = 0; i < beatObservers.size(); i++) {
    	 
    				BeatObserver observer = (BeatObserver)beatObservers.get(i);
    	 
    				observer.updateBeat();
    	 
    			}
    	 
    		}
    
    
    		public void notifyBPMObservers() {
    			 
    			for(int i = 0; i < bpmObservers.size(); i++) {
    	 
    				BPMObserver observer = (BPMObserver)bpmObservers.get(i);
    	 
    				observer.updateBPM();
    	 
    			}
    	 
    		}
    	 
    
    
    
    
	
	public void setTamaño(int x , int y ) {
		pistaX = x;
		pistaY = y;  
	}


	public void setPosicionX(int x, int limitex1 ,int limitex2) {
		
	if (x>= limitex1 && x <=limitex2)
            
            xposicion = xposicion + x;

	} 
	
	public void setPosicionY(int y) {
		
          yposicion = y ;
	
        }


	public int getPosicionx() {

		return xposicion ;

	}

	public int getPosiciony() {

		return yposicion ;

	}



	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setTamaño() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setPosicionx() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setPosiciony() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setDistancia(int distancia) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
		
	}


	@Override
	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
		
	}



	@Override
	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		 
		if (i >= 0) {
 
			bpmObservers.remove(i);
 
		}
		
	}
	
	@Override
	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		 
		if (i >= 0) {
 
			beatObservers.remove(i);
 
		}
 
		
	}


	@Override
	public void meta(MetaMessage arg0) {
		// TODO Auto-generated method stub
		
	}


	



}

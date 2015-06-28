package Model;

import Observer.BeatObserver;
import Observer.BPMObserver;
import javax.sound.midi.*;

import Class.Car;
import Observer.CarRaceObserver;
//import Ca.ModelObserver;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CarRaceModel implements CarRaceModelInterface, MetaEventListener
{
    Sequencer sequencer;
    ArrayList<BeatObserver> beatObservers = new ArrayList<BeatObserver>();
    ArrayList<BPMObserver> bpmObservers = new ArrayList<BPMObserver>();
    ArrayList<CarRaceObserver> modelObservers = new ArrayList<CarRaceObserver>();
    int bpm = 0;   // los bpm arranca en 0 el fuel esta lleno 
 
    Sequence sequence;
    Track track;
    Car miauto;
    ArrayList<Car> autosContra = new ArrayList<Car>();
    Thread Tiempo ;
   
//        public CarRaceModel() {
//        beatObservers = new ArrayList<BeatObserver>();
//        bpmObservers = new ArrayList<BPMObserver>();
//       // fuel =10;
//                }
    private int iLimiteXIzquierda = 80;
    private int iLimiteXDerecha = 480;
    private int iLimiteYArriba = 0;
    private int iLimiteYAbajo = 460;
    private int iMovimientoX = 100;
    private int iMovimientoY = 50;
    private int iCantidadCombustible = 1;
    private int iRefrescoAutoContra = 3;
    private int iTamanoAuto = 63;
    private boolean tiempofinalizado=false; 
     
    public CarRaceModel(Car auto, ArrayList<Car> autosContra) {
        beatObservers = new ArrayList<BeatObserver>();
        bpmObservers = new ArrayList<BPMObserver>();
        modelObservers = new ArrayList<CarRaceObserver>();
        this.autosContra = autosContra;
        this.miauto = auto;
        this.miauto.setFuel(10);
        String sColor = null;
        Car oAuto;
         for (int i = 0; i < 5; i++) {
            switch (i)
            {
                case 0:
                    sColor = "Amarillo";
                    break;
                case 1:
                    sColor = "Rojo";
                    break;
                case 2:
                    sColor = "Azul";
                    break;
                case 3:
                    sColor = "Amarillo";
                    break;
                case 4:
                    sColor = "Azul";
                    break;
            }
            oAuto = new Car(i*iMovimientoX + iLimiteXIzquierda,iLimiteYAbajo, sColor,false);
             autosContra.add(oAuto);
             oAuto = null;
         }
     }

    
    
    
    
    
    public void initialize() {
        setUpMidi();
        buildTrackAndStart();
    }

    public void on() 
    {
        sequencer.start();
        setBPM(miauto.getFuel());
        notifyModelObservers("AutoSeleccionado");
        notifyModelObservers("AutosContra");
        Tiempo = new Thread()
        {
            @Override
            public void run() 
            {
                int cant = iRefrescoAutoContra-1;
                super.run(); 
                while (!tiempofinalizado)
                {
                    try 
                    {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) 
                    {
                        System.out.println(ex.getMessage());
                    }
                    cant++;
                    if (miauto.getPosicionx() != iLimiteXIzquierda )//&& miauto.getPosicionx() != iLimiteXDerecha)
                        miauto.setFuel(miauto.getFuel()-1*iCantidadCombustible);
                    else
                    {
                        miauto.setFuel(miauto.getFuel()+1*iCantidadCombustible);
                    }
                    UpdateFuel();
                    if (miauto.getFuel()==0){
                        switch (miauto.getColorSelectionJugador())
                        {
                            case "Amarillo":
                                miauto.setColorSelectionJugador("AmarilloRoto");
                            break;                                            
                            case "Azul":
                                miauto.setColorSelectionJugador("AzulRoto");
                            break;
                            case "Rojo":
                                miauto.setColorSelectionJugador("RojoRoto");
                            break;
                        }
                        notifyModelObservers("AutoSeleccionado");
                        notifyModelObservers("GameOver");
                    }
                    if (cant == iRefrescoAutoContra )
                    {
                        cant = 0;
                        Random oRandom = new Random();
                        int num = (int)(oRandom.nextDouble() * 5 + 0);
                        if (!autosContra.get(num).isVisible())
                        {
                            autosContra.get(num).setVisible(true);
                            autosContra.get(num).setPosiciony(iLimiteYAbajo);
                        }
                    }
                if (detectorChoque()){ //&& miauto.getColorSelectionJugador()!="carRaceTestDrive"){//calculo de choque 
                
                notifyModelObservers("AutoSeleccionado");
                notifyModelObservers("GameOver");
                }
                    for (int i = 0; i < autosContra.size(); i++) {
                        if (autosContra.get(i).isVisible())
                            notifyModelObservers("AutosContra");
                    }
                }
            }   
        };
        Tiempo.start();
    }
    
    public boolean detectorChoque(){
        boolean choque = false;
        for (int i = 0; i < autosContra.size(); i++) {
                            if(autosContra.get(i).isVisible())
                                autosContra.get(i).setPosiciony(autosContra.get(i).getPosiciony()-1*iMovimientoY);
                            if (autosContra.get(i).getPosiciony()<iLimiteYArriba+iTamanoAuto)
                            {
                                autosContra.get(i).setVisible(false);
                                autosContra.get(i).setPosiciony(iLimiteYAbajo);
                                if (miauto.getPosicionx() == autosContra.get(i).getPosicionx())
                                {                                    
                                    switch (miauto.getColorSelectionJugador())
                                    {
                                        case "Amarillo":
                                            miauto.setColorSelectionJugador("AmarilloRoto");
                                        break;                                            
                                        case "Azul":
                                            miauto.setColorSelectionJugador("AzulRoto");
                                        break;
                                        case "Rojo":
                                            miauto.setColorSelectionJugador("RojoRoto");
                                        break;
                                    }
                                   choque=true;
                                }
                            }
                        }
    
    return choque;
    
    
    }
    

    public void off() {
        setBPM(0);
        sequencer.stop();
        tiempofinalizado =true;
    }

    public void setBPM(int bpm) {
        this.bpm = bpm;
        sequencer.setTempoInBPM(getBPM());
        notifyBPMObservers();
    }

    public int getBPM() {
        return bpm;
    }

    void beatEvent() {
        notifyBeatObservers();
    }

    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    public void registerObserver(CarRaceObserver o) {
        modelObservers.add(o);
    }
    
    public void notifyBPMObservers() {
        for (int i = 0; i < bpmObservers.size(); i++) {
            BPMObserver observer = (BPMObserver) bpmObservers.get(i);
            observer.updateBPM();
        }
    }

    public void notifyBeatObservers() {
        for (int i = 0; i < beatObservers.size(); i++) {
            BeatObserver observer = (BeatObserver) beatObservers.get(i);
            observer.updateBeat();
        }
    }
    
    public void notifyModelObservers(String sAccion) {
        for (int i = 0; i < modelObservers.size(); i++) {
            CarRaceObserver observer = (CarRaceObserver) modelObservers.get(i);
            switch(sAccion){
                case "AutoMover":
                    observer.updateAuto(miauto.getPosicionx());
                    break;
                case "AutosContra":
                   observer.updateAutosContra();
                    break;
                case "Auto2Mover":
                    break;
                case "Auto3Mover":
                    break;
                case "Auto4Mover":
                    break;
                case "Auto5Mover":
                    break;
                case "AutoSeleccion":
                    observer.updateAutoSeleccion(miauto.getColorSelectionJugador());
                    break;
                case "AutoSeleccionado":
                    observer.updateAutoSeleccionJugador();
                    break;
                case "updateFuel":
                    observer.setfuel(miauto.getFuel());
                    break;
                case "todo":
                    observer.setfuel(miauto.getFuel());
                    observer.updateAuto(miauto.getPosicionx());
                    //falta el update de todos los autos de contramano
                    observer.updateAutoSeleccion(miauto.getColorSelectionJugador());
                    break;
                case "GameOver":
                    observer.updateestado("GameOver");
                        break;
            }
        }
    }
    
    public void removeObserver(BeatObserver o) {
        int i = beatObservers.indexOf(o);
        if (i >= 0) {
            beatObservers.remove(i);
        }
    }

    public void removeObserver(BPMObserver o) {
        int i = bpmObservers.indexOf(o);
        if (i >= 0) {
            bpmObservers.remove(i);
        }
    }
    
    public void removeObserver(CarRaceObserver o) {
        int i = modelObservers.indexOf(o);
        if (i >= 0) {
            modelObservers.remove(i);
        }
    }

    public void meta(MetaMessage message) {
        if (message.getType() == 0x2F) {
            beatEvent();
            sequencer.setTickPosition(0);
            sequencer.start();
            setBPM(getBPM());
        }
    }

    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addMetaEventListener(this);
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(getBPM());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildTrackAndStart() {
        int[] trackList = {80, 0, 0, 0};
        sequence.deleteTrack(null);
        track = sequence.createTrack();
        makeTracks(trackList);
        track.add(makeEvent(192, 9, 1, 0, 4));
        try {
            sequencer.setSequence(sequence);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeTracks(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int key = list[i];
            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 1));
            }
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

    // Metodos propios del Modelo 

 public int getFuel(){
  return  miauto.getFuel();
  }

   public void UpdateFuel() {
        setBPM(-(-400 + 40 * miauto.getFuel()));
        notifyModelObservers("updateFuel");
    }

    @Override
    public void FlechaIzquierda() 
    {
        switch(miauto.getColorSelectionJugador())
        {
            case "Amarillo":
                miauto.setColorSelectionJugador("Rojo");
                break;
            case "Rojo":
                miauto.setColorSelectionJugador("Azul");
                break;
            case "Azul":
                miauto.setColorSelectionJugador("Amarillo");
                break;
        }
        notifyModelObservers("AutoSeleccion");
    }

    @Override
    public void FlechaDerecha() 
    {
        switch(miauto.getColorSelectionJugador())
        {
            case "Amarillo":
                miauto.setColorSelectionJugador("Azul");
                break;
            case "Rojo":
                miauto.setColorSelectionJugador("Amarillo");
                break;
            case "Azul":
                miauto.setColorSelectionJugador("Rojo");
                break;
        }
        notifyModelObservers("AutoSeleccion");
    }

    @Override
    public void setPosicionX(int v) 
    {
        if (v> 0)
        {
            if(miauto.getPosicionx()<iLimiteXDerecha)
                miauto.setPosicionx(miauto.getPosicionx()+v*iMovimientoX);
        }
        else
        {
            if(miauto.getPosicionx()>iLimiteXIzquierda)
                miauto.setPosicionx(miauto.getPosicionx()+v*100);
        }
        notifyModelObservers("AutoMover");
    }
}

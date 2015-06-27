package CarRace;

import javax.sound.midi.*;

import Beat.*;
//import Ca.ModelObserver;


import java.util.*;


public class CarRaceModel implements CarRaceModelInterface, MetaEventListener
{
    Sequencer sequencer;
    ArrayList<BeatObserver> beatObservers = new ArrayList<BeatObserver>();
    ArrayList<BPMObserver> bpmObservers = new ArrayList<BPMObserver>();
    ArrayList<ModelObserver> modelObservers = new ArrayList<ModelObserver>();
    int bpm = 0;   // los bpm arranca en 0 el fuel esta lleno 
 
    Sequence sequence;
    Track track;
    Autos miauto;
     ArrayList<Autos> autosContra = new ArrayList<Autos>();
     
   
//        public CarRaceModel() {
//        beatObservers = new ArrayList<BeatObserver>();
//        bpmObservers = new ArrayList<BPMObserver>();
//       // fuel =10;
//                }
     
     
     public CarRaceModel(Autos auto) {
        beatObservers = new ArrayList<BeatObserver>();
        bpmObservers = new ArrayList<BPMObserver>();
        modelObservers = new ArrayList<ModelObserver>();
        this.miauto = auto;
        this.miauto.setFuel(10);
     }

    
    
    
    
    
    public void initialize() {
        setUpMidi();
        buildTrackAndStart();
    }

    public void on() {
        sequencer.start();
        setBPM(10);
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

    void beatEvent() {
        notifyBeatObservers();
    }

    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    public void registerObserver(ModelObserver o) {
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
            ModelObserver observer = (ModelObserver) modelObservers.get(i);
            switch(sAccion){
                case "AutoMover":
                    //observer.updateAuto(Integer.parseInt(update));
                    break;
                case "Auto1Mover":
                   // observer.updateAutoContramano1(Integer.parseInt(update), true);
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
                case "updateFuel":
                    observer.setfuel(miauto.getFuel());
                    break;
                case "todo":
                    observer.setfuel(miauto.getFuel());
                    observer.updateAuto(miauto.getPosicionx());
                    //falta el update de todos los autos de contramano
                    observer.updateAutoSeleccion(miauto.getColorSelectionJugador());
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
    
    public void removeObserver(ModelObserver o) {
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

   public void setfuel(int f) {
        if (f >= 0 &&  f<=10) {
            miauto.setFuel(f);
            if (miauto.getFuel() <= 9) {
                setBPM(-(-400 + 40 * miauto.getFuel()));
                notifyModelObservers("updateFuel");
               
            }
        }
    }

    @Override
    public void FlechaIzquierda(String sIconoActual) 
    {
        switch(sIconoActual)
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
    public void FlechaDerecha(String sIconoActual) 
    {
        switch(sIconoActual)
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
}

package CarRace;

import Beat.BPMObserver;
import Beat.BeatObserver;

public interface CarRaceModelInterface 
{
    void initialize();
    void on();  
    void off();
    void setBPM(int bpm);
    int getBPM();
    void registerObserver(ModelObserver o);
    void removeObserver(ModelObserver o);
    void registerObserver(BPMObserver o);
    void removeObserver(BPMObserver o);
    void FlechaIzquierda();
    void FlechaDerecha();
    void setPosicionX(int v);
}

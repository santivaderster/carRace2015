package Model;

import Observer.BPMObserver;
import Observer.BeatObserver;
import Observer.CarRaceObserver;

public interface CarRaceModelInterface 
{
    void initialize();
    void on();  
    void off();
    void setBPM(int bpm);
    int getBPM();
    void registerObserver(CarRaceObserver o);
    void removeObserver(CarRaceObserver o);
    void registerObserver(BPMObserver o);
    void removeObserver(BPMObserver o);
    void FlechaIzquierda();
    void FlechaDerecha();
    void setPosicionX(int v);
}

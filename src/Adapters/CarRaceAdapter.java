
package Adapters;

import Model.CarRaceModel;
import Observer.BPMObserver;
import Model.BeatModelInterface;
import Observer.BeatObserver;

/**
 *
 * @author Santiago
 */
public class CarRaceAdapter implements BeatModelInterface {
   
    CarRaceModel car;

    public CarRaceAdapter(CarRaceModel car) {
        this.car = car;
    }

    @Override
    public void initialize() {
        this.car.initialize();
    }

    @Override
    public void on() {
        this.car.on();
    }

    @Override
    public void off() {
        this.car.off();
    }

    @Override
    public void setBPM(int f) {
        this.car.UpdateFuel();
    }

    @Override
    public int getBPM() {
        return this.car.getFuel();
    }

    @Override
    public void registerObserver(BeatObserver o) {
        this.car.registerObserver(o);
    }

    @Override
    public void removeObserver(BeatObserver o) {
        this.car.removeObserver(o);
    }

    @Override
    public void registerObserver(BPMObserver o) {
        this.car.registerObserver(o);
    }

    @Override
    public void removeObserver(BPMObserver o) {
        this.car.removeObserver(o);
    }
}

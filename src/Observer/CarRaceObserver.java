package Observer;

public interface CarRaceObserver 
{
    void setfuel(int i);
    void updateAuto(int posX);
    void updateestado(String estado);
    void updateAutoSeleccion(String sIconoActual);
    void updateAutoSeleccionJugador();
    void updateAutosContra();
} 

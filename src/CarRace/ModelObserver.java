package CarRace;

public interface ModelObserver 
{
    void setfuel(int i);
    void getfuel ();
    void updateAuto(int posX);
    void updateestado(String estado);
    void updateAutoSeleccion(String sIconoActual);
    void updateAutoSeleccionJugador();
    void updateAutosContra();
} 

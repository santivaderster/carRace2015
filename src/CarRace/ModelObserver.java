package CarRace;

public interface ModelObserver 
{
    void setfuel(int i);
    void getfuel ();
    void updateAuto(int posX);
    void updateestado(String estado);
    void updateAutoSeleccion(String sIconoActual);
    void updateAutoSeleccionJugador(String sIconoActual);
    void updateAutosContra();
    void updateAutoContramano2(int posY,boolean estado);
    void updateAutoContramano3(int posY,boolean estado);
    void updateAutoContramano4(int posY,boolean estado);
    void updateAutoContramano5(int posY,boolean estado);
} 

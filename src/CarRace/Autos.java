package CarRace;

import java.util.Random;

public class Autos {

    private int posicionx;
    private int posiciony;
    private String colorSelectionJugador ;
    private boolean visible;
    private int fuel ;
    

    public Autos( int x , int y , String color) {
        fuel = 10;
        posicionx = x; // genera posicion x aleatoria de autos en contramano
        posiciony = y;  //  colocar la posicion de donde arranca los autos en contra mano 
        colorSelectionJugador = color;
    
    }

    public String getColorSelectionJugador() {
        return colorSelectionJugador;
    }

    public void setColorSelectionJugador(String colorSelectionJugador) {
        this.colorSelectionJugador = colorSelectionJugador;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

 

    public int getPosicionx() {
        return posicionx;
    }

    public void setPosicionx(int posicionx) {
        this.posicionx = posicionx;
    }

    public int getPosiciony() {
        return posiciony;
    }

    public void setPosiciony(int posiciony) {
        this.posiciony = posiciony;
    }

}
	
	


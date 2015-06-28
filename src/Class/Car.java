package Class;

import java.util.Random;

public class Car {

    private int posicionx;
    private int posiciony;
    private String colorSelectionJugador ;
    private boolean visible;
    private int fuel ;
    private int maxFuel = 10;

    public Car( int x , int y , String color, boolean visible) {
        fuel =maxFuel;
        posicionx = x; // genera posicion x aleatoria de autos en contramano
        posiciony = y;  //  colocar la posicion de donde arranca los autos en contra mano 
        colorSelectionJugador = color;
        this.visible = visible;
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

    public void setFuel(int fuel) 
    {
        if (fuel<=maxFuel && fuel >= 0)
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
	
	


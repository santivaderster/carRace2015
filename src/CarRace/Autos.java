package CarRace;

import java.util.Random;

public class Autos {

	int posicionx;
	int posiciony;
	
	
	
	

	public Autos ( ){
		
		Random pos = new Random();
		
		posicionx = pos.nextInt(50); // genera posicion x aleatoria de autos en contramano
		
		posiciony = 70 ;  //  colocar la posicion de donde arranca los autos en contra mano 
	     	
	 
	}
	
	
	public Autos ( int x, int y){
		
		posicionx =x;
		posiciony = y;
		
		
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
	
	


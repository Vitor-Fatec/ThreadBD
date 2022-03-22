package view;

import java.util.concurrent.Semaphore;

import controller.ThreadBD;

public class MainBD {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
	
		for(int idThread = 0; idThread < 21; idThread++ ) {
			Thread bd = new ThreadBD((idThread+1), semaforo);
			bd.start();
		}

	}

}

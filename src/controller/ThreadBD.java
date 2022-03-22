package controller;

import java.util.concurrent.Semaphore;

public class ThreadBD extends Thread {

	private int idThread;
	private Semaphore semaforo;

	public ThreadBD(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
		
	}

	@Override
	public void run() {
		if (idThread % 3 == 1) {
			calcResto1();
		}
		if (idThread % 3 == 2) {
			CalcResto2();
		}
		if(idThread % 3 == 0) {
			CalcResto0();
		}
	}

	private void calcResto1() {
		int tempo = 1000;
		
		System.out.println("Fazendo os cálculos.... Calculos com Resto 1\"");
		try {
			sleep((int) (Math.random() * 201) + 800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
// ===========================SEÇÃO CRITICA =========================================		
		try {
			semaforo.acquire();
			System.out.println("Transações para o BD.... Calculos com Resto 1");
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			semaforo.release();
		}
// ===================================================================================		}

		//if (idThread % 3 == 0) {
			//System.out.println("Olá Mundo 0  " + idThread);
		//}

	}
	
	private void CalcResto2() {
		int tempo = 1500;
		
		System.out.println("Fazendo os cálculos.... Calculos com Resto 2\"");
		try {
			sleep((int) (Math.random() * 501) + 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
// ===========================SEÇÃO CRITICA =========================================		
		try {
			semaforo.acquire();
			System.out.println("Transações para o BD.... Calculos com Resto 2\"");
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			semaforo.release();
		}
	}
	
	private void CalcResto0() {
		
		int tempo = 1500;
		
		System.out.println("Fazendo os cálculos.... Calculos com Resto 0");
		try {
			sleep((int) (Math.random() * 1001 ) + 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
// ===========================SEÇÃO CRITICA =========================================		
		try {
			semaforo.acquire();
			System.out.println("Transações para o BD.... Calculos com Resto 0");
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			semaforo.release();
		}
	}
}

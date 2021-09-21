package domain;

public class ThreadAccelerarFrenar extends Thread{
Propulsor propulsor; 
int acceleracio; 
public ThreadAccelerarFrenar(Propulsor propulsor, int acceleracio) {
	this.propulsor = propulsor; 
	this.acceleracio = acceleracio; 
}
	@Override
	public void run() {
		while(propulsor.getPotenciaAct()!=propulsor.getPotenciaObj()) {
			
			try{sleep(500);} catch (Exception e) {	}
			
			if (propulsor.getPotenciaAct()>propulsor.getPotenciaObj()) {
				if((propulsor.getPotenciaAct()-propulsor.getPotenciaObj())<acceleracio) {
					propulsor.setPotenciaAct(propulsor.getPotenciaObj());
				} else {
				propulsor.setPotenciaAct(propulsor.getPotenciaAct()-acceleracio);
				}
			}
			else if(propulsor.getPotenciaAct()<propulsor.getPotenciaObj()) {
				if((propulsor.getPotenciaObj()-propulsor.getPotenciaAct())<acceleracio) {
					propulsor.setPotenciaAct(propulsor.getPotenciaObj());
				} else {
				propulsor.setPotenciaAct(propulsor.getPotenciaAct()+acceleracio);
				}
			}

			System.out.println(propulsor.getIdNum() + " " + propulsor.stringEstat());
			
			if(propulsor.getPotenciaAct() == propulsor.getPotenciaObj()) {
				System.out.println("El " + propulsor.getIdNum() + " ha arribat a la potencia objectiu");
			}
		}
}
}

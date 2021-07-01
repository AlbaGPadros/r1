
public class M2N3 {
int hour = 0;
int minute = 0; 
int second = 0;

public void iniciaCronometre() {
	System.out.println("Cronometre");
	try {
		while(1==1) { //condició que sempre és certa perquè no es deixi d'executar en fer una hora. 
			//Quan hi ha 60 minuts, inicia minuts a 0 i suma 1 hora. 
			while (minute<60) { 
				//Quan hi ha 60 segons inicia segons a 0 i suma 1 minut.
				while(second<60) {
					//imprimeix en el format 00:00:00
					System.out.printf("%02d",hour);
					System.out.print(":");
					System.out.printf("%02d",minute);
					System.out.print(":");
					System.out.printf("%02d",second);
					System.out.println("");
					Thread.sleep(1000);
					second++;
				}
			second = 0;
			minute++;	
		}
		minute=0;
		hour++;
		}
	} catch (InterruptedException e) {
		System.out.println("Hi ha hagut un error!");
		e.printStackTrace();
	} 
}
}

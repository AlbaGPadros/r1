import java.util.ArrayList;
import java.util.Random;


@FunctionalInterface
interface getPi
{
    double getPiValue();
}


public class N1 {
	
	
	public void Ex1() {
		System.out.println("Exercici 1.-");
	    ArrayList<String> noms = new ArrayList<String>();
	    noms.add("Teresa");
	    noms.add("Helena");
	    noms.add("Ana");
	    noms.add("Ari");
	    noms.add("Pol");
	    
	    noms.forEach( (n) -> { if( (n.length()==3)&& (String.valueOf(n.charAt(0)).equals("A"))){ 
	    						System.out.println(n);} } );
	}
	
	public void Ex2() {					
		System.out.println("\n\n" + "Exercici 2.-");
		
		Random random = new Random(); 
		String output =""; 
		ArrayList<Integer> nombres = new ArrayList<Integer>();
		for (int i= 0; i < 10; i++) {
			nombres.add(random.nextInt(100));
		}
		
	    nombres.forEach( n -> {
						    	if (n%2 == 0) {	 	    		
					 	    		System.out.print("o"+n.valueOf(n) + ", ");}
					 	    	else{
					 	    		System.out.print("e"+n.valueOf(n) + ", ");}
						    	});
	}
	
	public void Ex3() {
		System.out.println("\n\n" + "Exercici 3, Exercici 4.-");
		
		Random random = new Random(); 
		Random random2 = new Random(); 
		String caracters ="abcdefghijklmnopqrstuvwxyz";
		String paraulaRand= "";
		ArrayList<String> stringsRand = new ArrayList<String>();

		for(int i=0; i<10; i++) {
			paraulaRand="";
			for (int j=0; j<(random2.nextInt(10)+1); j++){
			char caracterAleatori = caracters.charAt(random.nextInt(caracters.length())); 
			paraulaRand = String.valueOf(caracterAleatori) + paraulaRand; 
			}
			stringsRand.add(paraulaRand);
		}
		System.out.print("Strings amb o: ");
	    stringsRand.forEach( n -> { if(n.contains("o")){ 
	    								System.out.print(n + " ");
	    							}
		 } );
		System.out.print("\nStrings de més de 5 caràcters: ");

	    stringsRand.forEach(n->{ if(n.length()>5) {
	    							System.out.print(n + " ");
	    							}
	    						});
	}
	
	public void Ex5() {
		System.out.println("\n\n" + "Exercici 5, Exercici 6.-");
		ArrayList <String> mesos = new ArrayList<String>();
		mesos.add("Gener");
		mesos.add("Febrer");
		mesos.add("Març");
		mesos.add("Abril");
		mesos.add("Maig");
		mesos.add("Juny");
		mesos.add("Juliol");
		mesos.add("Agost");
		mesos.add("Setembre");
		mesos.add("Octubre");
		mesos.add("Novembre");
		mesos.add("Desembre");
		
		System.out.println("Lambda: ");
		mesos.forEach(n -> System.out.println(n));
		System.out.println("\nReference: ");
		mesos.forEach(System.out::println);
	}
	
	public void Fase2() {
		System.out.println("\n\n" + "GetPi:");
		getPi getPiValueLambda = ()-> 3.14159265359;
		System.out.println(getPiValueLambda.getPiValue());
	}
	
}

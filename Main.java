import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int pokemon, evolve, candy, chosen, chosenE, adEv=0, pKill=0;
		
		System.out.print("How many of the Pok�mon do you have?: ");
		pokemon = scn.nextInt();
		
		System.out.print("How much candy to evolve the Pok�mon?: ");
		evolve = scn.nextInt();
		
		System.out.print("How much candy do you currently have?: ");
		candy = scn.nextInt();
		scn.close();
		
		chosen = (candy/evolve > pokemon) ? pokemon : (candy/evolve);
		System.out.println("\nYou will be able to evolve " + chosen + " Pok�mon!");
		
		//Remove used candy and evolved pok�mon
		candy = candy - (chosen * evolve);
		pokemon = pokemon - chosen;		
		
		
		if (pokemon > 1 && (pokemon - 1 + candy) >= evolve) { //Is there enough candy to evolve a pokemon if we kill all but 1
											   
			do {
				//Kill a pok�mon to get one candy
				pokemon--; pKill++;
				candy++;
				
				//Check if we have enough evolve 
				if (candy == evolve) {
					pokemon--; //Remove one pokemon, it's now Evolved
					adEv++; //Increment adEv, we now have one more Additional Evolved Pok�mon
					candy = 0; //Set candy to 0 as we just hit evolve amount of candies and used them to Evolve a Pok�mon
				}
			} while ((pokemon > 1 && (pokemon - 1 + candy) >= evolve));
			
			System.out.println("\nIf you kill " + pKill + " Pok�mon you'll be able to evolve " + adEv + " more Pok�mon!");
		}
		
		System.out.println("There is " + pokemon + " Pok�mon and " + candy + " candy left!");
	}
}

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int pokemon, evolve, candy, chosen, chosenE, adEv=0, pKill=0;
		
		System.out.print("How many of the Pokémon do you have?: ");
		pokemon = scn.nextInt();
		
		System.out.print("How much candy to evolve the Pokémon?: ");
		evolve = scn.nextInt();
		
		System.out.print("How much candy do you currently have?: ");
		candy = scn.nextInt();
		scn.close();
		
		chosen = (candy/evolve > pokemon) ? pokemon : (candy/evolve);
		System.out.println("\nYou will be able to evolve " + chosen + " Pokémon!");
		
		//Remove used candy and evolved pokémon
		candy = candy - (chosen * evolve);
		pokemon = pokemon - chosen;		
		
		
		if (pokemon > 1 && (pokemon - 1 + candy) >= evolve) { //Is there enough candy to evolve a pokemon if we kill all but 1
											   
			do {
				//Kill a pokémon to get one candy
				pokemon--; pKill++;
				candy++;
				
				//Check if we have enough evolve 
				if (candy == evolve) {
					pokemon--; //Remove one pokemon, it's now Evolved
					adEv++; //Increment adEv, we now have one more Additional Evolved Pokémon
					candy = 0; //Set candy to 0 as we just hit evolve amount of candies and used them to Evolve a Pokémon
				}
			} while ((pokemon > 1 && (pokemon - 1 + candy) >= evolve));
			
			System.out.println("\nIf you kill " + pKill + " Pokémon you'll be able to evolve " + adEv + " more Pokémon!");
		}
		
		System.out.println("There is " + pokemon + " Pokémon and " + candy + " candy left!");
	}
}

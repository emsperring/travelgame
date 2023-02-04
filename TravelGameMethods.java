import java.util.*;

public class TravelGameMethods {
	private static Scanner keyboard = new Scanner(System.in);
	private static int score = 0;
	private static Fact[] factList = { 
			new Fact("Italy has a free public wine fountain", "T"),
			new Fact("China is the largest country landwise", "F"),
			new Fact("China has the largest population", "T"),
			new Fact("There are only around 10 remaining fluent speakers of Ongota", "T"),
			new Fact("Glaciers and ice sheets hold about 69 percent of the world\"s freshwater.", "T"),
			new Fact("Rainbows occur most frequently in Iceland.", "F"),
			new Fact("There are fossilized plants in Greenland under 1.4 km of ice.", "T"),
			new Fact("New creatures have been found in deep-sea volcanoes.", "T"),
			new Fact("Mount Everest is shinking an inch in size every year", "F"),
			new Fact("North Korea and Cuba are the only places you can\"t buy Coca-Cola.", "T"),
			new Fact("Twins are more commonly found in Italy.", "F"),
			new Fact("More people visit Austrailia than any other country.", "F"),
			new Fact("The world's smallest island is the size of two soccer fields.", "F"),
			new Fact("The Canary Islands are named after dogs.", "T"),
			new Fact("The one of the world's quietest rooms is located at Microsoft\"s headquarters.", "T"),
			new Fact("Japan is the world's most earthquake-prone country.", "T"),
			new Fact("James is the most popular name in the world.", "F")
		};

	public static void main(String[] args) {
		start();
	}

	public static void start() {
			System.out.println("Welcome to RANDOM FACTS! \nThis is a text based game where we tell you a fact and answer T for true or F for false."
					+"\nType E to Exit");
			play();
	}
	
	private static void question(String userAnswer, String answer) {
		userAnswer = userAnswer.trim();
		if (userAnswer.equalsIgnoreCase("e")) {
			System.out.println("Goodbye.");
			System.exit(1);
		} else if (userAnswer.equalsIgnoreCase(answer)) {
			score += 10;
			System.out.println("That is correct! Your score is now " + score);
		} else {
			System.out.println("That is WRONG. NEXT QUESTION!");
		}
	}
		
	private static void play() {
		for(int i = 0; i < factList.length; i++) {
			System.out.println(factList[i].fact);
			String userAnswer = keyboard.nextLine();
			question(userAnswer, factList[i].answer);
		}
		System.out.print("Thank you for playing!");
	}
	
}

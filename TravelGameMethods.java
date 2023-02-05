import java.util.*;

public class TravelGameMethods {
	private static Scanner keyboard = new Scanner(System.in);
	private static int score = 0;
    private static boolean exited = false;
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
        System.out.println("Welcome!");
        choice();

	}

    private static void choice() {
        exited = false;
        System.out.println("Type 0 to quit, 1 to play RANDOM FACTS, or 2 for CITY LIFE LEVELS.");
        int choice = keyboard.nextInt();
        String answer = keyboard.nextLine();
        boolean decided = false;
        while (!decided) {
            if (choice == 1) {
                decided = true;
                startFacts();
            } else if (choice == 2) {
                decided = true;
                startCity();
            } else if (choice == 0) {
                System.out.println("Goodbye!");
                System.exit(0);
            } else {
                System.out.println("invalid option: select 1 or 2");
            } //if
        } //while
    } //choice

    public static void startCity() {
        System.out.println("Welcome to CITY LIFE LEVELS!");
        System.out.println("This is a text based game.");
        System.out.println("First, enter the name of a city, then guess its average quality of life");
        System.out.println("If you are within 10, you earn 10 points. If you are within 5, you earn 20 points");

        boolean cityFound = false;
        while (!cityFound) {
            System.out.println("Enter a city or exit (e):");
            String city = keyboard.nextLine();
            if (LocationQuiz.request(city) >= 0) {
                cityFound = true;
                cityGuess(LocationQuiz.request(city));
            } else {
                System.out.println("invalid city name: " + city);
            } //if
        } //while
    } //startCity

    public static void cityGuess(int value) {
        System.out.println("Enter your predicted city score:");
        int guess = keyboard.nextInt();
        System.out.println("Correct answer: " + value);
        if (Math.abs(guess - value) <= 5) {
            score += 20;
        } else if (Math.abs(guess - value) <= 10) {
            score += 10;
        }
        System.out.println("Your score is now " + score);
        choice();
    } //cityGuess


	public static void startFacts() {
			System.out.println("Welcome to RANDOM FACTS! \nThis is a text based game where we tell you a fact and answer T for true or F for false."
					+"\nType E to Exit");
			play();
	}

	private static void question(String userAnswer, String answer) {
		userAnswer = userAnswer.trim();
		if (userAnswer.equalsIgnoreCase("e")) {
            exited = true;
            choice();
		} else if (userAnswer.equalsIgnoreCase(answer)) {
			score += 10;
			System.out.println("That is correct! Your score is now " + score);
		} else {
			System.out.println("That is WRONG. NEXT QUESTION!");
		}
	}

	private static void play() {
		for(int i = 0; i < factList.length; i++) {
            if (!exited) {
                System.out.println(factList[i].fact);
                String userAnswer = keyboard.nextLine();
                question(userAnswer, factList[i].answer);
            } //if
		}
		System.out.print("Thank you for playing!");
	}

}

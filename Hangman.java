import java.io.File;
import java.util.Scanner;
import java.util.Random;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;



public class Hangman {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        System.out.println("Hangman Game!");
        System.out.println("1 or 2 players?");
        String players = input.nextLine();
        String word;

        if (players.equals("1")) {
            Scanner scanner = new Scanner(new File("dictionary.txt"));
            List<String> words = new ArrayList<>();

            while (scanner.hasNext()) {
                words.add(scanner.nextLine());
            }
            Random rand = new Random();
            word = words.get(rand.nextInt(words.size()));
        }
        else {
            System.out.println("Player 1, please enter your word:");
            word = input.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Ready for player 2!");
        }

        List<Character> playerGuesses = new ArrayList<>();

        int wrongCount = 0;

        while(true) {
            printHangman(wrongCount);

            if (wrongCount >= 6) {
                System.out.println("Sorry! You lose!");
                System.out.println("The word was: " + word);
                break;
            }

            printWordStatus(word, playerGuesses);
            if (!getGuess(input, word, playerGuesses)) {
                wrongCount++;
            }

            if(printWordStatus(word, playerGuesses)) {
                System.out.println("You win!");
                break;
            }
        }
    }
    private static void printHangman(Integer wrongCount) {

        System.out.println(" ---------");
        System.out.println(" |       |");
        System.out.println(" |");
        System.out.println(" |");
        System.out.println(" |");
        System.out.println(" |");
        System.out.println(" |");
        System.out.println(" |");

        if (wrongCount >= 1) {
            System.out.println(" ---------");
            System.out.println(" |       |");
            System.out.println(" |       O");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
        }

        if (wrongCount >= 2) {
            System.out.println(" ---------");
            System.out.println(" |       |");
            System.out.println(" |       O");
            System.out.println(" |      \\ ");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
        }

        if (wrongCount >= 3) {
            System.out.println(" ---------");
            System.out.println(" |       |");
            System.out.println(" |       O");
            System.out.println(" |      \\ /");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
        }

        if (wrongCount >= 4) {
            System.out.println(" ---------");
            System.out.println(" |       |");
            System.out.println(" |       O");
            System.out.println(" |      \\ /");
            System.out.println(" |       | ");
            System.out.println(" |");
            System.out.println(" |");
        }

        if (wrongCount >= 5) {
            System.out.println(" |");
            System.out.println(" ---------");
            System.out.println(" |       |");
            System.out.println(" |       O");
            System.out.println(" |      \\ /");
            System.out.println(" |       | ");
            System.out.println(" |      /  ");
            System.out.println(" |");
        }
        if (wrongCount >= 6) {
            System.out.println(" ---------");
            System.out.println(" |       |");
            System.out.println(" |       O");
            System.out.println(" |      \\ /");
            System.out.println(" |       | ");
            System.out.println(" |      / \\");
        }
    }
    private static boolean getGuess(Scanner keyboard, String word, List<Character> playerGuesses) {
        System.out.println("Please enter a letter:");
        String letterGuess = keyboard.nextLine();
        playerGuesses.add(letterGuess.charAt(0));
        return word.contains(letterGuess);
    }
    private static boolean printWordStatus(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            }
            else {
                System.out.print("-");
            }
        }
        System.out.println();

        return (word.length() == correctCount);
    }
}














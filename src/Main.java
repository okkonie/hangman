import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Hangman x = new Hangman(new WordList("words.txt"), 5);

            Scanner sc = new Scanner(System.in);

            while(!x.theEnd()){
                System.out.print(
                    "\nThe hidden word... \n\n" + x.wordString()
                    + "\n\nGuesses left: " + x.guessesLeft()
                    + "\nGuessed letters: " + x.guessesString()
                    + "\n\nGuess letter: "
                );
                x.guess(sc.next().charAt(0));
            }

            sc.close();

            if(x.wordString().contains("*")){
                System.out.println("\nSorry, you lost!\nThe hidden word was: \"" + x.word() + "\"");
            } else {
                System.out.println("\nCongratulations! You won!!!\nThe hidden word was: \"" + x.word() + "\"");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IllegalArgumentException e) {
            System.out.println("Words not found");
        } 
    }
}
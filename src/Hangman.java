import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hangman {
    private final String word;
    private int guessesLeft;
    private List<Character> guesses = new ArrayList<Character>();

    Hangman(WordList words, int guesses){
        word = getRandomWord(words);
        guessesLeft = guesses;
    }

    private String getRandomWord(WordList words){
        int count = words.giveWords().size();
        int wordIndex = new Random().nextInt(count);
        return words.giveWords().get(wordIndex);
    }

    public boolean guess(Character c){
        boolean guessed = false;
        char lowC = Character.toLowerCase(c);

        for(char ch : guesses()){
            if(lowC == ch) guessed = true;
        }

        if(!guessed) guesses.add(lowC);

        for(int i = 0; i < word.length(); i++){
        if(lowC == Character.toLowerCase(word.charAt(i))){
            return true;
        };
        }

        if(guessesLeft > 0) guessesLeft--;
        return false;
    }

    public List<Character> guesses(){
        return guesses;
    }

    public String guessesString(){
        String s = "[";

        for(int i = 0; i < guesses.size(); i++){
        if(i == guesses.size() - 1){
            s += guesses.get(i);
        } else {
            s += guesses.get(i) + ", ";
        }
        }

        s += "]";

        return s;
    }

    public String wordString(){
        String s = "";

        for(int i = 0; i < word().length(); i++){
        if(guesses.contains(Character.toLowerCase(word.charAt(i)))){
            s += word.charAt(i) + " ";
        } else {
            s += "* ";
        }
        }

        return s;
    }

    public int guessesLeft(){
        return guessesLeft;
    }

    public String word(){
        return word;
    }

    public boolean theEnd(){

        for(int i = 0; i < word.length(); i++){
        boolean isGuessed = false;

        if(guesses.contains(Character.toLowerCase(word.charAt(i)))){
            isGuessed = true;
        }

        if(!isGuessed && guessesLeft > 0) return false;
        }

        return true;
    }
}

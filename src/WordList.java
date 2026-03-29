import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordList {
  private List<String> words = new ArrayList<String>();

  WordList(String fileName) throws FileNotFoundException {
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    while (sc.hasNextLine()) {
        String word = sc.nextLine();
        words.add(word);
    }

    sc.close();
  }

  private WordList(List<String> words) throws IllegalArgumentException {
    this.words = new ArrayList<String>(words);
  }

  public List<String> giveWords(){
    return words;
  }

  public WordList theWordsOfLength(int length){
    List<String> filtered = new ArrayList<String>();

    for (String word : giveWords()) {
      if (word.length() == length) {
        filtered.add(word);
      }
    }

    return new WordList(filtered);
  }

  public WordList theWordsWithCharacters(String someString){
    List<String> filtered = new ArrayList<String>();

    for (String word : giveWords()){
      boolean matches = word.length() == someString.length();

      if(matches){
        for(int i = 0; i < word.length(); i++){
            if(
                someString.charAt(i) != '_' &&
                someString.charAt(i) != word.charAt(i)
            ){
                matches = false;
                break;
            }
        }
      }

      if(matches) filtered.add(word);
    }

    return new WordList(filtered);
  }
}

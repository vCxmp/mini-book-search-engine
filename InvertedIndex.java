import java.util.*;

public class InvertedIndex {
    public static void main(String[] args) {
        List<Media> docs = List.of(
            new Book("Mistborn", List.of("Brandon Sanderson"),
                     new Scanner("Epic fantasy worldbuildling content")),
            new Book("Farenheit 451", List.of("Ray Bradbury"),
                     new Scanner("Realistic \"sci-fi\" content")),
            new Book("The Hobbit", List.of("J.R.R. Tolkein"),
                     new Scanner("Epic fantasy quest content"))
        );
        
        Map<String, Set<Media>> result = createIndex(docs);
        System.out.println(docs);
        System.out.println();
        System.out.println(result);
    }

    // TODO: Write and document your createIndex method here
    public static Map<String, Set<Media>> createIndex(List<Media> docs) {
        Map<String, Set<Media>> answer = new TreeMap<>();
        for (Media titles: docs) {
            List<String> words = titles.getContent();
            for (String word: words) {
                String refinedWord = word.toLowerCase();
                if (answer.containsKey(refinedWord)) {
                    
                    answer.get(refinedWord).add(titles);
                }
                else {
                    Set<Media> wordSet = new HashSet<>();
                    wordSet.add(titles);
                    answer.put(refinedWord, wordSet);
                }
            }
        }
        return answer;     
    }
}

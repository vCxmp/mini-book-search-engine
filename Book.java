/*
 * 
 * 1/13/2025
 */
import java.util.*;

/*
 * This class analyzes a book that it is given. It can give information such as who the authors are
 *      ,what the average rating of the book is, and more. 
 */
public class Book implements Media, Comparable<Book> {
    private String title;
    private List<String> authors;
    private Scanner content;
    private List<Integer> ratings;
    private List<String> words;

    /*
     * This constructor helps the program take notes on what the book's title is, who
     *      the authors are, and what the contents are inside the book. 
     * Parameters:
     *      - title: the title of the book
     *      - authors: the list of authors who wrote the book
     *      - content: the words and numbers inside the book
     */
    public Book(String title, List<String> authors, Scanner content) {
        this.title = title;
        this.authors = authors;
        this.content = content;
        this.ratings = new ArrayList<>();
        words = new ArrayList<>();
        while (content.hasNext()) {
            words.add(content.next());
        }
    }

    /*
     * This gives out the title of the book being analyzed.
     * Return: 
     *      - String: the title of the book
     */
    public String getTitle() {
        return this.title;
    }

    /*
     * This gives out the names of the authors who wrote the book.
     * Return: 
     *      - List<String>: all the people who wrote the book
     */
    public List<String> getArtists() {
        return this.authors;
    }

    /*
     * This adds a numerical rating to the book. 
     * Parameter: 
     *      - score: the new numerical rating being added to the book
     */
    public void addRating(int score) {
        this.ratings.add(score);
    }

    /*
     * This tells how many times that ratings were added to the book. 
     * Return: 
     *      - int: the amount of times that a rating was added to the book
     */
    public int getNumRatings() {
        return this.ratings.size();
    }
    /*
     * The average rating of the book being analyzed. If there are no ratings at all, 
     *      then the average rating is considred a 0. 
     * Return: 
     *      - double: the average rating of the book
     */
    public double getAverageRating() {
        if (this.ratings.size() == 0) {
            return 0.0;
        }
        else {
            double cumRating = 0;
            for (int rating : ratings) {
                cumRating += rating;
            }
            return cumRating / ratings.size();
        }
    }

    /*
     * This gives out all the words and numbers contained within the book being analyzed. 
     * Return: 
     *      - List<String>: list of all the words and numbers contained within the book
     */
    public List<String> getContent() {
        return words;
    }

    /*
     * This produces a clear summary of the book's key information such as its title, 
     *      authors, average rating, and the number of times the book got rated. 
     * Return: 
     *      - String: A formatted sentence contained all the details of the book.
     */
    public String toString() {
        String answer = this.title + " by [";
        for (int i = 0; i < authors.size() - 1; i++) {
            answer += authors.get(i) + ", ";
        }
        answer += authors.get(authors.size() - 1);
        answer += "]";
        if (this.ratings.size() >= 1) {
            double roundedRating = Math.round(this.getAverageRating() * 100.0) / 100.0;
            answer += ": " + roundedRating + " (" + getNumRatings() + " ratings)";
        }
        return answer;
    }

    /*
     * This compares the average rating of the current book being analyzed with the 
     *      average rating of another book. 
     * Parameters: 
     *      - other: the other book that will be compared with the current book
     * Return: 
     *      - int: Will be a postive number if the current book has a lesser average 
     *      rating than the other book. Will be 0 if both average ratings are the exact same. 
     *      Will be a negative number if the current book has a greater average rating than the 
     *      other book.
     */
    public int compareTo(Book other) {
        if (this.getAverageRating() < other.getAverageRating()) {
            return 1;
        }
        else if (this.getAverageRating() == other.getAverageRating()) {
            return 0;
        }
        else {
            return -1;
        }
    }
}

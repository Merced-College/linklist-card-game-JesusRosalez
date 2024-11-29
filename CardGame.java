// Jesus Rosalez
// 11 - 29 - 24
// Card Game
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CardGame {
    private static LinkList cardList = new LinkList();

    public static void main(String[] args) {
        String fileName = "cards.txt";

        // Load cards from the file
        loadCardsFromFile(fileName);

        // Shuffle the deck (add a shuffle method to LinkList if not already present)
        cardList.shuffle();

        // Display the shuffled deck
        System.out.println("Shuffled deck:");
        cardList.displayList();

        // Draw 5 cards for the player
        System.out.println("Drawing 5 cards for the player...");
        for (int i = 0; i < 5; i++) {
            Card drawnCard = cardList.getFirst();
            if (drawnCard != null) {
                System.out.println("Drawn Card: " + drawnCard);
            } else {
                System.out.println("No more cards to draw.");
                break;
            }
        }

        // Display the remaining deck
        System.out.println("\nRemaining deck:");
        cardList.displayList();
    }

    //Reads card data from a file and loads them into the card list.
    private static void loadCardsFromFile(String fileName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                // Split the line into card attributes
                String[] details = line.split(",");
                if (details.length == 4) {
                    String suit = details[0].trim();
                    String name = details[1].trim();
                    int value = Integer.parseInt(details[2].trim());
                    String pic = details[3].trim();

                    // Create a new card and add it to the list
                    Card card = new Card(suit, name, value, pic);
                    cardList.add(card);
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            // Close the BufferedReader
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                System.err.println("Error closing the file: " + e.getMessage());
            }
        }
    }
}

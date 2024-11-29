public class Card {
    private String cardSuit;
    private String cardName;
    private int cardValue;
    private String cardPic;

    public Card(String suit, String name, int value, String pic) {
        cardSuit = suit;
        cardName = name;
        cardValue = value;
        cardPic = pic;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card other = (Card) obj;
        return cardValue == other.cardValue && cardName.equals(other.cardName) && cardSuit.equals(other.cardSuit);
    }

    @Override
    public String toString() {
        return cardName + " of " + cardSuit + " (Value: " + cardValue + ")";
    }
}

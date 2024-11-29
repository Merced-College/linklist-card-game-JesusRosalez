public class Link {
    public Card cardLink;
    public Link next;

    public Link(Card card) {
        cardLink = card;
    }

    public void displayLink() {
        System.out.println(cardLink);
    }
}

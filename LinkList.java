import java.util.Random;

public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public void insertFirst(Card card) {
        Link newLink = new Link(card);
        newLink.next = first;
        first = newLink;
    }

    public void add(Card card) {
        insertFirst(card); // Use insertFirst for simplicity
    }

    public Link find(Card cardToFind) {
        Link current = first;
        while (current != null) {
            if (current.cardLink.equals(cardToFind)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Link delete(Card cardToFind) {
        Link current = first;
        Link previous = null;

        while (current != null && !current.cardLink.equals(cardToFind)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return null; // Card not found
        }

        if (previous == null) {
            first = current.next; // Remove first element
        } else {
            previous.next = current.next; // Remove in-between or last element
        }
        return current;
    }

    public void shuffle() {
        if (first == null || first.next == null) return;

        Link[] links = toArray();
        Random rand = new Random();

        for (int i = links.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Link temp = links[i];
            links[i] = links[j];
            links[j] = temp;
        }

        fromArray(links);
    }

    private Link[] toArray() {
        int size = getSize();
        Link[] array = new Link[size];
        Link current = first;
        int i = 0;
        while (current != null) {
            array[i++] = current;
            current = current.next;
        }
        return array;
    }

    private void fromArray(Link[] links) {
        first = null;
        for (int i = links.length - 1; i >= 0; i--) {
            links[i].next = first;
            first = links[i];
        }
    }

    public int getSize() {
        int size = 0;
        Link current = first;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public Card getFirst() {
        if (first == null) return null;
        Card card = first.cardLink;
        first = first.next;
        return card;
    }

    public void displayList() {
        System.out.println("Deck:");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}

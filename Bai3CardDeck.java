import java.util.*;

// Định nghĩa lớp Card (quân bài) với 2 thuộc tính là rank và suit
class Card implements Comparable<Card> {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Cài đặt Comparable để sắp xếp Card theo thứ tự rank
    @Override
    public int compareTo(Card otherCard) {
        // Sử dụng compareTo để so sánh rank của hai Card
        return this.rank.compareTo(otherCard.rank);
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

// Định nghĩa lớp CompareCard để so sánh hai Card
class CompareCard implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        // Sử dụng compareTo để so sánh hai Card theo rank
        return card1.compareTo(card2);
    }
}

public class Bai3CardDeck {
    public static void main(String[] args) {
        // Tạo bộ bài gồm 52 quân bài
        List<Card> deck = new ArrayList<>();

        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(rank, suit));
            }
        }

        // Trộn bộ bài
        Collections.shuffle(deck);

        // Sắp xếp bộ bài sử dụng Comparator
        Collections.sort(deck, new CompareCard());

        // In ra bộ bài đã sắp xếp
        System.out.println("Bộ bài sau khi đã sắp xếp:");
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}

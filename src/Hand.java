import java.util.ArrayList;

public class Hand {
  ArrayList<Integer> cards = new ArrayList<>();

  ArrayList<Integer> addCard(int card) {
    cards.add(card);
    return cards;
  }

  int getValue() {
    int value = 0;
    for (int card: cards) {
      value += Deck.getCardValue(card);
    }
    return value;
  }
}

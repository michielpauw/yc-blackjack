import java.util.ArrayList;

public class Hand {
  private ArrayList<Integer> cards = new ArrayList<>();
  private int value = 0;

  boolean addCard(int card) {
    cards.add(card);
    value += Deck.getCardValue(card);
    if (value > 21 && cards.contains(0)) {
      value -= 10;
    }
    if (value > 21 && cards.contains(13)) {
      value -= 10;
    }
    if (value > 21 && cards.contains(26)) {
      value -= 10;
    }
    if (value > 21 && cards.contains(39)) {
      value -= 10;
    }
    return (value > 21);
  }

  ArrayList<Integer> getCards() {
    return new ArrayList<>(cards);
  }

  int getValue() {
    return value;
  }
}

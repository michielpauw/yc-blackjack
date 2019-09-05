import java.util.ArrayList;
import java.util.Random;

public class Deck {
  private ArrayList<Integer> shuffledDeck = new ArrayList<Integer>();

  Deck() {
    shuffleDeck();
  }

  private void shuffleDeck() {
    Random randomGenerator = new Random();
    int index;

    ArrayList<Integer> orderedDeck = getOrderedDeck();
    for (int i = 0; i < 52; i++) {
      index = randomGenerator.nextInt(orderedDeck.size());
      shuffledDeck.add(orderedDeck.get(index));
      orderedDeck.remove(index);
    }
  }

  private ArrayList<Integer> getOrderedDeck() {
    ArrayList<Integer> orderedDeck = new ArrayList<Integer>();

    for (int i = 0; i < 52; i++) {
      orderedDeck.add(i);
    }
    return new ArrayList<>(orderedDeck);
  }

  static int getCardValue(int cardNumber) {
    int type = cardNumber % 13;
    if (type == 0) {
      return 11;
    }
    else if (type <= 9) {
      return type + 1;
    }
    else {
      return 10;
    }
  }

  int getNewCard() {
    int card = shuffledDeck.get(0);
    shuffledDeck.remove(0);
    return card;
  }

  static String getCardString(int cardNumber) {
    int suitInt = cardNumber/ 13;
    int type = cardNumber % 13;
    String cardString = "";

    switch(type) {
      case 10:
        cardString += "Jack";
        break;
      case 11:
        cardString += "Queen";
        break;
      case 12:
        cardString += "King";
        break;
      case 0:
        cardString += "Ace";
        break;
      default:
        cardString = cardString + (type + 1);
    }

    cardString += " of ";

    switch(suitInt) {
      case 0:
        cardString += "Spades";
        break;
      case 1:
        cardString += "Hearts";
        break;
      case 2:
        cardString += "Diamonds";
        break;
      case 3:
        cardString += "Clubs";
        break;
      default:
        cardString += "";
    }
    return cardString;
  }
}

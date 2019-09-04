import java.util.*;

class Blackjack {

  Deck deck;
  Hand

  public static void main(String args[]) {
    boolean playersTurn = true;
    Scanner sc;
    String input;
    Deck deck = new Deck();
    Hand handDealer = new Hand();
    Hand handPlayer = new Hand();
    dealInitial(deck, handDealer, handPlayer);
    while (playersTurn) {
      printGame(handDealer, handPlayer);
      sc = new Scanner(System.in);
      input = sc.next();
      switch (input) {
        case "k":
          handPlayer.addCard(deck.getNewCard());
          break;
        case "p":
          playersTurn = false;
          break;
        case "q":
          System.out.println("Dank voor het spelen. Tot ziens!");
          System.exit(0);
          break;
        default:
          continue;
      }
    }
  }

  static boolean playersTurn(Deck deck, Hand handDealer, Hand handPlayer) {

  }

  static void dealInitial(Deck deck, Hand handDealer, Hand handPlayer) {
    handDealer.addCard(deck.getNewCard());
    handPlayer.addCard(deck.getNewCard());
    handDealer.addCard(deck.getNewCard());
    handPlayer.addCard(deck.getNewCard());
  }

  static void printGame(Hand handDealer, Hand handPlayer) {
    System.out.print("The dealer has the following cards: \n\t\t");
    for (int card: handDealer.cards) {
      System.out.print(Deck.getCardString(card) + "\t");
    }
    System.out.println();
    System.out.println("With the total value of " + handDealer.getValue());
    System.out.println();
    System.out.print("You have the following cards: \n\t\t");
    for (int card: handPlayer.cards) {
      System.out.print(Deck.getCardString(card) + "\t");
    }
    System.out.println();
    System.out.println("With the total value of " + handPlayer.getValue());
  }
}
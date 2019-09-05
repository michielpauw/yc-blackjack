import java.util.ArrayList;
import java.util.Scanner;

public class Game {
  private Deck deck;
  private Participant dealer = new Participant();
  private ArrayList<Player> players = new ArrayList<>();
  private int activePlayers;


  Game(int amountPlayers) {
    deck = new Deck();
    for(int i = 0; i < amountPlayers; i++) {
      players.add(new Player(i + 1));
    }
    dealInitial();
    printGame();
    activePlayers = amountPlayers;
  }

  Game() {
    this(1);
  }

  void playGame() {
    while (activePlayers > 0) {
      for (Player player: players) {
        if (player.isActive()) {
          playersTurn(player);
          printGame();
        }
      }
    }
    dealersTurn();
    determineWinner();
  }

  private void determineWinner() {
  }

  private void dealersTurn() {
    while (dealer.hand.getValue() < 14) {
      dealer.hand.addCard(deck.getNewCard());
    }
    printGame();
  }

  private void playersTurn(Player player) {
    Scanner sc;
    String input;
    boolean dead;
    sc = new Scanner(System.in);
    input = sc.next();
    switch (input) {
      case "k":
        dead = player.hand.addCard(deck.getNewCard());
        if (dead) {
          player.toggleActive();
          activePlayers--;
        }
        break;
      case "p":
        player.toggleActive();
        activePlayers--;
        break;
      case "q":
        System.out.println("Dank voor het spelen. Tot ziens!");
        System.exit(0);
        break;
      default:
        playersTurn(player);
    }
  }

  private void dealInitial() {
    for (int i = 0; i < 2; i++) {
      dealer.hand.addCard(deck.getNewCard());
      for (Player player: players)
        player.hand.addCard(deck.getNewCard());
    }
  }

  private void printGame() {
    System.out.print("The dealer has the following cards: \n\t\t");
    for (int card: dealer.hand.getCards()) {
      System.out.print(Deck.getCardString(card) + "\t");
    }
    System.out.println();
    System.out.println("With the total value of " + dealer.hand.getValue());
    System.out.println();
    for (Player player: players) {
      System.out.print("Player " + player.getPlayerId() + " has the following cards: \n\t\t");
      for (int card: player.hand.getCards()) {
        System.out.print(Deck.getCardString(card) + "\t");
      }
      System.out.println();
      System.out.println("With the total value of " + player.hand.getValue());
    }
    System.out.println();
  }
}

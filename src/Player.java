public class Player extends Participant {
  private int playerId;
  private boolean active = true;

  Player(int playerId) {
    this.playerId = playerId;
  }

  public int getPlayerId() {
    return playerId;
  }

  public void setPlayerId(int playerId) {
    this.playerId = playerId;
  }

  public boolean isActive() {
    return active;
  }

  public void toggleActive() {
    this.active = (this.active == false);
  }
}

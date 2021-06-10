import java.awt.Color;
import java.awt.Graphics;

public class SLives extends SBoard {
  // public int p1Lives;
  // public int p2Lives;

  public SLives() {
    // p1Lives = 5;
    // p2Lives = 5;
    setp1(5);
    setp2(5);
  }

  public void display(Graphics window) {
    window.setColor(Color.BLACK);
    window.drawString("P1 Lives: " + getp1(), 150, 35);
    window.drawString("P2 Lives: " + getp2(), 350, 35);
  }

  public void updateP1Lives() {
    setp1(getp1()-1);
  }
  public void updateP2Lives() {
    setp2(getp2()-1);
  }
  public int getP1Lives() {
    return getp1();
  }
  public int getP2Lives() {
    return getp2();
  }
}
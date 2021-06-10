public class SBoard {
  private int p1data;
  private int p2data;

  public SBoard() {
  }

  public void setp1(int x) {
    p1data = x;
  }

  public void setp2(int x) {
    p2data = x;
  }

  public int getp1() {
    return p1data;
  }

  public int getp2() {
    return p2data;
  }
}
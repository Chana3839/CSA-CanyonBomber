import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class BombSupply
{
  private List<Bomb> bomb;

  public BombSupply()
  {
    bomb = new ArrayList<Bomb>();
  }

  public void add(Bomb a)
  {
    bomb.add(a);
  }

  public void drawEmAll(Graphics window)
  {
    if (bomb.size() > 0) {
      for (Bomb a : bomb)
      a.draw(window);
    }
  }

  public void moveEmAll()
  {
    if (bomb.size() > 0) {
      for (Bomb a : bomb)
        a.move();
    }
  }

   public void cleanEmUp() {
    for (int i = bomb.size()-1; i >= 0; i--)
      if (bomb.get(i).getX() <= 0 || bomb.get(i).getX() >= 590 || bomb.get(i).getY() >= 390)
        bomb.remove(i);
  } 

  public List<Bomb> getList()
  {
    return bomb;
  }
  public Bomb getBomb(int x) {
		return bomb.get(x);
	}
  public int getSize() {
		return bomb.size();
	}
  
	public void end()
	{
		if (bomb.size() > 0) {
			for (int i = 0; i < bomb.size(); i++) {
				bomb.get(i).setSpeed(0);
			}
		}
	}

  public String toString()
  {
    return "";
  }
}

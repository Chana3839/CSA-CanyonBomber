import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class Blimp extends MovingThing
{
  
  private Image image;
  private String direction;
  private BombSupply bombs;

  public Blimp(int xPos, int yPos, int blimpColor, String d) //blimpColor: 1/2/3
  {
    super(xPos, yPos, 50, 50, 1);
    direction = d;
    try {
      String str = "blimp" + blimpColor + ".jpg";
      URL url = getClass().getResource(str);
      image = ImageIO.read(url);
    }
    catch(Exception e) {
    }
  }

  public void move() 
  {
    if (direction.equals("LEFT")) 
    { 
      if (getX() >= 0)
        setX(getX() - getSpeed());
      else
        direction = "RIGHT";
    }
    if (direction.equals("RIGHT"))
    {
      if (getX() <= 550)
        setX(getX() + getSpeed());
      else
        direction = "LEFT";
    }
    // bombs.moveEmAll();
  }

  public void draw( Graphics window ) 
  {
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
    // bombs.drawEmAll(window);
    // bombs.cleanEmUp();
  }

  public void shoot(List<Bomb> bombs, Color c)
  {
    bombs.add(new Bomb(getX()+getWidth()/2-5, getY()+getHeight(), c, direction));
  }

  public String toString() {
    return super.toString() + " " + getSpeed();
  }
}

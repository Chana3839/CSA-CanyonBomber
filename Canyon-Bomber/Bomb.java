import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Bomb extends MovingThing
{
  private String direction;
  private Color color;

  public Bomb()
  {
    this(0,0,1,Color.YELLOW, "RIGHT");
  }

  public Bomb(int x, int y, Color c, String d)
  {
    super(x,y,3);
    color = c;
    direction = d;
  }

  public Bomb(int x, int y, int s, Color c, String d)
  {
    super(x,y,s);
    color = c;
    direction = d;
  }

  public void draw(Graphics window)
  {
    window.setColor(color);
		window.fillRect(getX(),getY(),getWidth(),getHeight());
  }
        
  public void move()
  {
  	if (direction.equals("RIGHT")) {
			setX(getX() + getSpeed());
      setY(getY() + getSpeed());
		}
		if (direction.equals("LEFT")){
			setX(getX() - getSpeed());
      setY(getY() + getSpeed());
		}
  }

	public boolean didIntersect(Rock obj) {
    return ( (getX() >= obj.getX() && getX() <= obj.getX() + obj.getWidth()) || (getX() + getWidth() >= obj.getX() && getX() + getWidth() <= obj.getX() + obj.getWidth()) ) && ( (getY() >= obj.getY() && getY() <= obj.getY() + obj.getHeight()) || (getY() + getHeight() >= obj.getY() && getY() + getHeight() <= obj.getY() + obj.getHeight()) );
  }
  
  public String toString()
  {
    return super.toString() + " " + getSpeed();
  }
  public Color getColor() {
    return color;
  }

}

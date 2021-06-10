import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Rock extends Block
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;
  private Color color;

  public Rock()
  {
    xPos = 0;
    yPos = 200;
    width = 20;
    height = 20;
    color = Color.GREEN;

  }

  public Rock(int x, int y)
  {
    xPos = x;
    yPos = y;
    width = 20;
    height = 20;
    color = Color.GREEN;
  }

  public Rock(int x, int y, int w, int h)
  {
    xPos = x;
    yPos = y;
    width = w;
    height = h;
    color = Color.YELLOW;
  }
    public Rock(int x, int y, int w, int h, Color c)
  {
    xPos = x;
    yPos = y;
    width = w;
    height = h;
    color = c;
  }

//add rock getters
  public int getX(){
    return xPos;
  }
  public int getY(){
    return yPos;
  }
  public int getWidth(){
    return width;
  }
  public int getHeight(){
    return height;
  }
  public Color getColor(){
    return color;
  }

  public void setColor(Color c) {
    color = c;
  }



  public void draw( Graphics window )
  {
    window.setColor(color);
    window.fillRect(xPos, yPos, width, height);
  }

  public String toString()
  {
    return " ";
  }
}

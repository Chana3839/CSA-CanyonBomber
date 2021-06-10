import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;


public class Block
{  
  private int xPos;
  private int yPos;
  private int width;
  private int height;
  private Color color;

  public Block(){
    xPos=0;
    yPos=0;
    width=20;
    height=20;
    color = Color.BLACK;
  }
  
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

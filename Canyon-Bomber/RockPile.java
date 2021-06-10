import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class RockPile
{
  private List<Rock> rocks;
  private int num;

  public RockPile(int n)
  {
    rocks = new ArrayList<Rock>();

    num = n;
    generatePile(0, 200, 20, 20);
  }

  public void add(Rock a)
  {
    rocks.add(a);
  }

  public void drawEmAll( Graphics window )
  {
    if (rocks.size() > 0) {
			for (Rock a : rocks) 
				a.draw(window);
		}
  }

  private void generatePile(int x, int y, int w, int h) {
		int xPos = x;
    Color[] colours= {Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK};
    int colorIndex=0;
    //keep track of where
    int numBlocks = 1;
		for (int i = 0; i < num; i++) {
			rocks.add(new Rock(x, y, w, h,colours[colorIndex%4]));
      //create canyon
      if (rocks.get(i).getX()<=(20*numBlocks)|| rocks.get(i).getX()>=(600-(20*numBlocks))){
        rocks.get(i).setColor(Color.GRAY);
      }
    		
      if (x >= 600) {
				x = xPos;
				y = y + h;
        numBlocks++;
        colorIndex++;

			} else {
				x = x + w;
			}

		}

  //grey rocks on bottom
  for(Rock rock: rocks){
    if (rock.getY() >= (370 - rock.getHeight())){
      rock.setColor(Color.GRAY);
    }
  }

    
	}

	public List<Rock> getList() {
		return rocks;
	}

  public String toString()
  {
    return "";
  }
}

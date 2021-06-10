import javax.swing.JFrame;
import java.awt.Component;

public class GameRunner extends JFrame
{
  private static final int WIDTH = 600;
  private static final int HEIGHT = 400;

  public GameRunner()
  {
    super("Canyon_Bomber");
    setSize(WIDTH,HEIGHT);

    CanyonBomber theGame = new CanyonBomber();
    ((Component)theGame).setFocusable(true);

    getContentPane().add(theGame);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
  

  public static void main( String args[] )
  {
    GameRunner run = new GameRunner();
  }
} 

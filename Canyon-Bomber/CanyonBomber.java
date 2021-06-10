import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//trying to make a high score thing
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class CanyonBomber extends Canvas implements KeyListener, Runnable
{
  //private variables
  private Blimp blimp1;
  private Blimp blimp2;
  private BombSupply bomb1;
  private BombSupply bomb2;
  private RockPile rocks;
  private int timer; 
  private Score scoresboard;
  private SLives livesboard;
  private BufferedImage back;
  private File file;
  private boolean hasRecorded;
  private int hs;
  
  public CanyonBomber()
  {
    setBackground(Color.WHITE);

    //instantiate other instance variables
    rocks = new RockPile(400);
    bomb1 = new BombSupply();
    bomb2 = new BombSupply();
    blimp1 = new Blimp(0,50,1,"RIGHT");
    blimp2 = new Blimp(550,100,2,"LEFT");
    timer = 0;
    scoresboard = new Score();
    livesboard = new SLives();

    file = new File("scores.txt");
    hasRecorded = false;
    hs = 0;

    this.addKeyListener(this);
    new Thread(this).start();

    setVisible(true);
  }

  public void update(Graphics window)
  {
    paint(window);
    timer++;
  }

  public void paint( Graphics window )
  {

    Graphics2D twoDGraph = (Graphics2D)window;
    if(back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));
    Graphics graphToBack = back.createGraphics();

    //set background
    graphToBack.setColor(Color.WHITE);
    graphToBack.fillRect(0,0,600,400);

    //game over - win
    if (rocks.getList().size() == 0 && scoresboard.getP1Score() > scoresboard.getP2Score() || livesboard.getP2Lives() <= 0) {
      graphToBack.setColor(Color.GRAY);
      graphToBack.fillRect(0,0,600,50);
      graphToBack.setColor(Color.BLACK);
      graphToBack.drawString("YOU WON!", 275, 20);
      if (!hasRecorded) {
        scoresboard.writeScore(file);
        hs = scoresboard.determineHS(file);
        hasRecorded = true;
      }
      graphToBack.drawString("High score: " + hs, 250, 40);
    }
    //game over - lose
    else if (rocks.getList().size() == 0 && scoresboard.getP1Score() < scoresboard.getP2Score() || livesboard.getP1Lives() <= 0) {
      graphToBack.setColor(Color.GRAY);
      graphToBack.fillRect(0,0,600,50);
      graphToBack.setColor(Color.BLACK);
      graphToBack.drawString("YOU LOST", 275, 20);
      if (!hasRecorded) {
        hs = scoresboard.determineHS(file);
        hasRecorded = true;
      }
      graphToBack.drawString("High score: " + hs, 250, 40);
    }
    //play game
    else {
      scoresboard.display(graphToBack);
      livesboard.display(graphToBack);

      //p2 shoot on timer
      if(rocks.getList().size() >= 0 && timer % 200 == 0)
      blimp2.shoot(bomb2.getList(), Color.RED);
    }
    //draw objects
    rocks.drawEmAll(graphToBack);
    blimp1.draw(graphToBack);
    blimp1.move();
    blimp2.draw(graphToBack);
    blimp2.move();
    bomb1.drawEmAll(graphToBack);
    bomb1.moveEmAll();
    bomb1.cleanEmUp();
    bomb2.drawEmAll(graphToBack);
    bomb2.moveEmAll();
    bomb2.cleanEmUp();

    //p1 hits rock
    for (int i = rocks.getList().size()-1; i>=0; i--)
      for (int j = bomb1.getList().size()-1; j>=0; j--) 
        if (bomb1.getList().get(j).didIntersect(rocks.getList().get(i))) {
          bomb1.getList().remove(j);
          if (rocks.getList().get(i).getColor() == Color.GRAY)
            livesboard.updateP1Lives();
          else {
            scoresboard.updateP1Score(rocks.getList().get(i).getColor());
            rocks.getList().remove(i);
          }
        } 
    //p2 hits rock
    for (int i = rocks.getList().size()-1; i>=0; i--)
      for (int j = bomb2.getList().size()-1; j>=0; j--) 
        if (bomb2.getList().get(j).didIntersect(rocks.getList().get(i))) {
          bomb2.getList().remove(j);
          if (rocks.getList().get(i).getColor() == Color.GRAY)
            livesboard.updateP2Lives();
          else {
            scoresboard.updateP2Score(rocks.getList().get(i).getColor());
            rocks.getList().remove(i);
          }
        } 

    twoDGraph.drawImage(back, null, 0, 0);
  }

  //p1 shoot on space bar
  public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_SPACE && livesboard.getP1Lives() > 0)
    {
      blimp1.shoot(bomb1.getList(), Color.YELLOW);
    }
    repaint();
  }

  public void keyReleased(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
    }
    repaint();
  }

  public void keyTyped(KeyEvent e)
  {
  }

  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(5);
        repaint();
      }
    }catch(Exception e)
    {
    }
  }
}


import java.awt.Color;
import java.awt.Graphics;
//
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;

public class Score extends SBoard {

  private highScore HS;

  public Score() {
    HS = new highScore();
    setp1(20);
    setp2(20);
  }

  public void display(Graphics window) {
    window.setColor(Color.GRAY);
    window.fillRect(0,0,600,50);
    window.setColor(Color.BLACK);
    window.drawString("P1 Score: " + getp1(), 150, 20);
    window.drawString("P2 Score: " + getp2(), 350, 20);
  }

  public void updateP1Score(Color rock) {
    if (rock == Color.YELLOW) {
      setp1(getp1()+10);
    }
    if (rock == Color.GREEN) {
      setp1(getp1()+20);
    }
    if (rock == Color.BLUE) {
      setp1(getp1()+30);
    }
    if (rock == Color.PINK) {
      setp1(getp1()+40);
    }
  }

  public void updateP2Score(Color rock) {
    if (rock == Color.YELLOW) {
      setp2(getp2()+10);
    }
    if (rock == Color.GREEN) {
      setp2(getp2()+20);
    }
    if (rock == Color.BLUE) {
      setp2(getp2()+30);
    }
    if (rock == Color.PINK) {
      setp2(getp2()+40);
    }
  }

  public int getP1Score() {
    return getp1();
  }
  public int getP2Score() {
    return getp2();
  }

  public void writeScore(File file) {
    try {
      BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
      output.newLine();
      output.append("" + getP1Score());
      output.close();

    }
    catch (IOException ex1) {
      System.out.printf("error writing score", ex1);
    }
  }

  public int determineHS(File file) {
    HS.readHS(file);
    return HS.gethScore();
  }
}
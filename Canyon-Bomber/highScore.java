import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;

public class highScore {

  private int hScore;

  public highScore() {
    hScore = 0;
  }

  public void readHS(File file) {
    int hs = 0;
    try {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
          try {
            int s = Integer.parseInt(line.trim());
            if (s > hs) { 
              hs = s; 
            }
          }
          catch (NumberFormatException e1) {
            System.err.println("ignoring invalid score");
          }
          line = reader.readLine();
        }
        reader.close();

    }
    catch (IOException ex) {
      System.err.println("error reading scores");
    }
    hScore = hs;
  }

  public int gethScore() {
    return hScore;
  }



}
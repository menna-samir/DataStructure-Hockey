package eg.edu.alexu.csd.datastructure.iceHockey.cs84;

import java.awt.Point;
import java.lang.*;

public class Hockey implements IPlayersFinder { 
  int xmin = 1000;
  int ymin = 1000;
  int xmax = 0;
  int ymax = 0;
  
  public int check(char[][] charArray, int x, int y, int team) {
    int count = 0;
    char change = Character.forDigit(team, 10);
    if (charArray[x][y] != change) {
      return 0;
    } else if (charArray[x][y] == change) {
      count++;
      charArray[x][y] = '$';
      if (x > xmax) {
        xmax = x;
      }
      if (x < xmin) {
        xmin = x;
      }
      if (y > ymax) {
        ymax = y;
      }
      if (y < ymin) {
        ymin = y;
      }
      if (x == 0 && y == 0) {
        count += check(charArray, x, y + 1, team);
        count += check(charArray, x + 1, y, team);
      }
      if (x == 0 && y == charArray[0].length - 1) {
        count += check(charArray, x + 1, y, team);
      }
      if (x == 0 && y != 0 && y != charArray[0].length - 1) {
        count += check(charArray, x, y + 1, team);
        count += check(charArray, x + 1, y, team);
      }
      if (x != 0 && x != charArray.length - 1 && y == 0) {
        count += check(charArray, x, y + 1, team);
        count += check(charArray, x + 1, y, team);
        count += check(charArray, x - 1, y, team);
      }
      if (x != 0 && x != charArray.length - 1 && y == charArray[0].length - 1) {
        count += check(charArray, x + 1, y, team);
        count += check(charArray, x, y - 1, team);
        count += check(charArray, x - 1, y, team);
      }
      if (x == charArray.length - 1 && y == 0) {
        count += check(charArray, x, y + 1, team);
        count += check(charArray, x - 1, y, team);
      }
      if (x == charArray.length - 1 && y == charArray[0].length - 1) {
        count += check(charArray, x, y - 1, team);
        count += check(charArray, x - 1, y, team);
      }
      if (x == charArray.length - 1 && y != 0 && y != charArray[0].length - 1) {
        count += check(charArray, x, y + 1, team);
        count += check(charArray, x, y - 1, team);
        count += check(charArray, x - 1, y, team);
      }
      if (x != 0 && x != charArray.length - 1 && y != 0 && y != charArray[0].length - 1) {
        count += check(charArray, x, y + 1, team);
        count += check(charArray, x + 1, y, team);
        count += check(charArray, x, y - 1, team);
        count += check(charArray, x - 1, y, team);
      }
    }
    return count;
  }

  public Point center() { 
    int x = xmin + xmax + 1;
    int y = ymin + ymax + 1;
    xmin = 1000;
    ymin = 1000;
    xmax = 0;
    ymax = 0;
    Point p = new Point(y, x);
    return p;
  }

  public Point[] findPlayers(String[] photo, int team, int threshold) { 
    if (photo == null) {
      System.out.println("There's no photo");
      return null;
    } else {
      Point[] r = new Point[100];
      int check;
      char[][] charArray = new char[photo.length][photo[0].length()];
      int k = 0;
      for (int c = 0; c < photo.length; c++) {
        charArray[c] = photo[c].toCharArray();
      }

      for (int i = 0; i < charArray.length; i++) {
        for (int j = 0; j < charArray[0].length; j++) {
          check = check(charArray, i, j, team);
          if (check * 4 >= threshold) {
            r[k] = center();
            k++;
          } else {
            xmin = 1000;
            ymin = 1000;
            xmax = 0;
            ymax = 0;
          }
        }
      }

      Point[] result = new Point[k];
      if (k == 0) {
        System.out.println("No players in the area");
        return null;
      } else {
        for (int i = 0; i < k; i++) {
          result[i] = r[i];
        }

        Point temp = new Point();
        for (int i = 0; i < k - 1; i++) {
          for (int j = 0; j < k - i - 1; j++) {
            if (result[j].x > result[j + 1].x) {
              temp = result[j];
              result[j] = result[j + 1];
              result[j + 1] = temp;
            } else if (result[j].x == result[j + 1].x) {
              if (result[j].y > result[j + 1].y) {
                temp = result[j];
                result[j] = result[j + 1];
                result[j + 1] = temp;
              }
            }
          }

        }
        return result;
      }
    }
  }
}

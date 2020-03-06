package eg.edu.alexu.csd.datastructure.iceHockey.cs84;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestHockey {

  @Test
  void test1() {
    Hockey tr = new Hockey();
    String[] array = {"33JUBU33",
                      "3U3O4433",
                      "O33P44NB",
                      "PO3NSDP3",
                      "VNDSD333",
                      "OINFD33X"};
    Point [] result = tr.findPlayers(array, 3, 16);
    Point[] r = new Point[3];
    r[0] = new Point(4,5);
    r[1] = new Point(13,9);
    r[2] = new Point(14,2);
    Assert.assertArrayEquals(r,result);
  }

  @Test
  void test2() {
    Hockey tr = new Hockey();
    String[] array = {"44444H44S4",
                      "K444K4L444",
                      "4LJ44T44XH",
                      "444O4VIF44",
                      "44C4D4U444",
                      "4V4Y4KB4M4",
                      "G4W4HP4O4W",
                      "4444ZDQ4S4",
                      "4BR4Y4A444",
                      "4G4V4T4444"};
    Point [] result = tr.findPlayers(array, 4, 16);
    Point[] r = new Point[6];
    r[0] = new Point(3,8);
    r[1] = new Point(4,16);
    r[2] = new Point(5,4);
    r[3] = new Point(16,3);
    r[4] = new Point(16,17);
    r[5] = new Point(17,9);
    Assert.assertArrayEquals(r,result);
  }

  @Test
  void test3() {
    Hockey tr = new Hockey();
    String[] array = {"8D88888J8L8E888",
                      "88NKMG8N8E8JI88",
                      "888NS8EU88HN8EO",
                      "LUQ888A8TH8OIH8",
                      "888QJ88R8SG88TY",
                      "88ZQV88B88OUZ8O",
                      "FQ88WF8Q8GG88B8",
                      "8S888HGSB8FT8S8",
                      "8MX88D88888T8K8",
                      "8S8A88MGVDG8XK8",
                      "M88S8B8I8M88J8N",
                      "8W88X88ZT8KA8I8",
                      "88SQGB8I8J88W88",
                      "U88H8NI8CZB88B8",
                      "8PK8H8T8888TQR8"};
    Point [] result = tr.findPlayers(array, 8, 9);
    Point[] r = new Point[19];
    r[0] = new Point(1, 17);
    r[1] = new Point(3, 3);
    r[2] = new Point(3, 10);
    r[3] = new Point(3, 25);
    r[4] = new Point(5, 21);
    r[5] = new Point(8, 17);
    r[6] = new Point(9, 2);
    r[7] = new Point(10,9);
    r[8] = new Point(12,23);
    r[9] = new Point(17,16);
    r[10] = new Point(18,3);
    r[11] = new Point(18,11);
    r[12] = new Point(18,28);
    r[13] = new Point(22,20);
    r[14] = new Point(23,26);
    r[15] = new Point(24,15);
    r[16] = new Point(27,2);
    r[17] = new Point(28,26);
    r[18] = new Point(29,16);
    Assert.assertArrayEquals(r,result);
  }

  @Test
  void test4() {
    Hockey tr = new Hockey();
    String[] array = {"11111",
                      "1AAA1",
                      "1A1A1",
                      "1AAA1",
                      "11111"};
    Point [] result = tr.findPlayers(array, 1, 3);
    Point[] r = new Point[2];
    r[0] = new Point(5,5);
    r[1] = new Point(5,5);
    Assert.assertArrayEquals(r,result);
  }
  
  @Test
  void test5() {
    Hockey tr = new Hockey();
    String[] array = null;
    assertNull(tr.findPlayers(array, 1, 3));
  }
  
  @Test
  void test6() {
    Hockey tr = new Hockey();
    String[] array = {"0abg0",
                      "5sfsg",
                      "O33po",
                      "PO391",
                      "OINFD"};
    assertNull(tr.findPlayers(array, 0, 5));
  }
  
  @Test
  void test7() {
    Hockey tr = new Hockey();
    String[] array = {"11111",
                      "1AAA1",
                      "1A1A1",
                      "1AAA1",
                      "11111"};
    assertNull(tr.findPlayers(array, 0, 5));
  }
}

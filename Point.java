import java.util.ArrayList; 

final class Point {
  public int x;
  public int y;

  public
  Point(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public
  Point(Point p)
  {
    x = p.x;
    y = p.y;
  }

  public String
  toString()
  {
    return "x = " + x + ", y = " + y;
  }

  public Boolean
  equals(Point p)
  {
    return x == p.x && y == p.y;
  }
}

class Rules {
  static final int X = 8;
  static final int Y = 8;

  public static Boolean
  inBound(Point p)
  {
    return p.x >= 0 && p.y >= 0 &&
           p.x < X  && p.y < Y;
  }

  public static Boolean
  friendlyFire(ArrayList<Piece> pcs, Point p)
  {
    int i;
    for (i = 0; i < pcs.size(); ++i)
      if (pcs.get(i).equals(p))
        break;

    return i < pcs.size();
  }

  public static ArrayList<Point>
  drawLine(Point p, int x, int y)
  {
    ArrayList<Point> lin = new ArrayList<Point>();

    p.x += x;
    p.y += y;
    while(inBound(p)) {
      lin.add(new Point(p));
      p.x += x;
      p.y += y;
    }

    return lin;
  }
}

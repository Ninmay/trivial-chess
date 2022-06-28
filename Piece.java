import java.util.ArrayList; 
import java.util.Random;

abstract class Piece {
  static final int RANDOM_RATE = 100;
  protected Point point;

  public
  Piece(int x, int y)
  {
    point = new Point(x, y);
  }

  public String
  toString()
  {
    return point.toString();
  }

  public Point
  moveAttempt()
  {
    Random r = new Random();
    ArrayList<Point> mvset = getMoveSet();
    if (mvset.isEmpty())
      return null;

    return mvset.get(r.nextInt(RANDOM_RATE) % mvset.size());
  }

  public Point
  move(Point p)
  {
    return point = p; 
  }

  abstract protected ArrayList<Point> getMoveSet();

  public boolean
  equals(Point p)
  {
    return point.equals(p);
  }
}

class King extends Piece {

  public
  King(int x, int y)
  {
    super(x, y);
  }

  @Override
  public String
  toString()
  {
    return "K: " + super.toString();
  }

  @Override
  protected ArrayList<Point>
  getMoveSet()
  {
    ArrayList<Point> mvset = new ArrayList<Point>();

    point.x--; // na zachód kolejno wskazówkami zegara
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    point.y++;
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    point.x++;
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    point.x++;
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    point.y--;
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    point.y--;
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    point.x--;
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    point.x--;
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    
    point.x++; // powrót
    point.y++;

    return mvset;
  }
}

class Pawn extends Piece {
  public
  Pawn(int x, int y)
  {
    super(x, y);
  }
  
  @Override
  protected ArrayList<Point>
  getMoveSet()
  {
    ArrayList<Point> mvset = new ArrayList<Point>();

    point.y++;
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    point.y--;

    return mvset;
  }
}

class Bishop extends Piece {
  public
  Bishop(int x, int y)
  {
    super(x, y);
  }

  @Override
  public String
  toString()
  {
    return "B: " + super.toString();
  }
  
  @Override
  protected ArrayList<Point>
  getMoveSet()
  {
    ArrayList<Point> mvset = new ArrayList<Point>();

    point.x += -2;
    point.y += 1;
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    point.x -= -2;
    point.y -= 1;

    point.x += -1;
    point.y += 2;
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    point.x -= -1;
    point.y -= 2;

    point.x += 1;
    point.y += 2;
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    point.x -= 1;
    point.y -= 2;

    point.x += 2;
    point.y += 1;
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    point.x -= 2;
    point.y -= 1;

    point.x += 2;
    point.y += -1;
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    point.x -= 2;
    point.y -= -1;

    point.x += 1;
    point.y += -2;
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    point.x -= 1;
    point.y -= -2;

    point.x += -1;
    point.y += -2;
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    point.x -= -1;
    point.y -= -2;

    point.x += -2;
    point.y += -1;
    if (Rules.inBound(point))
      mvset.add(new Point(point));
    point.x -= -2;
    point.y -= -1;

    return mvset;
  }
}

class Rook extends Piece {
  public
  Rook(int x, int y)
  {
    super(x, y);
  }

  @Override
  public String
  toString()
  {
    return "R: " + super.toString();
  }
  
  @Override
  protected ArrayList<Point>
  getMoveSet()
  {
    ArrayList<Point> mvset = new ArrayList<Point>();
    Point p;

    p = new Point(point);
    mvset.addAll(Rules.drawLine(p, 1, 0));
    p = new Point(point);
    mvset.addAll(Rules.drawLine(p, -1, 0));
    p = new Point(point);
    mvset.addAll(Rules.drawLine(p, 0, 1));
    p = new Point(point);
    mvset.addAll(Rules.drawLine(p, 0, -1));

    return mvset;
  }
}

class Knight extends Piece {
  public
  Knight(int x, int y)
  {
    super(x, y);
  }
  
  @Override
  public String
  toString()
  {
    return "N: " + super.toString();
  }

  @Override
  protected ArrayList<Point>
  getMoveSet()
  {
    ArrayList<Point> mvset = new ArrayList<Point>();
    Point p;

    p = new Point(point);
    mvset.addAll(Rules.drawLine(p, 1, 1));
    p = new Point(point);
    mvset.addAll(Rules.drawLine(p, 1, -1));
    p = new Point(point);
    mvset.addAll(Rules.drawLine(p, -1, 1));
    p = new Point(point);
    mvset.addAll(Rules.drawLine(p, -1, -1));

    return mvset;
  }
}

class Queen extends Piece {
  public
  Queen(int x, int y)
  {
    super(x, y);
  }

  @Override
  public String
  toString()
  {
    return "Q: " + super.toString();
  }
  
  @Override
  protected ArrayList<Point>
  getMoveSet()
  {
    ArrayList<Point> mvset = new ArrayList<Point>();
    Point p;

    p = new Point(point);
    mvset.addAll(Rules.drawLine(p, 1, 0));
    p = new Point(point);
    mvset.addAll(Rules.drawLine(p, -1, 0));
    p = new Point(point);
    mvset.addAll(Rules.drawLine(p, 0, 1));
    p = new Point(point);
    mvset.addAll(Rules.drawLine(p, 0, -1));
    p = new Point(point);
    mvset.addAll(Rules.drawLine(p, 1, 1));
    p = new Point(point);
    mvset.addAll(Rules.drawLine(p, 1, -1));
    p = new Point(point);
    mvset.addAll(Rules.drawLine(p, -1, 1));
    p = new Point(point);
    mvset.addAll(Rules.drawLine(p, -1, -1));

    return mvset;
  }
}

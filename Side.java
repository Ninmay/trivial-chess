import java.util.ArrayList; 
import java.util.Random;
import java.util.StringJoiner;

abstract class Side {
  static final int RANDOM_RATE = 100;
  protected ArrayList<Piece> pieces;
  
  public String
  toString()
  {
    StringJoiner pcls = new StringJoiner("\n");
    for (Piece pc: pieces)
      pcls.add(pc.toString());

    return pcls.toString();
  }
  
  public Point
  move()
  {
    Random r = new Random();

    Piece pc;
    Point p;
    do {
      pc = pieces.get(r.nextInt(RANDOM_RATE) % pieces.size());
      p = pc.moveAttempt();
    } while (p == null || Rules.friendlyFire(pieces, p));

    return pc.move(p);
  }

  public void
  kill(Point p) throws MateException
  {
    int i;
    for (i = 0; i < pieces.size(); ++i)
      if (pieces.get(i).equals(p))
        break;
    if (i == 0)
      throw new MateException("SZACH MAT");

    if (i != pieces.size())
      pieces.remove(i);
  }
}

class Black extends Side {
  public
  Black()
  {
    pieces = new ArrayList<Piece>();
    pieces.add(new King(4, 7));
    pieces.add(new Rook(0, 7));
    pieces.add(new Bishop(1, 7));
    pieces.add(new Knight(2, 7));
    pieces.add(new Queen(3, 7));
    pieces.add(new Knight(5, 7));
    pieces.add(new Bishop(6, 7));
    pieces.add(new Rook(7, 7));
    for (int i = 0; i < 8; ++i)
      pieces.add(new Pawn(i, 6));
  }

  public String
  toString()
  {
    return "Black:\n" + super.toString();
  }
}

class White extends Side {
  public
  White()
  {
    pieces = new ArrayList<Piece>();
    pieces.add(new King(4, 0));
    pieces.add(new Rook(0, 0));
    pieces.add(new Bishop(1, 0));
    pieces.add(new Knight(2, 0));
    pieces.add(new Queen(3, 0));
    pieces.add(new Knight(5, 0));
    pieces.add(new Bishop(6, 0));
    pieces.add(new Rook(7, 0));
    for (int i = 0; i < 8; ++i)
      pieces.add(new Pawn(i, 1));
  }

  public String
  toString()
  {
    return "White:\n" + super.toString();
  }
}

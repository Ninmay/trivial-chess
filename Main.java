package out;

public class Main {
  public static void main(String[] args) {

    Side[] sides = new Side[2];
    sides[0] = new White();
    sides[1] = new Black();

    int i;
    for (i = 0;; ++i) {
      try {
        sides[(i + 1) % 2].kill(sides[i % 2].move());
      } catch (MateException e) {
        System.out.println(e.getMessage() + " w turze " + i + '.');
        System.out.println("------------------------------");
        System.out.println(sides[0]);
        System.out.println(sides[1]);
        break;
      }
      if (i % 10 == 0) {
        System.out.println("Tura: " + i);
        System.out.println("------------------------------");
        System.out.println(sides[0]);
        System.out.println(sides[1]);
      }
    }

  }
}

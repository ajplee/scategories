import java.util.Random;

public enum Letters {
    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H,
    I,
    J,
    K,
    L,
    M,
    N,
    O,
    P,
    //Q,
    R,
    S,
    T;
    //U;
    //V,
    //W,
    //X,
  //  Y,
 //   Z;

    public static Letters getRandomLetter() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}

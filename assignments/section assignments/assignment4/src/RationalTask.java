import acm.program.*;

public class RationalTask extends ConsoleProgram {

    public void run() {

        setFont("Arial-18");
        Rational r = new Rational(1, 2);
        r = raiseToPower(r, 3);
        println("r ^ 3 = " + r);
    }

    private Rational raiseToPower(Rational x, int n) {
        Rational result = new Rational(1);
        for (int i = 0; i < n; i++) {
            result = result.multiply(x);
        }

        return result;

    }
}

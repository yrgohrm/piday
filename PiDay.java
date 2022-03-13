import java.math.BigInteger;

public class PiDay {
    // Calculate PI until interrupted
    // Based on Jeremy Gibbons unbounded Spigot algorithm
    // Adapted from code found at https://rosettacode.org/, licensed under GFDL 1.2
    public static void main(String[] args) {
        final BigInteger two = BigInteger.TWO;
        final BigInteger three = BigInteger.valueOf(3);
        final BigInteger four = BigInteger.valueOf(4);
        final BigInteger seven = BigInteger.valueOf(7);
        final BigInteger ten = BigInteger.TEN;

        BigInteger q = BigInteger.ONE;
        BigInteger r = BigInteger.ZERO;
        BigInteger t = BigInteger.ONE;
        BigInteger k = BigInteger.ONE;
        BigInteger n = BigInteger.valueOf(3);
        BigInteger l = BigInteger.valueOf(3);

        BigInteger nextN;
        BigInteger nextR;

        while (true) { //NOSONAR
            if (four.multiply(q).add(r).subtract(t).compareTo(n.multiply(t)) < 0) {
                System.out.print(n);
                System.out.flush();
                nextR = ten.multiply(r.subtract(n.multiply(t)));
                n = ten.multiply(three.multiply(q).add(r)).divide(t).subtract(ten.multiply(n));
                q = q.multiply(ten);
                r = nextR;                
            }
            else {
                nextR = two.multiply(q).add(r).multiply(l);
                nextN = q.multiply((seven.multiply(k))).add(two).add(r.multiply(l))
                        .divide(t.multiply(l));
                q = q.multiply(k);
                t = t.multiply(l);
                l = l.add(two);
                k = k.add(BigInteger.ONE);
                n = nextN;
                r = nextR;
            }
        }
    }
}

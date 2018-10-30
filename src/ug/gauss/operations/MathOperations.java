package ug.gauss.operations;

import java.math.BigInteger;

public class MathOperations {

    public static BigInteger calculateNwd(BigInteger a, BigInteger b)
    {
        BigInteger c;
        while (b.compareTo(BigInteger.ZERO) != 0 )
        {
            c = b;
            b = a.mod(b);
            a = c;
        }
        return a;

    }

    public static BigInteger calculateNww(BigInteger a, BigInteger b)
    {
        return a.divide(calculateNwd(a,b)).multiply(b);
    }
}

package ug.gauss.operations;

import java.math.BigInteger;

public class MathOperations {

    public static BigInteger calculateNwd(BigInteger a, BigInteger b)
    {
        return a.gcd(b);
    }

    public static BigInteger calculateNww(BigInteger a, BigInteger b)
    {
        return a.divide(calculateNwd(a,b)).multiply(b);
    }
}

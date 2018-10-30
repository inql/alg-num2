package ug.gauss.datatypes;

import java.math.BigInteger;

public class Fract {
    public BigInteger denominator;
    public BigInteger nominator;

    public Fract(BigInteger nominator, BigInteger denominator) {
        this.denominator = denominator;
        this.nominator = nominator;
    }
    public Fract(){}
}

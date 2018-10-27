package ug.gauss.datatypes;

import java.math.BigInteger;

public class FractionComp implements MatrixCompatible<FractionComp, FractionComp.Fract> {


    class Fract{
        BigInteger denominator;
        BigInteger nominator;

        public Fract(BigInteger denominator, BigInteger nominator) {
            this.denominator = denominator;
            this.nominator = nominator;
        }
    }


    @Override
    public double estimate() {
        return 0;
    }

    @Override
    public Fract getValue() {
        return null;
    }

    @Override
    public void setValue(Fract value) {

    }

    @Override
    public void add(FractionComp fractionComp) {

    }

    @Override
    public void substract(FractionComp fractionComp) {

    }

    @Override
    public void multiply(FractionComp fractionComp) {

    }

    @Override
    public void divide(FractionComp fractionComp) {

    }


}

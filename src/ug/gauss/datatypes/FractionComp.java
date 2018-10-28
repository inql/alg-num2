package ug.gauss.datatypes;

import java.math.BigInteger;

public class FractionComp implements MatrixCompatible<FractionComp, FractionComp.Fract> {


    class Fract{
        BigInteger denominator;
        BigInteger nominator;

        public Fract(BigInteger nominator, BigInteger denominator) {
            this.denominator = denominator;
            this.nominator = nominator;
        }
    }

    Fract fract;



    @Override
    public Fract getValue() {
        return null;
    }

    @Override
    public void setValue(int value) {
        //todo: implement setValue
    }

    public FractionComp(BigInteger nominator, BigInteger denominator)
    {
        fract = new Fract(nominator, denominator);
        Simplify();
    }

    @Override
    public void add(FractionComp fractionComp) {

        BigInteger pom = NWW(fractionComp.fract.denominator, fract.denominator);

        fractionComp.fract.nominator = fractionComp.fract.nominator.multiply(pom.divide(fractionComp.fract.denominator));
        fract.nominator = fract.nominator.multiply(pom.divide(fract.denominator));
        fract.denominator = pom;
        fract.nominator = fract.nominator.add(fractionComp.fract.nominator);
        Simplify();

    }

    @Override
    public void substract(FractionComp fractionComp) {

        BigInteger pom = NWW(fractionComp.fract.denominator, fract.denominator);

        fractionComp.fract.nominator = fractionComp.fract.nominator.multiply(pom.divide(fractionComp.fract.denominator));
        fract.nominator = fract.nominator.multiply(pom.divide(fract.denominator));
        fract.denominator = pom;
        fract.nominator = fract.nominator.subtract(fractionComp.fract.nominator);
        Simplify();
    }

    @Override
    public void multiply(FractionComp fractionComp) {

        this.fract.nominator = this.fract.nominator.multiply(fractionComp.fract.nominator);
        this.fract.denominator = this.fract.denominator.multiply(fractionComp.fract.denominator);
        Simplify();
    }

    @Override
    public void divide(FractionComp fractionComp) {

        BigInteger pom = fractionComp.fract.nominator;
        fractionComp.fract.nominator = fractionComp.fract.denominator;
        fractionComp.fract.denominator = pom;
        multiply(fractionComp);

    }

    @Override
    public String toString()
    {
        return fract.nominator.toString() + " / " + fract.denominator.toString();
    }

    private BigInteger NWD(BigInteger a, BigInteger b)
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

    private BigInteger NWW(BigInteger a, BigInteger b)
    {
        return a.divide(NWD(a,b)).multiply(b);
    }

    private void Simplify()
    {
        BigInteger a = NWD(fract.nominator,fract.denominator);
        fract.nominator = fract.nominator.divide(a);
        fract.denominator = fract.denominator.divide(a);
    }


}

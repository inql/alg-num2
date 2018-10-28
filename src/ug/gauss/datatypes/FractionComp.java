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

    public FractionComp(){

    }

    public FractionComp clone(){
        FractionComp cloned = new FractionComp();
        cloned.setValue(new Fract(this.fract.nominator,this.fract.denominator));
        return cloned;
    }

    /*

    If the FractionComp is equal to the argument then 0 is returned.
    If the FractionComp is less than the argument then -1 is returned.
    If the FractionComp is greater than the argument then 1 is returned.

     */


    Fract fract;

    @Override
    public Fract getValue() {
        return this.fract;
    }

    @Override
    public FractionComp setValue(int value) {
        fract.nominator = new BigInteger(Integer.toString(value));
        return this;
    }

    public void setValue(Fract fract){
        this.fract = fract;
    }

    public FractionComp(BigInteger nominator)
    {
        this(nominator,new BigInteger("65536"));
    }

    public FractionComp(int nominator) {
        this(new BigInteger(Integer.toString(nominator)),new BigInteger("65536"));
    }

    public FractionComp(BigInteger nominator, BigInteger denominator){
        fract = new Fract(nominator,denominator);
        simplify();
    }

    @Override
    public FractionComp add(FractionComp fractionComp) {

        BigInteger pom = NWW(fractionComp.fract.denominator, fract.denominator);

        fractionComp.fract.nominator = fractionComp.fract.nominator.multiply(pom.divide(fractionComp.fract.denominator));
        fract.nominator = fract.nominator.multiply(pom.divide(fract.denominator));
        fract.denominator = pom;
        fract.nominator = fract.nominator.add(fractionComp.fract.nominator);
        simplify();
        return this;

    }

    @Override
    public FractionComp substract(FractionComp fractionComp) {

        BigInteger pom = NWW(fractionComp.fract.denominator, fract.denominator);

        fractionComp.fract.nominator = fractionComp.fract.nominator.multiply(pom.divide(fractionComp.fract.denominator));
        fract.nominator = fract.nominator.multiply(pom.divide(fract.denominator));
        fract.denominator = pom;
        fract.nominator = fract.nominator.subtract(fractionComp.fract.nominator);
        simplify();
        return this;
    }

    @Override
    public FractionComp multiply(FractionComp fractionComp) {

        this.fract.nominator = this.fract.nominator.multiply(fractionComp.fract.nominator);
        this.fract.denominator = this.fract.denominator.multiply(fractionComp.fract.denominator);
        simplify();
        return this;
    }

    @Override
    public FractionComp divide(FractionComp fractionComp) {

        BigInteger pom = fractionComp.fract.nominator;
        fractionComp.fract.nominator = fractionComp.fract.denominator;
        fractionComp.fract.denominator = pom;
        multiply(fractionComp);
        return this;

    }

    @Override
    public String toString()
    {
        return fract.nominator.toString() + " / " + fract.denominator.toString();
    }

    @Override
    public int compareTo(FractionComp fractionComp)
    {
        BigInteger pom = NWW(fractionComp.fract.denominator, fract.denominator);
        BigInteger a = fractionComp.fract.nominator.multiply(pom.divide(fractionComp.fract.denominator));
        BigInteger b = this.fract.nominator.multiply(pom.divide(this.fract.denominator));
        return b.compareTo(a);


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

    private void simplify()
    {
        BigInteger a = NWD(fract.nominator,fract.denominator);
        fract.nominator = fract.nominator.divide(a);
        fract.denominator = fract.denominator.divide(a);
    }


}

package ug.gauss.datatypes;

import ug.gauss.operations.MathOperations;

import java.math.BigInteger;

public class FractionComp implements MatrixCompatible<FractionComp, Fract> {


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


    private Fract fract;

    @Override
    public Fract getValue() {
        return this.fract;
    }

    @Override
    public FractionComp setValue(int value) {
        fract.nominator = new BigInteger(Integer.toString(value));
        simplify();
        return this;
    }

    public void setValue(Fract fract){
        this.fract = fract;
        simplify();
    }

    public FractionComp(BigInteger nominator)
    {
        this(nominator,new BigInteger("65536"));
    }

    public FractionComp(int nominator) {
        this(new BigInteger(Integer.toString(nominator)),new BigInteger("65536"));
        simplify();
    }

    public FractionComp(BigInteger nominator, BigInteger denominator){
        fract = new Fract(nominator,denominator);
        simplify();
    }

    @Override
    public String toString()
    {
        String result = fract.nominator.toString();
        if(!fract.denominator.equals(BigInteger.ONE))
            result+=" / "+fract.denominator.toString();
        return result;
    }

    @Override
    public int compareTo(FractionComp fractionComp)
    {
        BigInteger pom = MathOperations.calculateNww(fractionComp.fract.denominator, fract.denominator);
        BigInteger a = fractionComp.fract.nominator.multiply(pom.divide(fractionComp.fract.denominator));
        BigInteger b = this.fract.nominator.multiply(pom.divide(this.fract.denominator));
        return b.compareTo(a);


    }

    @Override
    public Double getDoubleValue()
    {
        return fract.nominator.doubleValue() / fract.denominator.doubleValue();
    }

    public void simplify()
    {
        BigInteger a = MathOperations.calculateNwd(fract.nominator,fract.denominator);
        fract.nominator = fract.nominator.divide(a);
        fract.denominator = fract.denominator.divide(a);
    }


}

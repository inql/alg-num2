package ug.gauss;

import ug.gauss.datatypes.FractionComp;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        FractionComp fr = new FractionComp(new BigInteger("11"), new BigInteger("16"));
        FractionComp fr2 = new FractionComp(new BigInteger("12"),new BigInteger("40"));
        fr.divide(fr2);
        System.out.println(fr.toString());


    }
}

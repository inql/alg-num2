package ug.gauss;

import ug.gauss.algorithm.ResultGenerator;
import ug.gauss.datatypes.*;
import ug.gauss.operations.DoubleOperation;
import ug.gauss.operations.FloatOperation;
import ug.gauss.operations.FractionOperation;

public class Main {


    public static void main(String[] args) {
        //ResultGenerator<FractionComp> fractionCompResultGenerator = new ResultGenerator<>(2, 2, ChoiceType.PARTIAL,DataType.FRACTION,new FractionOperation());
        //fractionCompResultGenerator.doTests();
        System.out.println("DOUBLE");
        ResultGenerator<DoubleComp> doubleCompResultGenerator = new ResultGenerator<>(3, 2, ChoiceType.FULL,DataType.DOUBLE,new DoubleOperation());
        doubleCompResultGenerator.doTests();
        System.out.println("FLOAT");
        ResultGenerator<DoubleComp> floatCompResultGenerator = new ResultGenerator<>(3, 2, ChoiceType.NONE,DataType.FLOAT,new FloatOperation());
        floatCompResultGenerator.doTests();
    }
}

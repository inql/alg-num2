package ug.gauss;

import ug.gauss.algorithm.ResultGenerator;
import ug.gauss.datatypes.*;
import ug.gauss.operations.DoubleOperation;
import ug.gauss.operations.FloatOperation;
import ug.gauss.operations.FractionOperation;

public class Main {


    public static void main(String[] args) {


        System.out.println("DOUBLE / FULL");
        ResultGenerator<DoubleComp> doubleCompResultGenerator = new ResultGenerator<>(3, 20, ChoiceType.NONE,DataType.DOUBLE,new DoubleOperation());
        doubleCompResultGenerator.doTests();
        System.out.println("FLOAT / NONE");
        ResultGenerator<DoubleComp> floatCompResultGenerator = new ResultGenerator<>(3, 20, ChoiceType.NONE,DataType.FLOAT,new FloatOperation());
        floatCompResultGenerator.doTests();
        System.out.println("FRACTION COMP / PARTIAL");
        ResultGenerator<FractionComp> fractionCompResultGenerator = new ResultGenerator<>(3, 20, ChoiceType.NONE,DataType.FRACTION,new FractionOperation());
        fractionCompResultGenerator.doTests();
    }
}

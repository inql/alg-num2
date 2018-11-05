package ug.gauss;

import ug.gauss.algorithm.ResultGenerator;
import ug.gauss.datatypes.*;
import ug.gauss.operations.FractionOperation;

public class Main {


    public static void main(String[] args) {
        ResultGenerator<FractionComp> fractionCompResultGenerator = new ResultGenerator<>(111, 2, ChoiceType.NONE,DataType.FRACTION,new FractionOperation());
        fractionCompResultGenerator.doTests();
    }
}

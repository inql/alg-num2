package ug.gauss;

import ug.gauss.algorithm.GaussImpl;
import ug.gauss.tests.CsvGenerator;
import ug.gauss.tests.ResultGenerator;
import ug.gauss.datatypes.*;
import ug.gauss.operations.DoubleOperation;
import ug.gauss.operations.FloatOperation;
import ug.gauss.operations.FractionOperation;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        typicalExecution();

    }

    public static void typicalExecution(){
        CsvGenerator csvGenerator = new CsvGenerator(new int[] {2,5,10,20,50});
        csvGenerator.writeCsv();
    }
}

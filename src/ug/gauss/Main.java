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
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) {
        typicalExecution();

    }

    public static void typicalExecution(){
        int[] testScope = new int[50];
        for(int i = 10; i<=500; i+=10){
            testScope[(i/10)-1] = i;
        }
        CsvGenerator csvGenerator = new CsvGenerator(testScope);
        csvGenerator.writeCsv();
    }
}

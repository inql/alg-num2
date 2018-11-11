package ug.gauss.tests;

import ug.gauss.ChoiceType;
import ug.gauss.datatypes.DataType;
import ug.gauss.datatypes.DoubleComp;
import ug.gauss.datatypes.FloatComp;
import ug.gauss.datatypes.FractionComp;
import ug.gauss.operations.DoubleOperation;
import ug.gauss.operations.FloatOperation;
import ug.gauss.operations.FractionOperation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvGenerator {

    private int[] matrixScope;

    public CsvGenerator(int[] matrixScope) {
        this.matrixScope = matrixScope;
    }

    public void writeCsv(){
        String filename = "wynik.csv";

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
            DataType[] dataTypes = {DataType.FLOAT,DataType.DOUBLE,DataType.FRACTION};
            ChoiceType[] choiceTypes = {ChoiceType.NONE,ChoiceType.PARTIAL,ChoiceType.FULL};
            for(DataType dataType : dataTypes){
                bufferedWriter.write(dataType.toString()+"\n\n");
                    bufferedWriter.write("\n"+"n;wybór elementu;błąd bezwzględny;czas wykonania;ilość prób\n");
                    for(int matrixSize : matrixScope){
                        for(ChoiceType choiceType : choiceTypes){
                            if(dataType == DataType.FRACTION)
                                continue;
                            bufferedWriter.write(matrixSize+";"+choiceType+";");
                            bufferedWriter.write(getCalculations(matrixSize,choiceType,dataType)+"\n");
                        }
                        bufferedWriter.write("\n");

                    }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private AggregatedResults getCalculations(int matrixSize, ChoiceType choiceType, DataType dataType){
        ResultGenerator resultGenerator;
        AggregatedResults aggregatedResults = new AggregatedResults();
        int n = 10000/matrixSize;
        for(int i =0; i<3; i++){
            if(dataType==DataType.DOUBLE){
                resultGenerator = new ResultGenerator<DoubleComp>(i+1,matrixSize,choiceType,dataType,new DoubleOperation());
            }
            else if(dataType==DataType.FLOAT)
                resultGenerator = new ResultGenerator<FloatComp>(i+1,matrixSize,choiceType,dataType,new FloatOperation());
            else{
                n /=1000;
                resultGenerator = new ResultGenerator<FractionComp>(i+1,matrixSize,choiceType,dataType,new FractionOperation());
            }
            aggregatedResults.updateAggregatedResults(resultGenerator.doTests());
        }
        aggregatedResults.divideByExecutionCount();

        return aggregatedResults;

    }
}

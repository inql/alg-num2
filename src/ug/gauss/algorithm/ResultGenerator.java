package ug.gauss.algorithm;

import ug.gauss.ChoiceType;
import ug.gauss.MyMatrix;
import ug.gauss.Randomizer;
import ug.gauss.Swapper;
import ug.gauss.datatypes.DataType;
import ug.gauss.datatypes.MatrixCompatible;
import ug.gauss.datatypes.MatrixCompatibleFactory;
import ug.gauss.operations.DataOperation;

import java.math.BigInteger;
import java.util.Arrays;

public class ResultGenerator<T extends MatrixCompatible> {

    private Randomizer randomizer;
    private int matrixSize;
    private ChoiceType choiceType;
    private DataType dataType;
    private final MatrixCompatibleFactory matrixCompatibleFactory;
    private MyMatrix<T> myMatrix;
    private MatrixCompatible[] vectorX;
    private DataOperation dataOperation;
    private GaussImpl gauss;

    public ResultGenerator(int seed, int matrixSize, ChoiceType choiceType, DataType dataType, DataOperation dataOperation) {
        this.randomizer = new Randomizer(seed);
        this.matrixSize = matrixSize;
        this.choiceType = choiceType;
        this.dataType = dataType;
        this.matrixCompatibleFactory = new MatrixCompatibleFactory(dataType);
        this.dataOperation = dataOperation;
        this.gauss = new GaussImpl(myMatrix,matrixCompatibleFactory,dataOperation, choiceType);
        this.myMatrix = generateMatrix(matrixSize);
        this.gauss.myMatrix = this.myMatrix;
    }


    public MyMatrix<T> generateMatrix(int size){
        MatrixCompatible[][] matrix = matrixCompatibleFactory.createMatrix(size,size+1);
        for (int i =0; i<matrix.length; i++){
            for(int j =0; j<matrix[i].length-1; j++){
                matrix[i][j] = matrixCompatibleFactory.createWithNominator(new BigInteger(String.valueOf(randomizer.randomNumber())));
//                matrix[i][j] = matrixCompatibleFactory.createWithDenominator(new BigInteger(i+j+""),BigInteger.ONE);
            }
        }



        this.vectorX = matrixCompatibleFactory.createArray(size);
        for (int i =0; i<vectorX.length; i++){
            vectorX[i] = matrixCompatibleFactory.createWithNominator(new BigInteger(String.valueOf(randomizer.randomNumber())));
//            vectorX[i]= matrixCompatibleFactory.createWithDenominator(new BigInteger(i+""),BigInteger.ONE);
        }
        //tutaj mnożenie
        //temporary xd
        myMatrix = new MyMatrix<T>((T[][]) matrix);


        MatrixCompatible[] vectorB = gauss.MultiplyMatrixWithVector(myMatrix,vectorX);
        for (int i=0; i<matrix.length;i++){
            matrix[i][matrix[i].length-1] = vectorB[i];
        }
        MyMatrix<T> result = new MyMatrix<>((T[][]) matrix);


        return result;
    }

    public void doTests(){

        System.out.println(myMatrix);
        System.out.println(Arrays.deepToString(vectorX));

        long startTime = System.nanoTime();
        // gauss
        gauss.SwitchRowOrColumn(1,1);

        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println("Czas wykonywania " + elapsedTime);


    }


}

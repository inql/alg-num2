package ug.gauss.algorithm;

import ug.gauss.ChoiceType;
import ug.gauss.MyMatrix;
import ug.gauss.Randomizer;
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
        myMatrix = new MyMatrix<T>((T[][]) matrix);


        MatrixCompatible[] vectorB = gauss.multiplyMatrixWithVector(myMatrix,vectorX);
        for (int i=0; i<matrix.length;i++){
            matrix[i][matrix[i].length-1] = vectorB[i];
        }


        return new MyMatrix<>((T[][]) matrix);
    }

    public void doTests(){


        long startTime = System.nanoTime();
        // gauss
        gauss.switchRowOrColumn(1,1);

        MatrixCompatible[] result = gauss.gauss();

        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println(Arrays.deepToString(vectorX));
        System.out.println(Arrays.deepToString(result));
        System.out.println(calculateAbsoluteError(vectorX,result));
        System.out.println("Czas wykonywania (ms)" + elapsedTime/1000000.00);

    }

    private MatrixCompatible calculateAbsoluteError(MatrixCompatible[] goldenVector, MatrixCompatible[] calculatedVector){
        MatrixCompatible absoluteError = matrixCompatibleFactory.createWithNominator(BigInteger.ZERO);
        for(int i = 0; i<goldenVector.length; i++){
            absoluteError = dataOperation.add(absoluteError,dataOperation.subtract(goldenVector[i],calculatedVector[i]));
        }
        return absoluteError;
    }


}

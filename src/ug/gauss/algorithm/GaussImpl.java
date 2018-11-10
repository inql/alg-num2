package ug.gauss.algorithm;

import ug.gauss.ChoiceType;
import ug.gauss.MyMatrix;
import ug.gauss.Randomizer;
import ug.gauss.Swapper;
import ug.gauss.datatypes.MatrixCompatible;
import ug.gauss.datatypes.MatrixCompatibleFactory;
import ug.gauss.operations.DataOperation;


import java.math.BigInteger;

public class GaussImpl {

    public MyMatrix myMatrix;
    final MatrixCompatibleFactory matrixCompatibleFactory;
    final Randomizer rand;
    final DataOperation dataOperation;
    final ChoiceType choiceType;

    public GaussImpl(MyMatrix myMatrix, MatrixCompatibleFactory matrixCompatibleFactory, DataOperation dataOperation, ChoiceType choiceType) {
        this.myMatrix = myMatrix;
        this.matrixCompatibleFactory = matrixCompatibleFactory;
        this.rand = new Randomizer();
        this.dataOperation = dataOperation;
        this.choiceType = choiceType;
    }

//    public MatrixCompatible[] gaussstare() {
//        int n = myMatrix.rows.length;
//        MatrixCompatible[] resultVector = matrixCompatibleFactory.createArray(n);
//        MatrixCompatible m = matrixCompatibleFactory.createWithNominator(new BigInteger("0"));
//        MatrixCompatible temp = matrixCompatibleFactory.createWithNominator(new BigInteger("0"));
//        MatrixCompatible s = matrixCompatibleFactory.createWithNominator(new BigInteger("0"));
//
//        for(int i=1;i<n;i++){
//            for(int j=i+1;j<n+1;j++){
//                m = (MatrixCompatible) myMatrix.getValue(j,i).clone();
//                m = (MatrixCompatible) m.divide(myMatrix.getValue(i,i));
//                m = (MatrixCompatible) m.multiply(matrixCompatibleFactory.createWithDenominator(new BigInteger("-1"),new BigInteger("1")));
//                for(int k =i+1;k<=n+1;k++){
//                    temp = (MatrixCompatible) myMatrix.getValue(i,k).clone();
//                    temp = (MatrixCompatible) temp.multiply(m);
//                    temp = (MatrixCompatible) temp.add(myMatrix.getValue(j,k));
//                    myMatrix.setValue(j,k,temp);
//                }
//            }
//        }
//        for(int i = n;i>=1;i--){
//            s = (MatrixCompatible) myMatrix.getValue(i,n+1).clone();
//            for(int j = n;j>=i+1;j--){
//                temp = (MatrixCompatible) myMatrix.getValue(i,j).clone();
//                temp = (MatrixCompatible) temp.multiply(resultVector[j-1]);
//                s = (MatrixCompatible) s.substract(temp);
//            }
//            temp = (MatrixCompatible) myMatrix.getValue(i,i).clone();
//            s = (MatrixCompatible) s.divide(temp);
//            resultVector[i-1] = s;
//        }
//        return resultVector;
//    }

    @SuppressWarnings("unchecked")
    public MatrixCompatible[] gauss() {
        int n = myMatrix.rows.length;
        MatrixCompatible[] resultVector = matrixCompatibleFactory.createArray(n);
        MatrixCompatible m;
        System.out.println(myMatrix);
        for (int i = 1; i < n; i++) {
            switchRowOrColumn(i+1,i+1);
            for (int j = i + 1; j < n + 1; j++) {
                m = dataOperation.divide(myMatrix.getValue(j, i), myMatrix.getValue(i, i));
                m = dataOperation.multiply(m, matrixCompatibleFactory.createWithDenominator(new BigInteger("-1"), new BigInteger("1")));
                for (int k = i + 1; k <= n + 1; k++) {
                    myMatrix.setValue(j, k, dataOperation.add(
                            dataOperation.multiply(myMatrix.getValue(i, k), m), myMatrix.getValue(j, k))
                    );
                    System.out.println(myMatrix);
                }
            }
        }
        MatrixCompatible s = null;
        MatrixCompatible temp;
        for (int i = n; i >= 1; i--) {
            s = myMatrix.getValue(i,n+1);
            for (int j = n; j >= i + 1; j--) {
                temp = dataOperation.multiply(myMatrix.getValue(i, j), resultVector[myMatrix.columns[j-1]-1]);
                s = dataOperation.subtract(s, temp);
            }
            temp = myMatrix.getValue(i, i);
            s = dataOperation.divide(s, temp);
//            resultVector[i - 1] = s;
            resultVector[myMatrix.columns[i-1]-1] = s;
        }
        return resultVector;
    }


    @SuppressWarnings("unchecked")
    public MyMatrix multiplyMatrices(MyMatrix a, MyMatrix b) {
        int rowLengthA = a.columns.length;
        int rowLengthB = b.columns.length;
        int colLengthA = a.rows.length;
        int colLengthB = b.rows.length;
        if (rowLengthA != colLengthB)
            return null;
        MyMatrix result = new MyMatrix(matrixCompatibleFactory.createMatrix(colLengthA, rowLengthB));
        for (int x = 1; x <= colLengthA; x++) {
            for (int y = 1; y <= rowLengthB; y++) {
                //result[x][y].setValue(x*y);
                result.setValue(x, y, matrixCompatibleFactory.createWithNominator(BigInteger.ZERO));
            }
        }
        for (int x = 1; x <= colLengthA; x++) {
            for (int y = 1; y <= rowLengthB; y++) {
                for (int k = 1; k <= rowLengthA; k++) {
                    result.setValue(x, y, dataOperation.add(result.getValue(x, y), dataOperation.multiply(a.getValue(x, k), b.getValue(k, y))));
                }
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public void switchRowOrColumn(int startX, int startY){


        if(choiceType == ChoiceType.NONE)
            return;

        if (choiceType == ChoiceType.PARTIAL)
        {
            int rowToSwitch = startX;
            for (int i=startX; i <= myMatrix.rows.length; i++)
            {
                if ( dataOperation.abs(myMatrix.getValue(i,startY)).compareTo(dataOperation.abs(myMatrix.getValue(rowToSwitch,startY))) > 0)
                    rowToSwitch = i;

            }

            myMatrix.swap(startX,rowToSwitch, Swapper.ROW);

        } else if (choiceType == ChoiceType.FULL)
        {
            int rowToSwitch = startY;
            int columnToSwitch = startX;
            for (int i=startY; i <= myMatrix.rows.length; i++)
            {
                for (int o=startX; o < myMatrix.columns.length; o++) {

                    if (dataOperation.abs(myMatrix.getValue(i, o)).compareTo(dataOperation.abs(myMatrix.getValue(rowToSwitch, columnToSwitch))) > 0) {
                        rowToSwitch = i;
                        columnToSwitch = o;
                    }
                }

            }
            myMatrix.swap(startX,rowToSwitch, Swapper.ROW);
            myMatrix.swap(startY,columnToSwitch, Swapper.COLUMN);

        }

    }

    @SuppressWarnings("unchecked")
    public MatrixCompatible[] multiplyMatrixWithVector(MyMatrix a, MatrixCompatible[] vector)
    {
        if (a.columns.length-1 != vector.length)
            return null;
        MatrixCompatible[] result = matrixCompatibleFactory.createArray(vector.length);

        for (int i=0; i < vector.length; i++)
            result[i] = matrixCompatibleFactory.createWithNominator(new BigInteger("0"));

        for (int x = 0; x < vector.length; x++)
        {
            for (int y = 0; y < vector.length; y++)
            {
                result[x] = dataOperation.add(result[x], dataOperation.multiply(a.getValue(x + 1, y + 1), vector[y]));

            }

        }


        return result;
    }


}
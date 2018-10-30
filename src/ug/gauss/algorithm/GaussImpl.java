package ug.gauss.algorithm;

import ug.gauss.MyMatrix;
import ug.gauss.Randomizer;
import ug.gauss.datatypes.MatrixCompatible;
import ug.gauss.datatypes.MatrixCompatibleFactory;

import java.math.BigInteger;

public class GaussImpl {

    final MyMatrix myMatrix;
    final MatrixCompatibleFactory matrixCompatibleFactory;
    final Randomizer rand;

    public GaussImpl(MyMatrix myMatrix, MatrixCompatibleFactory matrixCompatibleFactory) {
        this.myMatrix = myMatrix;
        this.matrixCompatibleFactory = matrixCompatibleFactory;
        this.rand = new Randomizer();
    }

    public MatrixCompatible[] gauss() {
        int n = myMatrix.rows.length;
        MatrixCompatible[] resultVector = matrixCompatibleFactory.createArray(n);
        MatrixCompatible m = matrixCompatibleFactory.createWithNominator(new BigInteger("0"));
        MatrixCompatible temp = matrixCompatibleFactory.createWithNominator(new BigInteger("0"));
        MatrixCompatible s = matrixCompatibleFactory.createWithNominator(new BigInteger("0"));

        for(int i=1;i<n;i++){
            for(int j=i+1;j<n+1;j++){
                m = (MatrixCompatible) myMatrix.getValue(j,i).clone();
                m = (MatrixCompatible) m.divide(myMatrix.getValue(i,i));
                m = (MatrixCompatible) m.multiply(matrixCompatibleFactory.createWithDenominator(new BigInteger("-1"),new BigInteger("1")));
                for(int k =i+1;k<=n+1;k++){
                    temp = (MatrixCompatible) myMatrix.getValue(i,k).clone();
                    temp = (MatrixCompatible) temp.multiply(m);
                    temp = (MatrixCompatible) temp.add(myMatrix.getValue(j,k));
                    myMatrix.setValue(j,k,temp);
                }
            }
        }
        for(int i = n;i>=1;i--){
            s = (MatrixCompatible) myMatrix.getValue(i,n+1).clone();
            for(int j = n;j>=i+1;j--){
                temp = (MatrixCompatible) myMatrix.getValue(i,j).clone();
                temp = (MatrixCompatible) temp.multiply(resultVector[j-1]);
                s = (MatrixCompatible) s.substract(temp);
            }
            temp = (MatrixCompatible) myMatrix.getValue(i,i).clone();
            s = (MatrixCompatible) s.divide(temp);
            resultVector[i-1] = s;
        }
        return resultVector;
    }


    public MyMatrix multiplyMatrices(MyMatrix a, MyMatrix b)
    {
        int rowLengthA = a.columns.length;
        int rowLengthB = b.columns.length;
        int colLengthA = a.rows.length;
        int colLengthB = b.rows.length;

        if (rowLengthA != colLengthB)
            return null;
        MyMatrix result = new MyMatrix(matrixCompatibleFactory.createMatrix(colLengthA,rowLengthB));
        // zerowanie tablicy
        for (int x = 1; x <= colLengthA ; x++)
        {
            for (int y = 1; y <= rowLengthB; y++)
            {
                    //result[x][y].setValue(x*y);
                    result.setValue(x,y,matrixCompatibleFactory.createWithNominator(new BigInteger("0")));
            }

        }
        MatrixCompatible tempA;
        MatrixCompatible tempB;

        for (int x = 1; x <= colLengthA ; x++)
        {
            for (int y = 1; y <= rowLengthB; y++)
            {
                for (int k = 1; k <= rowLengthA; k++)
                {
                    tempA = (MatrixCompatible) a.getValue(x,k).clone();
                    tempB = (MatrixCompatible) b.getValue(k,y).clone();
                    result.setValue(x,y,(MatrixCompatible)result.getValue(x,y).add(tempA.multiply(tempB)));
                  //
                }
            }

        }

        return result;
    }
}
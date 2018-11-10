package ug.gauss.datatypes;

import java.math.BigInteger;

public class MatrixCompatibleFactory {

    private DataType dataType;

    public MatrixCompatibleFactory(DataType dataType){
        this.dataType = dataType;
    }

    public MatrixCompatible createWithNominator(BigInteger value){
        if(dataType == DataType.FLOAT){
            return new FloatComp(value.intValue());
        }
        else if(dataType == DataType.DOUBLE){
            return new DoubleComp(value.intValue());
        }
        else if(dataType == DataType.FRACTION){
            return new FractionComp(value);
        }
        else{
            return null;
        }
    }

    public MatrixCompatible createWithDenominator(BigInteger nominator, BigInteger denominator){
        if(dataType == DataType.FLOAT){
            return new FloatComp(nominator.intValue(),denominator.intValue());
        }
        else if(dataType == DataType.DOUBLE){
            return new DoubleComp(nominator.intValue(),denominator.intValue());
        }
        else if(dataType == DataType.FRACTION){
            return new FractionComp(nominator,denominator);
        }
        else{
            return null;
        }
    }

    public MatrixCompatible[] createArray(int length){
        if(dataType == DataType.FLOAT){
            return new FloatComp[length];
        }
        else if(dataType == DataType.DOUBLE){
            return new DoubleComp[length];
        }
        else if(dataType == DataType.FRACTION){
            return new FractionComp[length];
        }
        else{
            return null;
        }
    }

    public MatrixCompatible[][] createMatrix(int x, int y){
        if(dataType == DataType.FLOAT){
            return new FloatComp[x][y];
        }
        else if(dataType == DataType.DOUBLE){
            return new DoubleComp[x][y];
        }
        else if(dataType == DataType.FRACTION){
            return new FractionComp[x][y];
        }
        else{
            return null;
        }
    }

}

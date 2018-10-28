package ug.gauss.datatypes;

import java.math.BigInteger;

public class MatrixCompatibleFactory {

    DataType dataType;

    public MatrixCompatibleFactory(DataType dataType){
        this.dataType = dataType;
    }

    public MatrixCompatible create(BigInteger value){
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

}

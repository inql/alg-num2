package ug.gauss;

import ug.gauss.datatypes.MatrixCompatible;

import java.util.Arrays;


public class MyMatrix<T extends MatrixCompatible> {

    private T[][] matrix;

    public int[] rows;
    public int[] columns;

    public MyMatrix(T[][] matrix) {
        this.matrix = matrix;
        rows = new int[matrix.length];
        columns = new int[matrix.length];
        for(int i=0; i<matrix.length; i++){
            rows[i] = i+1;
            columns[i] = i+1;
        }
    }

    public MyMatrix(){
        rows = new int[10];
        columns = new int[10];
        for(int i=0; i<10; i++){
            rows[i] = i+1;
            columns[i] = i+1;
        }
    }

    public void swap(int from, int to, Swapper swapper){
        int[] toSwap;
        if(swapper == Swapper.ROW)
            toSwap = rows;
        else
            toSwap = columns;
        int fromIndex = 0;
        int toIndex = 0;
        for (int i =0; i<toSwap.length; i++){
            if(toSwap[i]==from)
                fromIndex = i;
            if(toSwap[i]==to)
                toIndex = i;
        }
        toSwap[fromIndex] = to;
        toSwap[toIndex] = from;
    }

    public T getValue(int rowNo, int columnNo){
        try{
            if(columnNo<=0 || rowNo<=0)
                throw new NullPointerException();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        return matrix [rows[rowNo-1]-1][columns[columnNo-1]-1];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i =0; i<matrix.length; i++){
                result.append("[");
            for(int j=0; j<matrix.length; j++){
                result.append(this.getValue(i+1,j+1));
                if(j<matrix.length-1){
                    result.append(", ");
                }
            }
            result.append("]\n");
        }
        return result.toString();
    }
}

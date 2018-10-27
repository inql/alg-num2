package ug.gauss;

import ug.gauss.datatypes.MatrixCompatible;


public class MyMatrix<T extends MatrixCompatible> {

    private T[][] matrix;

    public int[] rows;
    public int[] columns;

    public MyMatrix(T[][] matrix) {
        this.matrix = matrix;
        rows = new int[matrix.length-1];
        columns = new int[matrix.length-1];
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
        for (int i =0; i<toSwap.length; i++){
            if(toSwap[i]==from)
                toSwap[i] = to;
            if(toSwap[i]==to)
                toSwap[i] = from;
        }
    }

    public T getValue(int columnNo, int rowNo){
        try{
            if(columnNo<=0 || rowNo<=0)
                throw new NullPointerException();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        return matrix [rows[rowNo-1]][columns[columnNo-1]];
    }



}

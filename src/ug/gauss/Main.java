package ug.gauss;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        MyMatrix matrix = new MyMatrix();

        System.out.println(Arrays.toString(matrix.columns));

        System.out.println(Arrays.toString(matrix.rows));

        matrix.swap(10,1,Swapper.COLUMN);
        matrix.swap(10,5,Swapper.ROW);

        System.out.println(Arrays.toString(matrix.columns));

        System.out.println(Arrays.toString(matrix.rows));

    }
}

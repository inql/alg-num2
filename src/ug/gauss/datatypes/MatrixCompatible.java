package ug.gauss.datatypes;

public interface MatrixCompatible<T1,T2> extends Comparable<T1> {

    T2 getValue();
    T1 setValue(int value);
    T1 clone();
    int compareTo(T1 t1);

}

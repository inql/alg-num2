package ug.gauss.datatypes;

public interface MatrixCompatible<T1,T2> {

    T2 getValue();
    void setValue(int value);
    void add(T1 t1);
    void substract(T1 t1);
    void multiply(T1 t1);
    void divide(T1 t1);

}

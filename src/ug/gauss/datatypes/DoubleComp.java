package ug.gauss.datatypes;

public class DoubleComp implements MatrixCompatible<DoubleComp,Double>{

    private double value;

    public DoubleComp(int nominator, int denominator) {this.value = (double)nominator/denominator;}

    public DoubleComp(int value) {
        this(value,65536);
    }

    public DoubleComp(){

    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public DoubleComp setValue(int value) {
        this.value = (double)value/65536;
        return this;
    }

    @Override
    public DoubleComp setValue(Double value) {
        this.value = value;
        return this;
    }

    public void setValue(double value){this.value = value;}

    @Override
    public String toString() {
        return Double.toString(value);
    }

    public DoubleComp clone(){
        DoubleComp cloned = new DoubleComp();
        cloned.setValue(this.getValue());
        return cloned;
    }

    @Override
    public Double getDoubleValue() {
        return this.value;
    }
    /*

    If the DoubleComp is equal to the argument then 0 is returned.
    If the DoubleComp is less than the argument then -1 is returned.
    If the DoubleComp is greater than the argument then 1 is returned.

     */

    @Override
    public int compareTo(DoubleComp doubleComp) {
        return this.getValue().compareTo(doubleComp.getValue());
    }
}

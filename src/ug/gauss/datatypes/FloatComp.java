package ug.gauss.datatypes;

public class FloatComp implements MatrixCompatible<FloatComp,Float>{


    private float value;

    public FloatComp(int nominator, int denominator) {this.value = (float)nominator/denominator;}

    public FloatComp(int value) {
        this(value,65536);
    }

    public FloatComp(){

    }

    public FloatComp clone(){
        FloatComp  cloned = new FloatComp();
        cloned.setValue(this.getValue());
        return cloned;
    }

    @Override
    public Double getDoubleValue() {
        return (double) this.value;
    }


    @Override
    public Float getValue() {
        return value;
    }

    @Override
    public FloatComp setValue(int value) {
        this.value = (float)value/65536;
        return this;
    }

    public void setValue(float value) {this.value = value;}

    @Override
    public String toString() {
        return Float.toString(value);
    }

        /*

    If the FloatComp is equal to the argument then 0 is returned.
    If the FloatComp is less than the argument then -1 is returned.
    If the FloatComp is greater than the argument then 1 is returned.

     */


    @Override
    public int compareTo(FloatComp floatComp) {
        return this.getValue().compareTo(floatComp.getValue());
    }
}

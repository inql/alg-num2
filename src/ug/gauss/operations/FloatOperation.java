package ug.gauss.operations;

import ug.gauss.datatypes.FloatComp;

public class FloatOperation implements DataOperation<FloatComp> {
    @Override
    public FloatComp add(FloatComp element1, FloatComp element2) {
        FloatComp result = new FloatComp();
        result.setValue(element1.getValue()+element2.getValue());
        return result;
    }

    @Override
    public FloatComp subtract(FloatComp element1, FloatComp element2) {
        FloatComp result = new FloatComp();
        result.setValue(element1.getValue()-element2.getValue());
        return result;
    }

    @Override
    public FloatComp multiply(FloatComp element1, FloatComp element2) {
        FloatComp result = new FloatComp();
        result.setValue(element1.getValue()*element2.getValue());
        return result;
    }

    @Override
    public FloatComp divide(FloatComp element1, FloatComp element2) {
        FloatComp result = new FloatComp();
        result.setValue(element1.getValue()/element2.getValue());
        return result;
    }
}

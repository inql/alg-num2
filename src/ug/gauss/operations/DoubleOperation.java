package ug.gauss.operations;

import ug.gauss.datatypes.DoubleComp;

public class DoubleOperation implements DataOperation<DoubleComp> {

    @Override
    public DoubleComp add(DoubleComp element1, DoubleComp element2) {
        DoubleComp result = new DoubleComp();
        result.setValue(element1.getValue()+element2.getValue());
        return result;
    }

    @Override
    public DoubleComp subtract(DoubleComp element1, DoubleComp element2) {
        DoubleComp result = new DoubleComp();
        result.setValue(element1.getValue()-element2.getValue());
        return result;
    }

    @Override
    public DoubleComp multiply(DoubleComp element1, DoubleComp element2) {
        DoubleComp result = new DoubleComp();
        result.setValue(element1.getValue()*element2.getValue());
        return result;
    }

    @Override
    public DoubleComp divide(DoubleComp element1, DoubleComp element2) {
        DoubleComp result = new DoubleComp();
        result.setValue(element1.getValue()/element2.getValue());
        return result;
    }
}

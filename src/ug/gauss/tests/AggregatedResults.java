package ug.gauss.tests;

public class AggregatedResults {

    private Results results;
    private long executionCount;

    public AggregatedResults() {
        this.results = new Results(0,0);
        this.executionCount = 0;
    }

    public void updateAggregatedResults(Results values){
        this.results.absoluteError+=values.absoluteError;
        this.results.executionTime+=values.executionTime;
        this.executionCount++;
    }

    public void divideByExecutionCount(){
        this.results.absoluteError/=(double)executionCount;
        this.results.executionTime/=(double)executionCount;
    }

    @Override
    public String toString() {
        return results.toString()+executionCount+";";
    }
}

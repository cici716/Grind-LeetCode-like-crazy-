package src.array;

public class canCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    int totalSum=0;
    int curSum=0;
    int start=0;
        for (int i = 0; i < gas.length; i++) {
            int diff=gas[i]-cost[i];
            totalSum+=diff;
            curSum+=diff;

            if (curSum<0){
                start=i+1;
                curSum=0;
            }
        }
        return totalSum<0?-1:start;
    
    }
}

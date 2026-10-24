class Solution {
    public  int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        //     index  --  1  2  3  4  5  6  7  8  9 10 11 12
        int[]months = {0,31,28,31,30,31,30,31,31,30,31,30,31}; // consider 1 idx base

        int [] preSum = new int[13];
        preSum[1] = months[1];
        for(int i = 2;i < 13;i++){
            preSum[i] = preSum[i-1] + months[i];
        }

        // alice
        int arriveDayAlice = preSum[Integer.parseInt(arriveAlice.substring(0,2) ) - 1] + Integer.parseInt(arriveAlice.substring(3)); // whole 365 day me se
        int leaveDayAlice  = preSum[Integer.parseInt(leaveAlice.substring(0,2) ) - 1]  + Integer.parseInt(leaveAlice.substring(3));

        // bob
        int arriveDayBob = preSum[Integer.parseInt(arriveBob.substring(0,2) ) - 1] + Integer.parseInt(arriveBob.substring(3)); // whole 365 day me se
        int leaveDayBob  = preSum[Integer.parseInt(leaveBob.substring(0,2) ) - 1]  + Integer.parseInt(leaveBob.substring(3));

        int totalDayTogether = Math.min(leaveDayAlice,leaveDayBob) - Math.max(arriveDayAlice,arriveDayBob);

        return totalDayTogether < 0 ? 0 : totalDayTogether + 1;
    }
}
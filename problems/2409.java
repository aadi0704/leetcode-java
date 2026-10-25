class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days ={0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int a1 = daysCount(arriveAlice,days);
        int a2 = daysCount(leaveAlice,days);
        int b1 = daysCount(arriveBob,days);
        int b2 = daysCount(leaveBob,days);


        int start = Math.max(a1,b1);
        int end = Math.min(a2,b2);
        return Math.max(0,end-start+1);        
    }
    public int daysCount(String date,int[] days){
        String[] splitDate = date.split("-");

        int day = Integer.parseInt(splitDate[1]);
        int month = Integer.parseInt(splitDate[0]);

        int total = day;
        for(int i=1;i<month;i++){
            total+=days[i];
        }
        return total;
    }
}
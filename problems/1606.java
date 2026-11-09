class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n = arrival.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        TreeSet<Integer> available = new TreeSet<>();
        for(int i=0;i<k;i++){
            available.add(i);
        }
        int[] count = new int[k];
        long time = 0;
        for(int i=0;i<n;i++){
            while(!pq.isEmpty() &&pq.peek()[0]<=arrival[i]){
                available.add(pq.poll()[1]);
            }
            if(available.isEmpty()) continue;
            int server = i%k;
            Integer need = available.ceiling(server);
            if(need==null){
                need=available.first();
            }
            available.remove(need);
            count[need]++;
            pq.add(new int[]{arrival[i]+load[i],need});
        }
        int max = 0;
        for(int c:count){
            max = Math.max(max,c);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            if(count[i]==max){
                list.add(i);
            }
        }
        return list;

        
    }
}
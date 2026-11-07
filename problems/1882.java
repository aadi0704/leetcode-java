class Solution {
    class Server{
        int weight;
        int index;
        Server(int weight,int index){
            this.weight=weight;
            this.index = index;
        }
    }
    class Busy{
        long endTime;
        int weight;
        int index;
        Busy(long endTime,int weight,int index){
            this.endTime = endTime;
            this.weight = weight;
            this.index = index;
        }
    }
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = tasks.length;
        PriorityQueue<Server> free = new PriorityQueue<>((a,b)->{
            if(a.weight!=b.weight) return a.weight-b.weight;
            return a.index-b.index;
        });
        for(int i=0;i<servers.length;i++){
            free.offer(new Server(servers[i],i));
        }
        PriorityQueue<Busy> busy = new PriorityQueue<>((a,b)->{
            if(a.endTime!=b.endTime) return Long.compare(a.endTime,b.endTime);
            if(a.weight!=b.weight) return a.weight-b.weight;
            return a.index-b.index;
        });


        int[] ans = new int[n];
        long time = 0;
        for(int i=0;i<n;i++){
            time = Math.max(time,i);
            while(!busy.isEmpty() && busy.peek().endTime<=time){
                Busy task = busy.poll();
                free.add(new Server(task.weight,task.index));
            }

            if(free.isEmpty()){
                time = busy.peek().endTime;
                 while(!busy.isEmpty() && busy.peek().endTime<=time){
                    Busy task = busy.poll();
                    free.add(new Server(task.weight,task.index));
                }

            }
            Server s = free.poll();
            ans[i]=s.index;
            busy.add(new Busy(time+tasks[i],s.weight,s.index));
        }

    return ans;
    }
}
class Pair {
    int vertex, weight, count;

    Pair(int vertex, int weight, int count) {
        this.vertex = vertex;
        this.weight = weight;
        this.count = count;
    }
}

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {

        if (k == 0) return -1;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(v, w, 0));
        }

        int[][] dist = new int[n][k + 1];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a.weight)
        );

        dist[0][1] = 0;
        pq.add(new Pair(0, 0, 1));

        while (!pq.isEmpty()) {

            Pair x = pq.poll();

            int cur = x.vertex;
            int cost = x.weight;
            int count = x.count;

            if (cost != dist[cur][count]) {
                continue;
            }

            if (cur == n - 1) {
                return cost;
            }

            for (Pair p : adj.get(cur)) {

                int neighbour = p.vertex;
                int weight = p.weight;

                int newCount;

                if (labels.charAt(cur) == labels.charAt(neighbour)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                if (newCount > k) {
                    continue;
                }

                int newCost = cost + weight;

                if (newCost < dist[neighbour][newCount]) {

                    dist[neighbour][newCount] = newCost;

                    pq.add(new Pair(
                        neighbour,
                        newCost,
                        newCount
                    ));
                }
            }
        }

        return -1;
    }
}
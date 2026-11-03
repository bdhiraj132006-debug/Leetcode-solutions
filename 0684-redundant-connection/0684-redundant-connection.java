class Solution {
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1]; // nodes are labeled 1..n, so index 0 is unused
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int a = find(edge[0]);
            int b = find(edge[1]);

            if (a == b) {
                return edge; // already connected, so this edge makes a cycle
            }

            parent[b] = a; // merge the two groups
        }

        return new int[0];
    }

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]; // shortcut: skip a level
            x = parent[x];
        }
        return x;
    }
}
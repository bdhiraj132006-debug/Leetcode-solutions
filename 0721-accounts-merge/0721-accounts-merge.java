class Solution {
    private int[] parent;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        for(int i = 0; i < n; i++)
        {
            parent[i] = i;
        }

        Map<String, Integer> emailToAccount = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++)
            {
                String email = account.get(j);
                if(emailToAccount.containsKey(email))
                {
                    union(i, emailToAccount.get(email));
                }
                else
                {
                    emailToAccount.put(email, i);
                }
            }
        }

        Map<Integer, TreeSet<String>> groups = new HashMap<>();
        for(Map.Entry<String, Integer> entry : emailToAccount.entrySet())
        {
            int root = find(entry.getValue());
            groups.computeIfAbsent(root, k -> new TreeSet<>()).add(entry.getKey());
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<Integer, TreeSet<String>> entry : groups.entrySet())
        {
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(entry.getKey()).get(0));
            merged.addAll(entry.getValue());
            result.add(merged);
        }
        return result;
    }

    private int find(int x)
    {
        while(parent[x] != x)
        {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private void union(int a, int b)
    {
        parent[find(a)] = find(b);
    }
}
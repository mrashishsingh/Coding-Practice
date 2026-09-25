class Solution {
    public List<String> braceExpansionII(String expression) {
        TreeSet<String> ans = new TreeSet<>();
        List<List<String>> groups = new ArrayList<>();
        groups.add(new ArrayList<>());
        
        int layer = 0;
        int left = 0;
        
        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if (c == '{') {
                if (layer == 0) {
                    left = i + 1;
                }
                layer++;
            } else if (c == '}') {
                layer--;
                if (layer == 0) {
                    merge(groups, braceExpansionII(expression.substring(left, i)));
                }
            } else if (c == ',' && layer == 0) {
                groups.add(new ArrayList<>());
            } else if (layer == 0) {
                merge(groups, new ArrayList<>(List.of(String.valueOf(c))));
            }
        }
        
        for (List<String> group : groups) {
            ans.addAll(group);
        }
        return new ArrayList<>(ans);
    }
    
    private void merge(List<List<String>> groups, List<String> group) {
        if (groups.get(groups.size() - 1).isEmpty()) {
            groups.set(groups.size() - 1, group);
            return;
        }
        List<String> mergedGroup = new ArrayList<>();
        for (String word1 : groups.get(groups.size() - 1)) {
            for (String word2 : group) {
                mergedGroup.add(word1 + word2);
            }
        }
        groups.set(groups.size() - 1, mergedGroup);
    }
}
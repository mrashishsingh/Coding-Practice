class Solution {
    Map<Node,Node> map=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        if(map.containsKey(node)) return map.get(node);
        Node c=new Node(node.val);
        map.put(node,c);
        for(Node n:node.neighbors) c.neighbors.add(cloneGraph(n));
        return c;
    }
}
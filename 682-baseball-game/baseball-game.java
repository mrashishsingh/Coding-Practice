class Solution {
    public int calPoints(String[] o) {
        Stack<Integer> s = new Stack<>();
        for (String x : o) {
            if (x.equals("+")) {
                int a = s.pop(), b = s.peek();
                s.push(a);
                s.push(a + b);
            } else if (x.equals("D")) {
                s.push(s.peek() * 2);
            } else if (x.equals("C")) {
                s.pop();
            } else {
                s.push(Integer.parseInt(x));
            }
        }
        int ans = 0;
        while (!s.isEmpty()) ans += s.pop();
        return ans;
    }
}
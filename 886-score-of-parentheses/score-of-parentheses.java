class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(0);
            } else {
                int x = st.pop();
                int val = x == 0 ? 1 : 2 * x;
                st.push(st.pop() + val);
            }
        }

        return st.pop();
    }
}
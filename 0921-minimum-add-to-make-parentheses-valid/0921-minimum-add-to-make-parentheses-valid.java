class Solution {
    public int minAddToMakeValid(String s) {
        int result = 0;

        Stack<Boolean> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(true);
            } else {
                if (stack.isEmpty()) {
                    result++;
                } else {
                    stack.pop();
                }
            }
        }
        result += stack.size();

        return result;
    }
}
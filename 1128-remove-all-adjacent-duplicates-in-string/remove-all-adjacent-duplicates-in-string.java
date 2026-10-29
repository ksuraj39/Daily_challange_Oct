class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            boolean flag = true;
            while(!st.isEmpty() && st.peek() == ch){
                flag = false;
                st.pop();
            }
            if(flag){
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
        
    }
}
class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();

        int num  = 0;
        int res  = 0;
        int sign = 1;


        for(char ch : s.toCharArray()){

            if(Character.isDigit(ch)){
                int digit = (ch - '0');
                num = num*10 + digit;
            }else if(ch == '+'){
                res += num * sign;
                num  = 0;
                sign = 1;
            }else if(ch == '-'){
                res += num * sign;
                num  = 0;
                sign = -1;
            }else if(ch == '('){
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            }else if(ch == ')'){
                res += num*sign;
                num = 0;
                res *= st.pop();
                res += st.pop();
                sign = 1;
            }
        }
        res += num * sign;
        return res;

        /*
        "1 + 1"
        num = 0;
        sign = 1;
        res += 1 * 1 == res = 1;

        res += num * sign

        */
    }
}
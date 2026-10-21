class Solution {
    public int minOperations(String s) {
        int n = s.length();

        if(isSorted(s)) return 0;
        if(n == 2) return -1;

        char min = min_Element(s,0,n-1);
        char max = max_Element(s,0,n-1);
        if(s.charAt(0) == min || s.charAt(n-1) == max) return 1;

        char min_mid = min_Element(s,1,n-2);
        char max_mid = max_Element(s,1,n-2);

        if(s.charAt(0) > max_mid && s.charAt(n-1) < min_mid) return 3;
        return 2;
    }

    public char min_Element(String s, int i,int n){
        char res = s.charAt(i);

        for(i = 1 ;i <= n ;i++){
            if(s.charAt(i) < res){
                res = s.charAt(i);
            }
        }
        return res;
    }

    public char max_Element(String s, int i,int n){
        char res = s.charAt(i);

        for(i = 1 ;i <= n ;i++){
            if(s.charAt(i) > res){
                res = s.charAt(i);
            }
        }
        return res;
    }

    public boolean isSorted(String s){

        for(int i = 1;i < s.length();i++){

            if(s.charAt(i-1) > s.charAt(i)) return false;
        }
        return true;
    }
}
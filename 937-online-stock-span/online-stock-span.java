class StockSpanner {
    Stack<int[]> span;
    public StockSpanner() {
        span = new Stack<>();
    }
    
    public int next(int price) {
        int cnt = 1;
        while(!span.isEmpty() && span.peek()[0] <= price){
            cnt += span.pop()[1];
        }
        span.push(new int[]{price,cnt});
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
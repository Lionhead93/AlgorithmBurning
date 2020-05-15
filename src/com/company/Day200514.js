const maxProfit = function (prices) {

    let answer = 0;

    for (let i = 0; i < prices.length; i++) {

        let max = 0;

        for (let j = i + 1; j < prices.length; j++) {
            if(prices[i] < prices[j]) {
                max = ( prices[j] - prices[i] > max ) ?  prices[j] - prices[i] : max;
            }
        }
        answer = ( max > answer ) ? max : answer;

    }
    return answer;

};

var maxProfit2 = function(prices) {
    let min = Number.MAX_VALUE; // the min value so far
    let max = 0; // max profit
    for (let i = 0; i < prices.length; i++) {
        min = Math.min(min, prices[i]);
        max = Math.max(max, prices[i]-min);
    }
    return max;
};

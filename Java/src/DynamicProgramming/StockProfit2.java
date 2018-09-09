package DynamicProgramming;

//Calculating Max Profit from buying, selling stock
public class StockProfit2 {

    static int hold = 0;
    static int change = 0;
    static int ans = 0;

    public static void main(String[] args) {
        int[] stock = {10, 100, 0, 20};

        for (int i = 0; i < stock.length; i++) {
            change = stock[i] - stock[hold];
            if (change > ans)
                ans = change;

            if (change < 0) {
                hold = i;
                change = 0;
            }

        }

        System.out.println(ans);
    }

}

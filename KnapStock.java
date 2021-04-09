public class KnapStock {
    public static void main (String[] args) {
        // case of 0-1 Knapsack
        int saving = 250;
        int[] current = {175, 133, 109, 210, 97};
        int[] future = {200, 125, 128, 228, 133}; // goal: return 55 because optimal investments are 109 and 97

        System.out.println("Max profit with respect to saving: " + selectStock(saving, current, future)); // recursive
        System.out.println("Max profit with respect to saving: " + selectStockMemo(saving, current, future)); // dp
    }

    // recursive solution (brute force)
    static int selectStock(int saving, int[] currentValues, int[] futureValues) {
        int[] profits = new int[currentValues.length];
        
        for (int i = 0; i < futureValues.length; i++) {
            profits[i] = futureValues[i] - currentValues[i];
        }

        int currMax = 0;
        int index = 0;
        
        return selectStockRecurse(saving, currentValues, profits, currMax, index);
    }

    static int selectStockRecurse(int saving, int[] currentValues, int[] profits, int currMax, int index) {
        if (index == currentValues.length) {
            return currMax;
        }

        int maxProfitWithoutIndex = selectStockRecurse(saving, currentValues, profits, currMax, index+1);

        int newSavings = saving - currentValues[index];
        boolean canAfford = newSavings >= 0;
        if (!canAfford) {
            return maxProfitWithoutIndex;
        }

        // include index
        int newProfit = currMax + profits[index];
        int maxProfitWithIndex = selectStockRecurse(newSavings, currentValues, profits, newProfit, index+1);

        return max(maxProfitWithIndex, maxProfitWithoutIndex);
    }

    static int max(int a, int b) {
        if (a < b) {
            return b;
        }
        return a;
    }


    // =====================================================================================

    
    // dynamic programming solution (optimal)
    static int selectStockMemo(int saving, int[] currentValues, int[] futureValues) {
        // rows = 0 .. savings
        // columns = include stock or not

        int[][] table = new int[currentValues.length][];
        for (int i = 0; i < table.length; i++) {
            table[i] = new int[saving+1];
        }

        int[] profits = new int[currentValues.length];
        for (int i = 0; i < futureValues.length; i++) {
            profits[i] = futureValues[i] - currentValues[i];
        }

        // calculate if we can afford first stock
        for (int currSaving = 1; currSaving <= saving; currSaving++) {
            int profit = profits[0];
            if (currSaving >= currentValues[0]) {
                table[0][currSaving] = profit;
            }
        }

        // calculate rest of table
        for (int stockIndex = 1; stockIndex < table.length; stockIndex++) {
            for (int currSaving = 1; currSaving <= saving; currSaving++) {
                int currentStock = currentValues[stockIndex];
                if (currentStock <= currSaving) {
                    table[stockIndex][currSaving] = max(table[stockIndex-1][currSaving], table[stockIndex-1][currSaving-currentStock]+profits[stockIndex]);
                }
                else {
                    table[stockIndex][currSaving] = table[stockIndex-1][currSaving];
                }
            }
        }

        return table[currentValues.length-1][saving];

    }

}
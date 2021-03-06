package cci;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class CoinChange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        LinkedList<Integer> coins = new LinkedList<>();
        for (int coins_i = 0; coins_i < m; coins_i++) {
            coins.add(in.nextInt());
        }

        System.out.println(coinChange(n, coins, m, new HashMap<>(m)));
    }

    static long coinChange(int n, LinkedList<Integer> coins, int size, Map<String, Long> memorise) {
        if (n == 0) {
            return 1;
        } else if (n > 0 && !coins.isEmpty()) {
            final LinkedList<Integer> tail = new LinkedList<>(coins);
            tail.removeFirst();

            final Integer coin = coins.peek();
            final int index = size - coins.size();
            final String key = n + "-" + index;

            Long value = memorise.get(key);
            if (value == null) {
                value = coinChange(n - coin, coins, size, memorise) + coinChange(n, tail, size, memorise);
                memorise.put(key, value);
            }
            return value;
        } else {
            return 0;
        }
    }
}

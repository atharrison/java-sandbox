package atharrison.sandbox.projecteuler;

import java.math.BigInteger;
import java.util.*;

/**
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 It is possible to make £2 in the following way:

 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 How many different ways can £2 be made using any number of coins?
 */
public class Problem31 {

    enum Coin {
        ONE_PENCE(1),
        TWO_PENCE(2),
        FIVE_PENCE(5),
        TEN_PENCE(10),
        TWENTY_PENCE(20),
        FIFTY_PENCE(50),
        ONE_POUND(100),
        TWO_POUNDS(200);

        Coin(int value) {
            this.value = value;
        }
        public int value;

    }

    public int solve() {
        Coin[] coins = Coin.values();
        int[] coinCounts;

        List<String> results = new LinkedList<>();
        int value;
        for(int a = 0; coins[7].value* a <= 200; a++) {
            for(int b = 0; coins[6].value*b <= 200; b++ ) {
                for (int c = 0; coins[5].value * c <= 200; c++) {
                    for (int d = 0; coins[4].value * d <= 200; d++) {
                        for (int e = 0; coins[3].value * e <= 200; e++) {
                            for (int f = 0; coins[2].value * f <= 200; f++) {
                                for (int g = 0; coins[1].value * g <= 200; g++) {
                                    for (int h = 0; coins[0].value * h <= 200; h++) {
                                        coinCounts = new int[]{h,g,f,e,d,c,b,a};
                                        value = value(coins, coinCounts);
                                        if(value == 200) {
                                            results.add(stringify(coinCounts));
                                            System.out.println("-> " + stringify(coinCounts));
                                        } else if (value > 200) { break; }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

//        for(String result : results) {
//            System.out.println(result);
//        }
//        System.out.println(results);
        return results.size();
    }


    public int value(Coin[] coins, int[] coinCounts) {
        int result = 0;
        for(int idx = 0; idx < coins.length; idx++) {
            result += coins[idx].value * coinCounts[idx];
        }
        return result;
    }

    public String stringify(int[] coinCounts) {
        StringBuilder buf = new StringBuilder();
        for(int count: coinCounts) {
            buf.append(count).append(",");
        }
        return buf.toString().substring(0, buf.length() -1);
    }
}

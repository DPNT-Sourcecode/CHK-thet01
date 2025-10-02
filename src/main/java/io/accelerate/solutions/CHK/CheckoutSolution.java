package io.accelerate.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    private static final Map<Character, Integer> SKU_TO_PRICE = Map.ofEntries(
        Map.entry('A', 50),
        Map.entry('B', 30),
        Map.entry('C', 20),
        Map.entry('D', 15),
        Map.entry('E', 40),
        Map.entry('F', 10),
        Map.entry('G', 20),
        Map.entry('H', 10),
        Map.entry('I', 35),
        Map.entry('J', 60),
        Map.entry('K', 70),
        Map.entry('L', 90),
        Map.entry('M', 15),
        Map.entry('N', 40),
        Map.entry('O', 10),
        Map.entry('P', 50),
        Map.entry('Q', 30),
        Map.entry('R', 50),
        Map.entry('S', 20),
        Map.entry('T', 20),
        Map.entry('U', 40),
        Map.entry('V', 50),
        Map.entry('W', 20),
        Map.entry('X', 17),
        Map.entry('Y', 20),
        Map.entry('Z', 21)
    );

    public Integer checkout(String skus) {
        Map<Character, Integer> skuCounts = new HashMap<>();
        int total = 0;
        for (char c : skus.toCharArray()) {
            if (SKU_TO_PRICE.get(c) == null) {
                return -1;
            }
            skuCounts.put(c, skuCounts.getOrDefault(c, 0) + 1);
            total += SKU_TO_PRICE.get(c);
        }

        int eDiscount = 0;
        while (skuCounts.getOrDefault('B', 0) > 0 && skuCounts.getOrDefault('E', 0) > 1) {
            eDiscount += 30;
            skuCounts.put('B', skuCounts.get('B') - 1);
            skuCounts.put('E', skuCounts.get('E') - 2);
        }

        int nDiscount = 0;
        while (skuCounts.getOrDefault('M', 0) > 0 && skuCounts.getOrDefault('N', 0) > 2) {
            nDiscount += 15;
            skuCounts.put('M', skuCounts.get('M') - 1);
            skuCounts.put('N', skuCounts.get('N') - 3);
        }

        int rDiscount = 0;
        while (skuCounts.getOrDefault('Q', 0) > 0 && skuCounts.getOrDefault('R', 0) > 2) {
            rDiscount += 30;
            skuCounts.put('Q', skuCounts.get('Q') - 1);
            skuCounts.put('R', skuCounts.get('R') - 3);
        }

        int initialADiscount = (skuCounts.getOrDefault('A', 0) / 5) * 50;
        skuCounts.put('A', skuCounts.getOrDefault('A', 0) - (skuCounts.getOrDefault('A', 0) / 5) * 5);

        int initialHDiscount = (skuCounts.getOrDefault('H', 0) / 10) * 20;
        skuCounts.put('H', skuCounts.getOrDefault('H', 0) - (skuCounts.getOrDefault('H', 0) / 10) * 10);

        int initialVDiscount = (skuCounts.getOrDefault('V', 0) / 3) * 20;
        skuCounts.put('V', skuCounts.getOrDefault('V', 0) - (skuCounts.getOrDefault('V', 0) / 3) * 3);

        int finalDiscount = 0;
        while (skuCounts.getOrDefault('S', 0) + skuCounts.getOrDefault('T', 0) + skuCounts.getOrDefault('X', 0) + skuCounts.getOrDefault('Y', 0) + skuCounts.getOrDefault('Z', 0) > 2) {
            int items = 0, price = 0;
            while (items < 2) {
                if (skuCounts.getOrDefault('Z', 0) > 0) {
                    items++;
                    price += skuCounts.get('Z');
                    skuCounts.put('Z', skuCounts.get('Z') - 1);
                }
                else if (skuCounts.getOrDefault('Y', 0) > 0) {
                    items++;
                    price += skuCounts.get('Y');
                    skuCounts.put('Y', skuCounts.get('Y') - 1);
                }
                else if (skuCounts.getOrDefault('X', 0) > 0) {
                    items++;
                    price += skuCounts.get('X');
                    skuCounts.put('X', skuCounts.get('X') - 1);
                }
                else if (skuCounts.getOrDefault('Z', 0) > 0) {
                    items++;
                    price += skuCounts.get('Z');
                    skuCounts.put('Y', skuCounts.get('Y') - 1);
                }
                else if (skuCounts.getOrDefault('X', 0) > 0) {
                    items++;
                    price += skuCounts.get('X');
                    skuCounts.put('X', skuCounts.get('X') - 1);
                } else {
                    break;
                }
            }
        }

        int discount = initialADiscount + ((skuCounts.getOrDefault('A', 0) / 3) * 20) + ((skuCounts.getOrDefault('B', 0) / 2) * 15) +
            eDiscount + ((skuCounts.getOrDefault('F', 0) / 3) * 10) + initialHDiscount + ((skuCounts.getOrDefault('H', 0) / 5) * 5) +
            ((skuCounts.getOrDefault('K', 0) / 2) * 20) + nDiscount + ((skuCounts.getOrDefault('P', 0) / 5) * 50) + ((skuCounts.getOrDefault('Q', 0) / 3) * 10)
            + rDiscount + ((skuCounts.getOrDefault('U', 0) / 4) * 40) + initialVDiscount + ((skuCounts.getOrDefault('V', 0) / 2) * 10) + finalDiscount;

        return total - discount;
    }
}



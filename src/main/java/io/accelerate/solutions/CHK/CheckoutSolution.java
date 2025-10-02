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
        Map.entry('K', 80),
        Map.entry('L', 90),
        Map.entry('M', 15),
        Map.entry('N', 40),
        Map.entry('O', 10),
        Map.entry('P', 50),
        Map.entry('Q', 30),
        Map.entry('R', 50),
        Map.entry('S', 30),
        Map.entry('T', 20),
        Map.entry('U', 40),
        Map.entry('V', 50),
        Map.entry('W', 20),
        Map.entry('X', 90),
        Map.entry('Y', 10),
        Map.entry('Z', 50)
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

        int discount = initialADiscount + ((skuCounts.getOrDefault('A', 0) / 3) * 20) + ((skuCounts.getOrDefault('B', 0) / 2) * 15) +
            eDiscount + ((skuCounts.getOrDefault('F', 0) / 3) * 10) + initialHDiscount + ((skuCounts.getOrDefault('H', 0) / 5) * 5) +
            ((skuCounts.getOrDefault('K', 0) / 2) * 10) + nDiscount + ((skuCounts.getOrDefault('P', 0) / 5) * 50) + ((skuCounts.getOrDefault('Q', 0) / 3) * 10)
            + rDiscount + ((skuCounts.getOrDefault('U', 0) / 4) * 40) + initialVDiscount + ((skuCounts.getOrDefault('V', 0) / 2) * 10);

        return total - discount;
    }
}


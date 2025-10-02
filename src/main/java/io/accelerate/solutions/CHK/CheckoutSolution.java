package io.accelerate.solutions.CHK;

import java.util.Map;

public class CheckoutSolution {
    private static final Map<Character, Integer> SKU_TO_PRICE = Map.of(
            'A', 50,
            'B', 30,
            'C', 20,
            'D', 15,
            'E', 40
    );
    public Integer checkout(String skus) {
        int total = 0, aCount = 0, bCount = 0, eCount = 0;
        for (char c : skus.toCharArray()) {
            if (SKU_TO_PRICE.get(c) == null) {
                return -1;
            }
            if (c == 'A') aCount++;
            else if (c == 'B') bCount++;
            else if (c == 'E') eCount++;
            total += SKU_TO_PRICE.get(c);
        }
        bCount -= (eCount / 2);
        int aDiscount = Math.max((aCount / 3) * 20, (aCount / 5) * 50);
        int discount = aDiscount + ((bCount / 2) * 15) + ((eCount / 2) * 30);
        return total - discount;
    }
}


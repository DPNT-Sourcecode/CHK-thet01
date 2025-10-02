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
        int total = 0, aCount = 0, bCount = 0;
        for (char c : skus.toCharArray()) {
            if (SKU_TO_PRICE.get(c) == null) {
                return -1;
            }
            if (c == 'A') aCount++;
            else if (c == 'B') bCount++;
            total += SKU_TO_PRICE.get(c);
        }
        int discount = ((aCount / 3) * 20) + ((bCount / 2) * 15);
        return total - discount;
    }
}





package io.accelerate.solutions.CHK;

import java.util.Map;

public class CheckoutSolution {
    private static final Map<Character, Integer> SKU_TO_PRICE = Map.of(
            'A', 50,
            'B', 30,
            'C', 75,
            'D', 3,
            'E', 17
    );
    public Integer checkout(String skus) {
        int total = 0;
        for (char c : skus.toCharArray()) {
            if (!Character.isLetter(c)) {
                continue;
            }
            total += (c - 'A');
        }
        return total;
    }
}




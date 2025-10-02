package io.accelerate.solutions.CHK;

import java.util.Map;

public class CheckoutSolution {
    private static final Map<Character, Integer> SKU_TO_PRICE = Map.of(
            'A', 50,
            'B', 30,
            'C', 20,
            'D', 15,
            'E', 40,
            'F', 10
    );
    private static final Map<Character, Integer> SKU_TO_PRICE_2 = Map.of(
        Map.entry('A', 50),
        Map.entry('B', 30),
        Map.entry('C', 20),
        Map.entry('D', 15),
        Map.entry('E', 40),
        Map.entry('F', 10)
    );
        'A', 50,
        'B', 30,
        'C', 20,
        'D', 15,
        'E', 40,
        'F', 10,
        'G', 20,
        'H', 10,
        'I', 35,
        'J', 60,
        'K', 80,
        'L', 90,
        'M', 15,
        'N', 40,
        'O', 10,
        'P', 50,
        'Q', 30,
        'R', 50,
        'S', 30,
        'T', 20,
        'U', 40,
        'V', 50,
        'W', 20,
        'X', 90,
        'Y', 10,
        'Z', 50
    );
    public Integer checkout(String skus) {
        int total = 0, aCount = 0, bCount = 0, eCount = 0, fCount = 0;
        for (char c : skus.toCharArray()) {
            if (SKU_TO_PRICE.get(c) == null) {
                return -1;
            }
            if (c == 'A') aCount++;
            else if (c == 'B') bCount++;
            else if (c == 'E') eCount++;
            else if (c == 'F') fCount++;
            total += SKU_TO_PRICE.get(c);
        }

        int eDiscount = 0;
        while (bCount > 0 && eCount > 1) {
            eDiscount += 30;
            bCount --;
            eCount -= 2;
        }

        int initialADiscount = (aCount / 5) * 50;
        aCount -= (aCount / 5) * 5;

        int fDiscount = ((fCount / 3) * 10);

        int discount = initialADiscount + ((aCount / 3) * 20) + ((bCount / 2) * 15) + eDiscount + ((fCount / 3) * 10);
        return total - discount;
    }
}


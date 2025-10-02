package io.accelerate.solutions.CHK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionTest {
    CheckoutSolution total;

    @BeforeEach
    public void setUp() {
        total = new CheckoutSolution();
    }

    @Test
    public void checkout() {

        assertThat(total.checkout("EEEEBB"), equalTo(160));
        assertThat(total.checkout("AAAAA"), equalTo(200));
        assertThat(total.checkout("AAAAAAAA"), equalTo(330));
        assertThat(total.checkout("AAAAAAAAA"), equalTo(380));
        assertThat(total.checkout("EE"), equalTo(80));
    }
}





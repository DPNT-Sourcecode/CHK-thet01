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

        assertThat(total.checkout("BBEE"), equalTo(110));
    }
}



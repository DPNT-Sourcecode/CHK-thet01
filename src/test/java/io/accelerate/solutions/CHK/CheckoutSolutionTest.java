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

        assertThat(total.checkout("AAA"), equalTo(130));
        assertThat(total.checkout("AAAAA"), equalTo(200));
        assertThat(total.checkout("AAAAAAAA"), equalTo(330));
        assertThat(total.checkout("BB"), equalTo(45));
        assertThat(total.checkout("EEB"), equalTo(80));
        assertThat(total.checkout("EEEEBB"), equalTo(160));
        assertThat(total.checkout("FFF"), equalTo(20));
        assertThat(total.checkout("FF"), equalTo(20));
        assertThat(total.checkout("HHHHH"), equalTo(45));
        assertThat(total.checkout("HHHHHHHHHH"), equalTo(80));
        assertThat(total.checkout("HHHHHHHHHHHHHHH"), equalTo(125));
        assertThat(total.checkout("NNM"), equalTo(95));
        assertThat(total.checkout("NNNM"), equalTo(120));
        assertThat(total.checkout("NNNNNNMM"), equalTo(240));
        assertThat(total.checkout("PPPPP"), equalTo(200));
        assertThat(total.checkout("QQQ"), equalTo(80));
        assertThat(total.checkout("RRRQ"), equalTo(150));
        assertThat(total.checkout("RRRQQ"), equalTo(180));
        assertThat(total.checkout("UUUU"), equalTo(120));
        assertThat(total.checkout("UUU"), equalTo(120));
        assertThat(total.checkout("VV"), equalTo(90));
        assertThat(total.checkout("VVV"), equalTo(130));
        assertThat(total.checkout("VVVVV"), equalTo(220));
        assertThat(total.checkout("YYY"), equalTo(45));
        assertThat(total.checkout("XXX"), equalTo(45));
        assertThat(total.checkout("ZZZ"), equalTo(45));
        assertThat(total.checkout("SSS"), equalTo(45));
        assertThat(total.checkout("TTT"), equalTo(45));
        assertThat(total.checkout("XYZ"), equalTo(45));
        assertThat(total.checkout("ZZYYY"), equalTo(85));
    }
}


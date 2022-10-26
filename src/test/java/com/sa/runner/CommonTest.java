package com.sa.runner;

import org.junit.Test;

public class CommonTest {
    @Test
    public void testMain(){
        Runner.main(null);
    }

    @Test
    public void testDoubleMain(){
        Runner.main(null);
        Runner.main(null);
    }
}

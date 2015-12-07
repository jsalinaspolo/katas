package com.jspcore.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FloorProcessorShould {

    private FloorProcessor floorProcessor;

    @Before
    public void initialise() {
        floorProcessor = new FloorProcessor();
    }

    @Test public void
    return_0_when_UP_UP_DOWN_DOWN() {
        assertThat(floorProcessor.process("(())"), is(0));
    }

    @Test public void
    return_0_when_UP_DOWN_UP_DOWN() {
        assertThat(floorProcessor.process("()()"), is(0));
    }



}

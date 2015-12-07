package com.jspcore.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CommandShould {


    @Test public void
    return_up_from_command_open_parenthesis() {
        assertThat(Command.from("("), is(Command.UP));
    }

    @Test public void
    return_down_from_command_close_parenthesis() {
        assertThat(Command.from(")"), is(Command.DOWN));
    }

}
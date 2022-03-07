package com.papinologie.deductive;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


public class DeductiveReasoningCharsTest {
    @Rule
    public ExpectedException exception =
            ExpectedException.none();
    private DeductiveReasoningChars deductiveReasoningChars;

    @Before
    public void before() throws Exception {
        deductiveReasoningChars = new DeductiveReasoningChars();
    }

    @Test
    public void whenMoveOutsideBoardXAxisThenRuntimeException() {
        exception.expect(RuntimeException.class);
        deductiveReasoningChars.addSymbol(5, 2, '\0');
    }

    @Test
    public void whenMoveOutsideBoardYAxisThenRuntimeException() {
        exception.expect(RuntimeException.class);
        deductiveReasoningChars.addSymbol(2, 5, '\0');
    }

    @Test
    public void givenALineWithCharAAlreadyAdded_WhenAddingCharAOnThatLine_thenRuntimeException() {
        deductiveReasoningChars.addSymbol(1, 1, 'a');
        String actual = deductiveReasoningChars.addSymbol(1, 2, 'a');
        assertEquals("Char invalid", actual);
    }
    @Test
    public void givenAColumnWithCharAAlreadyAdded_WhenAddingCharAOnThatColumn_thenRuntimeException() {
        deductiveReasoningChars.addSymbol(1, 1, 'a');
        String actual = deductiveReasoningChars.addSymbol(2, 1, 'a');
        assertEquals("Char invalid", actual);
    }

    @Test
    public void whenTryingToAddIncorrectChar_thenRuntimeException(){
        String actual = deductiveReasoningChars.addSymbol(1,1,'e');
        assertEquals("Char invalid", actual);
    }

}
package ds.impl;

import ds.Stack;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by rahulmadhavan on 12/15/14.
 */
public class ArrayStackImplTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    Stack<Integer> stack;


    @Before
    public void before(){
        stack =  new ArrayStackImpl<Integer>(5);
    }

    @After
    public void after(){
        stack = null;
    }


    @Test
    public void pushToEmptyStackShouldMakeTheStackNonEmpty(){

        assertTrue("stack should be empty initially",stack.isEmpty());
        stack.push(10);
        assertFalse("stack should not be empty after an element is pushed into it", stack.isEmpty());

    }

    @Test
    public void poppingLastElementStackShouldMakeItEmpty(){

        assertTrue("stack should be empty initially",stack.isEmpty());
        stack.push(10);
        stack.pop();
        assertTrue("stack should be empty when all elements have been removed",stack.isEmpty());

    }

    @Test
    public void stackElementsShouldBeOrganizedInFIFOOrder(){

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals("popped element must be 40", Integer.valueOf(40), stack.pop());
        assertEquals("popped element must be 30",Integer.valueOf(30),stack.pop());
        assertEquals("popped element must be 20",Integer.valueOf(20),stack.pop());
        assertEquals("popped element must be 10",Integer.valueOf(10),stack.pop());

        assertTrue("stack should be empty when all elements have been removed",stack.isEmpty());

    }

    @Test
    public void stackShouldThrowExceptionIfElementIsPushedWhenStackIsFull(){

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Stack is full");
        stack.push(60);

    }

    @Test
    public void stackShouldThrowExceptionIfElementIsPoppedFromEmptyStack(){

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Stack is empty");
        stack.pop();

    }

    @Test
    public void peekShouldNotRemoveElementFromStack(){

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals("peeked element must be 40",Integer.valueOf(40),stack.peek());
        assertEquals("popped element must be 40",Integer.valueOf(40),stack.pop());
        assertEquals("peeked element must be 40",Integer.valueOf(30),stack.peek());
        assertEquals("popped element must be 30",Integer.valueOf(30),stack.pop());
        assertEquals("peeked element must be 40",Integer.valueOf(20),stack.peek());
        assertEquals("popped element must be 20",Integer.valueOf(20),stack.pop());
        assertEquals("peeked element must be 40",Integer.valueOf(10),stack.peek());
        assertEquals("popped element must be 10",Integer.valueOf(10),stack.pop());

    }

    @Test
    public void stackShouldThrowExceptionIfWePeekInEmptyStack(){

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Stack is empty");
        stack.peek();

    }


}

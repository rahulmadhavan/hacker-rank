package ds.impl;

import ds.Queue;
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
public class ArrayQueueImplTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private Queue<Integer> queue;

    @Before
    public void before(){
        queue = new ArrayQueueImpl<Integer>(5);
    }

    @After
    public void after(){
        queue = null;
    }

    @Test
    public void initiallyQueueShouldBeEmpty(){
        assertTrue("Queue should be empty",queue.isEmpty());
    }

    @Test
    public void queueShouldNotBeEmptyIfItContainsElements(){
        queue.enqueue(10);
        assertFalse("Queue should not be empty", queue.isEmpty());
    }

    @Test
    public void queueShouldBeEmptyIfThereAreNoElements(){
        queue.enqueue(10);
        queue.remove();
        assertTrue("Queue should not be empty",queue.isEmpty());
    }


    @Test
    public void shouldThrowExceptionWhenEnqueueIsCalledOnFullQueue(){

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Queue is full");
        queue.enqueue(60);

    }


    @Test
    public void queueShouldStoreElementsInLIFOOrder(){
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        assertEquals("removed element must be 50",Integer.valueOf(10),queue.remove());
        assertEquals("removed element must be 40",Integer.valueOf(20),queue.remove());
        assertEquals("removed element must be 30",Integer.valueOf(30),queue.remove());
        assertEquals("removed element must be 20",Integer.valueOf(40),queue.remove());
        assertEquals("removed element must be 10",Integer.valueOf(50),queue.remove());

        assertTrue("Queue should be empty",queue.isEmpty());
    }

    @Test
    public void shouldThrowExceptionWhenRemoveIsCalledOnEmptyQueue(){

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Queue is empty");
        queue.remove();

    }



}

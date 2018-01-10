package com.something.to.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class ToTestTest {
    private StringResolver stRes = mock(StringResolver.class);
    // Same

    @Mock
    private StringResolver stResAnnot;

    @Mock
    private Logger lgMock;
    @Spy
    private Logger lgSpy;
//    Same as @RunWith(MockitoJUnitRunner.class)
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void stringResolverTest() {
        when(stRes.getString()).thenReturn("aaaBBBB");
        ToTest t = new ToTest(stRes, new SimpleSolver());
        Pair expected = new Pair(3, 4);
        assertEquals(expected, t.findUniformString());
    }
    @Test
    public void stringResolverAnnotTest() {
        when(stResAnnot.getString()).thenReturn("aaaBBBB");
        ToTest t = new ToTest(stResAnnot, new SimpleSolver());
        Pair expected = new Pair(3, 4);
        assertEquals(expected, t.findUniformString());
    }
    @Test
    public void mockLoggerTest() {
        when(stResAnnot.getString()).thenReturn("aaaBBBB");
        ToTest t = new ToTest(stResAnnot, new SimpleSolver());
        t.setLg(lgMock);
        Pair expected = new Pair(3, 4);
        assertEquals(expected, t.findUniformString());
        verify(lgMock, times(1)).log(expected.toString());
    }
    @Test
    public void spyLoggerTest() {
        when(stResAnnot.getString()).thenReturn("aaaBBBB");
        ToTest t = new ToTest(stResAnnot, new SimpleSolver());
        t.setLg(lgSpy);
        Pair expected = new Pair(3, 4);
        assertEquals(expected, t.findUniformString());
        verify(lgSpy, times(1)).log(expected.toString());
    }
}

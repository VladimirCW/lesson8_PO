package test.java.UnitTests;

import main.java.ForTestApp;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestForTestApp {
    ForTestApp app = new ForTestApp();

    @Test
    public void forPositive() {
        int arr[] = {1,2,3};
        int actual = app.min(arr);
        assertEquals(actual, 1);
    }

    @Test
    public void forNegative() {
        int arr[] = {-1, -2, -3};
        int actual = app.min(arr);
        assertEquals(actual, -3);
    }

    @Test
    public void forEquals() {
        int arr[] = {0, 0, 0};
        int actual = app.min(arr);
        assertEquals(actual, 0);
    }
}

package main.java;

public class ForTestApp {
    public int min(int arr[]) {
        int min = arr[0];
        for(int el: arr) {
            if(el < min) {
                min = el;
            }
        }
        return min;
    }
}

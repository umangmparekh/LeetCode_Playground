package org.example;

import java.util.Arrays;
import java.util.Stack;

public class LC735_AsteroidCollision {

    public static void main(String[] args) {

        int nums[] = new int[]{5,10,-5};
        System.out.println(" LC735_AsteroidCollision - 5,10,-5 >> " + Arrays.toString( asteroidCollision(nums)));
        int nums1[] = new int[]{3,5,-6,2,-1,4};
        System.out.println(" LC735_AsteroidCollision - 3,5,-6,2,-1,4 >> " + Arrays.toString( asteroidCollision(nums1)));

    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int asteroid : asteroids){
            boolean flag = true;
            while(!st.isEmpty() && (st.peek() >0 && asteroid <0)){
                if(Math.abs(st.peek()) < Math.abs(asteroid)){
                    st.pop();
                    continue;
                }else if(Math.abs(st.peek()) == Math.abs(asteroid)){
                    st.pop();
                }
                flag= false;
                break;
            }
            if(flag)
                st.push(asteroid);
        }

        int[] remainingAsteroids = new int[st.size()];
        for(int i=remainingAsteroids.length-1; i>=0; i--){
            remainingAsteroids[i] = st.peek();
            st.pop();
        }
        return remainingAsteroids;
    }
}

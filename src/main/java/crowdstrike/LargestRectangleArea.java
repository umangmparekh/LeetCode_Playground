package crowdstrike;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleArea {

    public static int largestRectangleArea(int[] heights){

        int n  = heights.length;
        int[] h = new int[n+1];

        System.arraycopy(heights, 0, h, 0, n);
        h[n] = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for(int i=0; i<=n; i++){

            while(!stack.isEmpty() && h[i] < h[stack.peek()]){
                int height = h[stack.pop()];

                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();

                int width = i - leftBoundary - 1;

                maxArea = Math.max(maxArea, height * width);

            }
            stack.push(i);
        }

        return maxArea;


    }

    public static void main(String[] args){

        System.out.println(largestRectangleArea(new int[]{5}));
        System.out.println(largestRectangleArea(new int[]{5, 5}));
        System.out.println(largestRectangleArea(new int[]{1, 2, 3, 4}));
        System.out.println(largestRectangleArea(new int[]{4, 3, 2, 1}));
        System.out.println(largestRectangleArea(new int[]{3,3,3}));

    }
}

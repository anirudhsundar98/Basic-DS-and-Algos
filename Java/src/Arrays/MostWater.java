package Arrays;

// https://leetcode.com/problems/container-with-most-water/description/
public class MostWater {
    static int maxArea(int[] height) {
        int max = 0;
        int minIndex = -1;
        for (int i = 0; i < height.length; i++) {
            if (minIndex != -1 && height[i] < height[minIndex])
                continue;

            for (int j = i + 1; j < height.length; j++) {
                if ((j-i) * Integer.min(height[i], height[j]) > max) {
                    minIndex = (height[i] < height[j])? i : j;
                    max = (j-i) * height[minIndex];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = {2,3,10,5,7,8,9};
        System.out.println(maxArea(height));
    }
}

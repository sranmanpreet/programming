package leetcode;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maximumArea = 0;
        int len = height.length;
        int i = 0, j = len - 1;
        while (i < len && j > i) {
            maximumArea = Math.max(maximumArea, (j - i) * Math.min(height[i], height[j]));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maximumArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMostWater msw = new ContainerWithMostWater();
        System.out.println(msw.maxArea(height));
    }
}

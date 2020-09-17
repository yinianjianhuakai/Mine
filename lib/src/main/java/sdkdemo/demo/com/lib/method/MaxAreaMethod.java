package sdkdemo.demo.com.lib.method;

/**
 * Created by  sjx  on 2020/9/11
 */
public class MaxAreaMethod {

    public void solution() {
        int[] array = new int[]{1, 8, 6, 2, 5, 4, 80, 100, 10};
        System.out.println("maxArea : " + maxArea(array));
        System.out.println("maxArea2 : " + maxArea2(array));
    }

    public int maxArea2(int[] height) {
        int i   = 0;
        int j   = height.length - 1;
        int res = 0;
        while (i < j) {
            System.out.println("i : " + i + "  j : " + j);
            res = height[i] < height[j] ? Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int length = height.length;
        int max    = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int tempMax = (j - i) * Math.min(height[i], height[j]);
                if (max < tempMax) {
                    max = tempMax;
                }
            }
        }

        return max;
    }

}

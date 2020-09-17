package sdkdemo.demo.com.lib.method;

/**
 * Created by  sjx  on 2020/9/14
 */
public class ThreeNumNearSum {

    public void solution() {
        int[] nums   = {-1, 2, 1, -4};
        int   result = threeSumClosest(nums, 1);
        System.out.println("result : " + result);
    }

    public int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length < 3) {
            return 0;
        }

        int n      = nums.length;
        int differ = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                for (int m = j + 1; m < n; m++) {
                    if (m > j + 1 && nums[m] == nums[m - 1]) continue;
                    int current = nums[i] + nums[j] + nums[m];
                    int temp = Math.abs(current - target);
                    if (differ == Integer.MAX_VALUE) {
                        differ = temp;
                        result = current;
                    }
                    if (differ > temp) {
                        differ = temp;
                        result = current;
                    }
                }
            }
        }

        return result;
    }
}

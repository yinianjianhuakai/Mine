package sdkdemo.demo.com.lib.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by  sjx  on 2020/9/11
 */
public class FourNumSum {

    public void solution() {
        int[]               nums = {2, -4, -5, -2, -3, -5, 0, 4, -2};//[2,-4,-5,-2,-3,-5,0,4,-2]
        List<List<Integer>> list = fourSum2(nums, -14);
        System.out.println(list.toString());
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        if (nums == null || length < 4) {
            return list;
        }
        Arrays.sort(nums);

        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                for (int m = j + 1; m < length - 1; m++) {
                    if (m > j + 1 && nums[m] == nums[m - 1]) continue;
                    for (int n = m + 1; n < length; n++) {
                        if (n > m + 1 && nums[n] == nums[n - 1]) continue;
                        if (nums[i] + nums[j] + nums[m] + nums[n] == target) {
                            List<Integer> inner = new ArrayList<>();
                            inner.add(nums[i]);
                            inner.add(nums[j]);
                            inner.add(nums[m]);
                            inner.add(nums[n]);
//                            if (!list.contains(inner)) {
                                list.add(inner);
//                            }
                        }
                    }
                }

            }
        }

        return list;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        int                 n     = nums.length;
        if (n < 4) return lists;
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        lists.add(list);

                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--;
                    } else if (nums[i] + nums[j] + nums[l] + nums[r] > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return lists;
    }

    private boolean isSame(List<List<Integer>> list, List<Integer> target) {
        if (list.contains(target)) {
            return true;
        }
        return false;
    }

    private void sortList(List<Integer> target) {
        Collections.sort(target);
    }

}

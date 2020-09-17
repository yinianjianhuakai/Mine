package sdkdemo.demo.com.lib.method;

/**
 * Created by  sjx  on 2020/9/8
 */
public class RegularTriangle {

    public void getCurtNum() {
        int[] trees  = new int[]{2, 3, 7, 5};
        int   min    = 0;
        int   max    = 0;
        int   twoNum = 0;
        for (int i = 0; i < trees.length; i++) {
            if (min == 0) {
                min = trees[i];
            }
            if (max == 0) {
                max = trees[i];
            }
            if (min > trees[i]) {
                min = trees[i];
            }
            if (max < trees[i]) {
                max = trees[i];
            }

            System.out.println("min : " + min + "  max : " + max);

            int repeatNum = repeatNum(trees, trees[i]);
            if (repeatNum == 3) {
                System.out.println("finished cut number : 0");
                return;
            }
            if (repeatNum == 2) {
                twoNum = trees[i];
            }
        }

        if (twoNum != 0) {
            if (twoNum < max) {
                System.out.println("cut number : 1");
                return;
            }
        }

        if (max / min > 1) {
            System.out.println("three cut number : 2");
            return;
        } else {
            System.out.println("else three cut number : 2");
            return;
        }

    }

    private int repeatNum(int[] array, int index) {
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (index == array[i]) {
                num++;
            }
        }
        return num;
    }
}

package sdkdemo.demo.com.test;

import android.util.Log;
import com.sjx.handlereventbus.eventbus.OnRxEventListener;
import com.sjx.handlereventbus.eventbus.RxBus;
import com.sjx.handlereventbus.eventbus.RxData;


public class TestEventBusOnObject implements OnRxEventListener {

    public TestEventBusOnObject() {
        RxBus.getInstance().register(this);
    }

    public void clear() {
        RxBus.getInstance().unRegister(this);
    }

    public void removeDuplicates() {

        int[] array = new int[]{0};

        int resultLength = 1;
        int repeatLength = 0;
        int temp         = array[0];

        for (int i = 1; i < array.length - repeatLength; i++) {
            if (temp != array[i]) {
                temp = array[i];
                resultLength++;
            } else {
                if (i + 1 < array.length) {
                    System.arraycopy(array, i + 1, array, i, array.length - i - 1);
                    i--;
                    repeatLength++;
                }
            }
        }
        Log.i("Test", "resultLength : " + resultLength);
        for (int i = 0; i < resultLength; i++) {
            Log.i("Test", array[i] + " , ");
        }
    }

    public void removeDuplicatesTest() {

        int[] array = new int[]{0, 0, 1, 1, 1, 2, 2, 5, 5, 5};

        int i = 0, j = 1;
        while (j < array.length) {
            if (array[i] == array[j]) {
                j++;
            } else {
                i++;
                array[i] = array[j];
                j++;
            }
        }

        Log.i("Test", "resultLength : " + (i + 1));
        for (int k = 0; k < i + 1; k++) {
            Log.i("Test", array[k] + " , ");
        }
    }

    public int removeElement(/*int[] nums, int val*/) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 5, 5,5};
        int   val  = 1;

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int resultNum = 0;
        int i         = 0;
        while (i < nums.length) {
            if (nums[i] == val) {
                i++;
            } else {
                nums[resultNum] = nums[i];
                resultNum++;
                i++;
            }
        }

        Log.i("Test", "resultLength : " + (resultNum ));
        for (int k = 0; k < resultNum; k++) {
            Log.i("Test", nums[k] + " , ");
        }

        return resultNum;
    }

    @Override
    public void onRxEvent(RxData event) {
        Log.i("TestEventBusOnObject", "onEvent  code : " + event.getEventCode() + "  msg : " + event.getObj1() + "  target : " + event.getTargetName());
    }
}

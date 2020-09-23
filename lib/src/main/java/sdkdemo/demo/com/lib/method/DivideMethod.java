package sdkdemo.demo.com.lib.method;

/**
 * Created by  sjx  on 2020/9/23
 */
public class DivideMethod {

    public void solution() {
        System.out.println("divide : " + divide(-1010369383, -2147483648));
    }

    public int divide(int dividend, int divisor) {
        boolean flag = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        long tempDividend = dividend < 0 ? -1 * (long)dividend : dividend;
        long tempDivisor  = divisor < 0 ? -1 * (long)divisor : divisor;

        long res = div(tempDividend, tempDivisor);
        long resLong = flag ? res * -1 : res;
        int resInt = (int) resLong;
        if (resLong > 0 && (int)resLong < 0){
            resInt = Integer.MAX_VALUE;
        }
        return resInt;
    }

    private long div(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        long tempNum = 1;
        long temp    = divisor;
        while (temp + temp <= dividend) {
            tempNum = tempNum << 1;
            temp = temp << 1;
        }

        return tempNum + div(dividend-temp, divisor);
    }
}

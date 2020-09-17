package sdkdemo.demo.com.lib.method;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  sjx  on 2020/9/9
 */
public class TriangleAreaPoint {
    public void solution() {
        List<List<Integer>> list      = new ArrayList<>();
        List<Integer>       oneList   = new ArrayList<>();
        List<Integer>       twoList   = new ArrayList<>();
        List<Integer>       threeList = new ArrayList<>();

        oneList.add(0);
        oneList.add(0);
        twoList.add(2);
        twoList.add(0);
        threeList.add(1);
        threeList.add(2);

        list.add(oneList);
        list.add(twoList);
        list.add(threeList);

        int[]  point = new int[]{1, 1};
        String str   = castMagic(list, point);
        System.out.println("castMagic : " + str);
    }

    /**
     * [[0,0],[2,0],[1,2]]
     * [1,1]
     *
     * @param list
     * @param point
     * @return
     */
    public String castMagic(List<List<Integer>> list, int[] point) {
        List<Integer> oneList   = list.get(0);
        List<Integer> twoList   = list.get(1);
        List<Integer> threeList = list.get(2);

        int aX = oneList.get(0);
        int aY = oneList.get(1);

        int bX = twoList.get(0);
        int bY = twoList.get(1);

        int cX = threeList.get(0);
        int cY = threeList.get(1);

        int           pointX = point[0];
        int           pointY = point[1];
        List<Integer> pList  = new ArrayList<>();
        pList.add(pointX);
        pList.add(pointY);


        double ab = getSideLength(oneList, twoList);
        double ac = getSideLength(oneList, threeList);
        double bc = getSideLength(twoList, threeList);

        double pa = getSideLength(pList, oneList);
        double pb = getSideLength(pList, twoList);
        double pc = getSideLength(pList, threeList);

        double area = getArea(ab, ac, bc);

        double p1 = getArea(pa, pb, ab);
        double p2 = getArea(pa, pc, ac);
        double p3 = getArea(pc, pb, bc);

        if (Math.abs(area - p1 - p2 - p3) < 0.000000001){
            return "YES";
        }

        return "NO";
    }

    private double getArea(double a, double b, double c) {
        double perimeterHalf = (a + b + c) / 2;
        double area          = Math.sqrt(perimeterHalf * (perimeterHalf - a) * (perimeterHalf - b) * (perimeterHalf - c));
        return area;
    }

    private double getSideLength(List<Integer> aList, List<Integer> bList) {
        int aX = aList.get(0);
        int aY = aList.get(1);

        int bX = bList.get(0);
        int bY = bList.get(1);

        double sqrt = Math.sqrt(Math.pow(aX - bX, 2) + Math.pow(aY - bY, 2));

        return sqrt;
    }
}

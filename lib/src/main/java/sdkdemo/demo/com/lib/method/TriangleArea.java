package sdkdemo.demo.com.lib.method;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  sjx  on 2020/9/8
 */
public class TriangleArea {


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

        int[] point = new int[]{1, 1};
        String str = castMagic(list, point);
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

        int pointX = point[0];
        int pointY = point[1];

        float abRate = (float) (1.0 * (aY - bY) / (aX - bX));
        float abDex  = aY - aX * abRate;

        float acRate = (float) (1.0 * (aY - cY) / (aX - cX));
        float acDex  = aY - aX * acRate;

        float bcRate = (float) (1.0 * (bY - cY) / (bX - cX));
        float bcDex  = bY - bX * bcRate;


        float abPointY = pointX * abRate + abDex;
        float acPointY = pointX * acRate + acDex;
        float bcPointY = pointX * bcRate + bcDex;

        float cTempY = cX * abRate + abDex;
        float bTempY = bX * acRate + acDex;
        float aTempY = aX * bcRate + bcDex;

        if ((pointY - abPointY) * (cY - cTempY) >= 0
                && (pointY - acPointY) * (bY - bTempY) >= 0
                && (pointY - bcPointY) * (aY - aTempY) >= 0) {
            return "YES";
        }else{
            return "NO";
        }

    }
}

package sdkdemo.demo.com.utils;


import android.hardware.Camera;

/**
 * Created by  sjx  on 2020/7/30
 */
public class CameraPermission {


    public static boolean cameraIsCanUse() {
        boolean isCanUse = true;
        Camera  mCamera  = null;
        try {
            mCamera = Camera.open();
            Camera.Parameters mParameters = mCamera.getParameters(); //针对魅族手机
            mCamera.setParameters(mParameters);
        } catch (Exception e) {
            isCanUse = false;
            e.printStackTrace();
        }

        if (mCamera != null) {
            try {
                mCamera.release();
                mCamera = null;
            } catch (Exception e) {
                e.printStackTrace();
                return isCanUse;
            }
        }
        return isCanUse;
    }
}

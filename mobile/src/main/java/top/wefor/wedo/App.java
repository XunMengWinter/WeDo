package top.wefor.wedo;

import android.app.Application;
import android.widget.Toast;

import top.wefor.circularanim.CircularAnim;

/**
 * Created on 2017/10/16.
 *
 * @author ice
 */

public class App extends Application {

    private static Toast sToast;
    private static App sApp;

    public App get() {
        if (sApp == null) {
            sApp = this;
        }

        return sApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        CircularAnim.init(CircularAnim.PERFECT_MILLS,CircularAnim.PERFECT_MILLS,R.color.colorPrimary);
    }

    /* 传入一个CharSequence，显示Toast */
    public void showToast(CharSequence msg) {
        if (sToast == null) {
            sToast = new Toast(get());
            sToast.setDuration(Toast.LENGTH_SHORT);
        }
        if (msg == null) {
            msg = "";
        }
        sToast.cancel();
        sToast.setText(msg);
        sToast.show();
    }

    /* 传入一个资源Id，显示Toast */
    public void showToast(int resId) {
        showToast(getString(resId));
    }


}

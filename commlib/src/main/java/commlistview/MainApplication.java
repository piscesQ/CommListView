package commlistview;

import android.app.Application;
import android.util.Log;

/**
 * project : CommListView
 * author : YanBin on 3/19/17
 * version : v1.0
 * description :
 */
public class MainApplication extends Application {

    public static final String TAG = MainApplication.class.getSimpleName();
    public static MainApplication INSTANCE;

    public static MainApplication getInstance(){
        if (INSTANCE == null){
            INSTANCE = new MainApplication();
        }
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "MainApplication -- onCreate");
        super.onCreate();
        INSTANCE = this;    //赋初始值，如果INSTANCE与this不是同一对象，之后通过getInstance的操作将报空指针
    }
}

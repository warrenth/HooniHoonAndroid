package pe.hoonihoon.bootstrap;

import android.content.Context;

/**
 * Created by 152317 on 2017-04-03.
 */

public class Application extends android.app.Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}

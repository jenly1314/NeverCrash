package com.king.nevercrash;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.king.thread.nevercrash.NeverCrash;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2017/4/12
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NeverCrash.init(new NeverCrash.CrashHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                Log.d("Jenly", Log.getStackTraceString(e));
//                e.printStackTrace();
                showToast(e.getMessage());


            }
        });
    }

    private void showToast(final String text){

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
            }
        });
    }

}

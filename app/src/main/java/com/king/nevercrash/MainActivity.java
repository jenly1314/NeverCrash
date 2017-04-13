package com.king.nevercrash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void asyncThread(Runnable runnable){
        new Thread(runnable).start();
    }

    public void OnClick(View v){
        switch (v.getId()){
            case R.id.btn1:
                Toast.makeText(this,"正常点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                throw new RuntimeException("RuntimeException");
            case R.id.btn3:
                throw new Error("Error");
            case R.id.btn4:
                asyncThread(new Runnable() {
                    @Override
                    public void run() {
                        throw new IllegalArgumentException("IllegalArgumentException");
                    }
                });
                break;
            case R.id.btn5:
                asyncThread(new Runnable() {
                    @Override
                    public void run() {
                        throw new RuntimeException("RuntimeException");
                    }
                });
                break;
        }
    }
}

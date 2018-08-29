package com.example.wuyue.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCallBack;
    private Button btnCallBack2;
    private Button btnCallBack3;
    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnCallBack = (Button) findViewById(R.id.btn_callback);
        btnCallBack2 = (Button) findViewById(R.id.btn_callback2);
        btnCallBack3 = (Button) findViewById(R.id.btn_callback3);
        btnCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyCallBack myCallBack = new MyCallBack();
                myCallBack.setCallBack(new MyCallBack.CallBack() {
                    @Override
                    public void work() {
                        Log.d("CallBack...", "callback");
                        Toast.makeText(MainActivity.this, "callback", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btnCallBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyCallBackImpl a = new MyCallBackImpl();
                IMyCallBack sw = new IMyCallBack() {
                    @Override
                    public void onCallBack() {
                        Log.d("CallBack...", "setCallBack(obj,i) ");
                        Toast.makeText(MainActivity.this, "setCallBack(obj,i) ", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCallBack2() {
                        Log.d("CallBack...", "setCallBack(obj,i) 2-----");
                        Toast.makeText(MainActivity.this, "setCallBack(obj,i) 2------", Toast.LENGTH_SHORT).show();
                    }
                };
                a.setCallBack(sw, count % 2);
                count++;
            }
        });

        btnCallBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyCallBackImpl a = new MyCallBackImpl();
                IMyCallBack sw = new IMyCallBack() {
                    @Override
                    public void onCallBack() {
                        Log.d("CallBack...", "setCallBack(obj) ");
                        Toast.makeText(MainActivity.this, "setCallBack(obj) 2", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCallBack2() {
                        Log.d("CallBack...", "setCallBack(obj) 2----- ");
                        Toast.makeText(MainActivity.this, "setCallBack(obj) 2----- ", Toast.LENGTH_SHORT).show();
                    }
                };
                a.setCallBack(sw);
            }
        });
    }


}

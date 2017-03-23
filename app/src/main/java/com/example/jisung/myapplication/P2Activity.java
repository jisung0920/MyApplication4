package com.example.jisung.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class P2Activity extends AppCompatActivity {

    TabHost tabhost;
    EditText e1,e2;
    TextView t1;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2);
        Log.d("p2activity","start");
        tabhost =(TabHost)findViewById(R.id.tabhost1);
        tabhost.setup();

        tabhost.addTab(tabhost.newTabSpec("A").setContent(new TabHost.TabContentFactory() {

            @Override
            public View createTabContent(String tag) {
                View view = View.inflate(P2Activity.this,R.layout.tab2_layout,null);
                Log.d("p2activity","tab");
                initTab1(view);

                return view;
            }
        }).setIndicator("BMI계산기"));
        tabhost.addTab(tabhost.newTabSpec("B").setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {
                View view = View.inflate(P2Activity.this,R.layout.tab1_layout,null);//뷰가 생성된다. - 객체화 시킨다.
                initTab2(view);
                return view;//기존의 레이아웃을 집어넣는다.
            }
        }).setIndicator("면적계산기"));

    }


    void initTab1(View view){
        e1 = (EditText) view.findViewById(R.id.e1);
        e2 = (EditText) view.findViewById(R.id.e2);
        t1 = (TextView)view.findViewById(R.id.t1);
    }
    void initTab2(View view){
        b1 = (Button)view.findViewById(R.id.b1);
        b2 = (Button)view.findViewById(R.id.b2);
        e1 = (EditText) view.findViewById(R.id.e1);
        t1 = (TextView)view.findViewById(R.id.t1);
    }

    void BMICheck(Double num,TextView t1){

        if(num<=18.5)
            t1.setText("체중부족입니다.");
        else if(num<=22.9)
            t1.setText("정상입니다.");
        else if(num<=24.9)
            t1.setText("과체중입니다.");
        else
            t1.setText("비만입니다.");
    }
    public void onClickTab(View v){
        double a,b,result;
        if(e1.getText().toString().equals("")||e2.getText().toString().equals(""))
            return ;
        if(v.getId()==R.id.b1){
            a=Double.parseDouble(e1.getText().toString());
            result = a*3.305785;
            t1.setText(result+"제곱미터");
        }
        else if(v.getId()==R.id.b2){
            a=Double.parseDouble(e1.getText().toString());
            result = a/3.305785;
            t1.setText(result+"평");
        }
        else{
            a=Math.pow(Double.parseDouble(e1.getText().toString()),2);
            b=Double.parseDouble(e2.getText().toString());
            result = (b/a)*10000;
            Log.d("bmi","a:"+a);
            Log.d("bmi","b:"+b);
            Log.d("bmi","bmi"+result);
            BMICheck(result,t1);
        }

    }
}

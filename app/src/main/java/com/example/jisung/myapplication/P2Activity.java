package com.example.jisung.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

public class P2Activity extends AppCompatActivity {

    TabHost tabhost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2);
        tabhost =(TabHost)findViewById(R.id.tabhost1);
        tabhost.setup();

        TabHost.TabSpec tab1 = tabhost.newTabSpec("A").setContent(R.id.tab1)
                .setIndicator("날짜선택");//첫번째 페이지는 누구랑 연결할것인지
        tabhost.addTab(tab1);//탭을 추가하겠다.
        tabhost.addTab(tabhost.newTabSpec("B").setContent(R.id.tab2)
                .setIndicator("시간선택"));
//        tabhost.addTab(tabhost.newTabSpec("C").setContent(new TabHost.TabContentFactory() {
//            @Override
//            public View createTabContent(String tag) {
//                View view = View.inflate(P2Activity.this,R.layout.tab3_layout,null);//뷰가 생성된다. - 객체화 시킨다.
//                Button btn = (Button)view.findViewById(R.id.btn);//뷰에서 찾아야 하므로 view.을 붙여야 한다.
//                btn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
//                    }
//                });
//                return view;//기존의 레이아웃을 집어넣는다.
//            }
//        }).setIndicator("기타"));
    }
}

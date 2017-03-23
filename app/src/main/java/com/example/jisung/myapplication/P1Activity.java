package com.example.jisung.myapplication;

import android.content.ClipData;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class P1Activity extends AppCompatActivity {


    TextView t1;
    ImageView i1,i2;
    LinearLayout back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1);
        setTitle("메뉴를 눌러보세요");
        init();

    }
    void init(){
        t1 = (TextView)findViewById(R.id.t1);
        i1 = (ImageView)findViewById(R.id.i1);
        i2 = (ImageView)findViewById(R.id.i2);
        back = (LinearLayout)findViewById(R.id.back);
        i1.setImageResource(R.drawable.chick);
        i2.setImageResource(R.drawable.spa);
    }
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mblue:
                back.setBackgroundColor(Color.BLUE);
                break;
            case R.id.mYellow:
                back.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.mRed:
                back.setBackgroundColor(Color.RED);
                break;
            case R.id.rotate:
                if(i1.getVisibility()==View.VISIBLE)
                    i1.setRotation(30);
                else
                    i2.setRotation(30);
                break;
            case R.id.Vtitle:
                if(i1.getVisibility()==View.INVISIBLE && i2.getVisibility()==View.INVISIBLE)
                    Toast.makeText(this,"사진이 없습니다.",Toast.LENGTH_SHORT).show();
                else if(item.isChecked()){
                    t1.setText("");
                    item.setChecked(false);
                }
                else {
                    item.setChecked(true);
                    if (i1.getVisibility() == View.VISIBLE)
                        t1.setText("치킨치킨치킨");
                    else
                        t1.setText("스파게티스파게티");
                }

                break;
            case R.id.Esize:
                if(item.isChecked()){
                    if (i1.getVisibility() == View.VISIBLE){
                        i1.setScaleX(1);
                        i1.setScaleY(1);
                    }
                    else {
                        i2.setScaleX(1);
                        i2.setScaleY(1);
                    }
                    item.setChecked(false);
                }
                else {
                    if (i1.getVisibility() == View.VISIBLE) {
                        i1.setScaleX(2);
                        i1.setScaleY(2);
                    } else {
                        i2.setScaleX(2);
                        i2.setScaleY(2);
                    }
                    item.setChecked(true);
                }
                    break;
            case R.id.Cchick:

                i1.setVisibility(View.VISIBLE);
                i2.setVisibility(View.INVISIBLE);
                if(!t1.getText().equals(""))
                    t1.setText("치킨치킨치킨");
                item.setChecked(true);
                break;
            case R.id.Cspa:

                i2.setVisibility(View.VISIBLE);
                i1.setVisibility(View.INVISIBLE);
                if(!t1.getText().equals(""))
                    t1.setText("스파게티스파게티");
                item.setChecked(true);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

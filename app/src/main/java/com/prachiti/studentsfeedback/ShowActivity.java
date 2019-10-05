package com.prachiti.studentsfeedback;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.system.Os.remove;

public class ShowActivity extends AppCompatActivity {

    TextView tvInteresting, tvBoring, tvDifficult, tvEasy;
    TextView tv1,tv2,tv3,tv4;
    SharedPreferences sp11,sp22,sp33,sp44;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        tvInteresting=(TextView)findViewById(R.id.tvInteresting);
        tvBoring=(TextView)findViewById(R.id.tvBoring);
        tvDifficult=(TextView)findViewById(R.id.tvDifficult);
        tvEasy=(TextView)findViewById(R.id.tvEasy);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
        tv4=(TextView)findViewById(R.id.tv4);

        sp11= getSharedPreferences("f1",MODE_PRIVATE);
        String res1=sp11.getString("name","");
        tvInteresting.setText(res1);

        sp22= getSharedPreferences("f2",MODE_PRIVATE);
        String res2=sp22.getString("name","");
        tvBoring.setText(res2);

        sp33= getSharedPreferences("f3",MODE_PRIVATE);
        String res3=sp33.getString("name","");
        tvDifficult.setText(res3);

        sp44= getSharedPreferences("f4",MODE_PRIVATE);
        String res4=sp44.getString("name","");
        tvEasy.setText(res4);

    }
}

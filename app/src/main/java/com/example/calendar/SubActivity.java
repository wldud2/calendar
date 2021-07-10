package com.example.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

public class SubActivity extends AppCompatActivity {

    Button btn_left;
    Button btn_right;
    MaterialCalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //공모주 달력
        calendar = (MaterialCalendarView) findViewById(R.id.calendar);
        calendar.addDecorators(new SundayDecorator(), new SaturdayDecorator()); //토요일 파란색, 일요일 빨간색

        //배당금 ↔ 공모주 화면 전환하기
        btn_left = (Button) findViewById(R.id.btn_left);
        btn_right = (Button) findViewById(R.id.btn_right);

        btn_left.setOnClickListener(new View.OnClickListener() { //공모주에서 배당금으로
            @Override
            public void onClick(View v) {
                Intent intent_left = new Intent(getApplicationContext(), MainActivity.class);
                finish(); //현재 액티비티 종료
                startActivity(intent_left); //액티비티 intent_left 시작
            }
        });

        btn_right.setOnClickListener(new View.OnClickListener() { //공모주에서 공모주로
            @Override
            public void onClick(View v) {
                Intent intent_right = new Intent(getApplicationContext(), SubActivity.class);
                //finish(); //현재 액티비티 종료
                startActivity(intent_right); //액티비티 intent_right 시작
            }
        });

    }
}
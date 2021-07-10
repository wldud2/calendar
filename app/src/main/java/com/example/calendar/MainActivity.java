package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

public class MainActivity extends AppCompatActivity {

    Button btn_left;
    Button btn_right;
    Button btn_new;
    Button btn_delete;
    MaterialCalendarView calendar;
    Dialog newdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //배당금달력
        calendar = (MaterialCalendarView) findViewById(R.id.calendar);
        calendar.addDecorators(new SundayDecorator(), new SaturdayDecorator()); //토요일 파란색, 일요일 빨간색

        //배당금 추가, 삭제하기
        btn_new = (Button) findViewById(R.id.btn_new); //[배당금 추가하기] 버튼
        btn_delete = (Button) findViewById(R.id.btn_delete); //[배당금 삭제하기] 버튼

        newdialog = new Dialog(MainActivity.this); //팝업으로 띄울 다이얼로그 선언
        newdialog.setContentView(R.layout.activity_newdialog); //팝업에 레이아웃 activity_newdialog의 콘텐츠 띄우기
        btn_new.setOnClickListener(new View.OnClickListener() { //[배당금 추가하기] 버튼을 클릭하면
            @Override
            public void onClick(View v) {
                shownewDialog(); //함수 shownewDialog() 실행 → 사용자 정의함수는 onCreate 외부에서 선언해야하는듯함
            }
        });


        //배당금 ↔ 공모주 화면전환하기
        btn_left = (Button) findViewById(R.id.btn_left);
        btn_right = (Button) findViewById(R.id.btn_right);

        btn_left.setOnClickListener(new View.OnClickListener() { //배당금에서 배당금으로
            @Override
            public void onClick(View v) {
                Intent intent_left = new Intent(getApplicationContext(), MainActivity.class);
                //finish(); //현재 액티비티 종료
                startActivity(intent_left); //액티비티 intent_left 시작
            }
        });

        btn_right.setOnClickListener(new View.OnClickListener() { //배당금에서 공모주로
            @Override
            public void onClick(View v) {
                Intent intent_right = new Intent(getApplicationContext(), SubActivity.class);
                finish(); //현재 액티비티 종료
                startActivity(intent_right); //액티비티 intent_right 시작
            }
        });

    }

    private void shownewDialog() { //사용자정의함수 shownewDialog() 정의
        newdialog.show(); //다이얼로그 띄우기

        Button btn_add = (Button) newdialog.findViewById(R.id.btn_add); //다이얼로그 팝업챙 내부의 버튼 [배당금 추가]를 클릭하면
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newdialog.dismiss(); //다이얼로그 팝업창 닫힘
            }
        });
    }
}
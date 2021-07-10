package com.example.calendar;

import android.app.Dialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewDialogActivity extends AppCompatActivity {

    Button btn_add;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newdialog);

        //배당금 추가
        btn_add = (Button) findViewById(R.id.btn_add);

    }
}

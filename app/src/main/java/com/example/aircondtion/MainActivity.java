package com.example.aircondtion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
private boolean isOn=true;
private int mode=1;//1 mode=cool,2=heat
    private TextView tvmode,textView;
    private int temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tvmode=findViewById(R.id.tvmode);
        temp=24;
        textView = findViewById(R.id.textView);
    }
    public void checkStatus(View view) {
        if(isOn)
            isOn=false;
        else
            isOn=true;
    }

    public void checkMode(View view) {
        if(isOn)
            if(mode==1) {
                mode = 2;
                tvmode.setText("Heat");
            }
            else{
                mode=1;
                tvmode.setText("Cool");}
        else{
            Toast.makeText(this, "قم بتشغيل المكيف أولاً", Toast.LENGTH_SHORT).show();
        }
    }

    public void plustemp(View view) {
        if (isOn) {
            if (temp < 30) {
                temp++;
                textView.setText(temp + "°C");
            } else {
                Toast.makeText(this, "لا يمكن تجاوز 30°C", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "قم بتشغيل المكيف أولاً", Toast.LENGTH_SHORT).show();
        }
    }

    public void minustemp(View view) {
        if (isOn) {
            if (temp > 16) {
                temp--;
                textView.setText(temp + "°C");
            } else {
                Toast.makeText(this, "لا يمكن تقليل درجة الحرارة تحت 16°C", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "قم بتشغيل المكيف أولاً", Toast.LENGTH_SHORT).show();
        }
    }
}
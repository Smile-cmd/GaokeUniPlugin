package com.gksc.plugin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gksc.plugin.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取按钮实例
        Button jumpButton = findViewById(R.id.jumpButton);

        // 给按钮设置点击事件监听器
        jumpButton.setOnClickListener(v -> {
            // 创建Intent对象，参数分别是当前Activity和目标Activity的类
            Intent intent = new Intent(MainActivity.this, RoomDBActivity.class);

            // 可选：传递数据到目标Activity
            intent.putExtra("message", "Hello from MainActivity!");
            intent.putExtra("number", 123);

            // 执行跳转
            startActivity(intent);
        });
    }
}
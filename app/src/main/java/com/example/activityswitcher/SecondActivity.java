package com.example.activityswitcher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.activityswitcher.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.BTN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                startActivityForResult(intent, Utils.REQUEST_CODE);
            }
        });

        binding.BTN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivityForResult(intent, Utils.REQUEST_CODE);
            }
        });

        binding.BTNBACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(Utils.DATA_FOR_TOAST, "Second Activity");
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Utils.REQUEST_CODE && resultCode == RESULT_OK) {
            String str = data.getStringExtra(Utils.DATA_FOR_TOAST);
            str = str + " => Second Activity";
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }
}
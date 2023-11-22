package com.example.activityswitcher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.activityswitcher.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThirdBinding binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.BTN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, FirstActivity.class);
                startActivityForResult(intent, Utils.REQUEST_CODE);
            }
        });

        binding.BTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivityForResult(intent, Utils.REQUEST_CODE);
            }
        });

        binding.BTNBACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(Utils.DATA_FOR_TOAST, "Third Activity");
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
            str = str + " => Third Activity";
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }
}
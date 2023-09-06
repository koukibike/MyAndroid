package jp.ac.meijou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Optional;

import jp.ac.meijou.databinding.ActivityMain2Binding;
import jp.ac.meijou.databinding.ActivityMainBinding;
import jp.ac.meijou.databinding.ActivitySubBinding;

public class SubActivity extends AppCompatActivity {

    private ActivitySubBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Optional.ofNullable(getIntent().getStringExtra("text"))
                .ifPresent(text -> binding.textView4.setText(text));
        binding.buttonOk.setOnClickListener(view ->{
            var intent = new Intent();
            intent.putExtra("ret","meijo");
            setResult(RESULT_OK,intent);
            finish();
        });
        binding.buttonCancel.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}
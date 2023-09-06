package jp.ac.meijou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import jp.ac.meijou.databinding.ActivityMain2Binding;
import jp.ac.meijou.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textView2.setVisibility(View.GONE);
    }
}
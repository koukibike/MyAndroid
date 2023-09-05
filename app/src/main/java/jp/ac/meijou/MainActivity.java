package jp.ac.meijou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.TextView;

import jp.ac.meijou.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private PrefDataStore prefDataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefDataStore = PrefDataStore.getInstance(this);
        //prefDataStore.getString("name").ifPresent(name -> binding.text.setText(name));
        binding.saveButton.setOnClickListener(View -> {
            var text = binding.editText.getText().toString();
            prefDataStore.setString("name",text);
            Log.d("kouki","save:" + binding.editText);
        });
        Log.d("kouki","onCreate text:"+binding.text.getText());
        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //binding.text.setText(editable.toString());

            }
        });
        //log.d("kouki","onCreate text:"+binding.text.getText());
    }
    @Override
    protected void onStart(){
        super.onStart();
        prefDataStore.getString("name").ifPresent(name -> binding.text.setText(name));
    }
}
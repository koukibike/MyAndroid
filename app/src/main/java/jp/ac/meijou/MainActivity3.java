package jp.ac.meijou;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import java.util.Optional;

import jp.ac.meijou.databinding.ActivityMain3Binding;
import jp.ac.meijou.databinding.ActivityMainBinding;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;
    private final ActivityResultLauncher<Intent>getActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                switch (result.getResultCode()) {
                    case RESULT_OK:
                        Optional.ofNullable(result.getData())
                                .map(data -> data.getStringExtra("ret"))
                                .map(text -> "Result:" + text)
                                .ifPresent(text -> binding.textView5.setText(text));
                        break;
                    case RESULT_CANCELED:
                        binding.textView5.setText("Result: Canceled");
                        break;
                    default:
                        binding.textView5.setText("Result: Unknown(" + result.getResultCode() + ")");
                        break;
                }
}
);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button4.setOnClickListener(view ->{
            var intent = new Intent(this, SubActivity.class);
            startActivity(intent);
        });

        binding.button5.setOnClickListener(view ->{
            var intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.yahoo.co.jp"));
            startActivity(intent);
        });
        binding.button6.setOnClickListener(view ->{
            var intent = new Intent(this, SubActivity.class);
            intent.putExtra("text",binding.editTextText.getText().toString());
            startActivity(intent);
        });
        /*
        binding.button5.setOnClickListener(view ->{
            var intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
            startActivity(intent);
        });

         */
        binding.button7.setOnClickListener(view ->{
            var intent = new Intent(this, SubActivity.class);
            getActivityResult.launch(intent);
        });
    }
}
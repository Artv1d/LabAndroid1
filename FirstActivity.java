import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class FirstActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    ActivityResultLauncher<Intent> getName = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            res -> {
                if (res.getResultCode() == RESULT_OK) {
                    Intent data = res.getData();
                    if (data != null) {
                        ((TextView)findViewById(R.id.textView)).setText("РџСЂРёРІРµС‚, " + data.getStringExtra("name") + "!");
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.mainButton).setOnClickListener(b -> {
            Intent intent = new Intent(this, SecondActivity.class);
            getName.launch(intent);
        });
    }
}

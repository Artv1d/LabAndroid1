import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.secondButton).setOnClickListener(b -> {
            Intent intent = new Intent();
            intent.putExtra("name", ((EditText)findViewById(R.id.editTextText)).getText().toString());
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}

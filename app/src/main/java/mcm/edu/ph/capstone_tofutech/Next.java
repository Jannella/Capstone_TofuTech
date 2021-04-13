package mcm.edu.ph.capstone_tofutech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Next extends AppCompatActivity implements View.OnClickListener {

    Button btnBck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        btnBck = findViewById(R.id.btnBck);
        btnBck.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBck:
                Intent home = new Intent(Next.this, MainActivity.class);
                startActivity(home);
                break;
        }
    }
}
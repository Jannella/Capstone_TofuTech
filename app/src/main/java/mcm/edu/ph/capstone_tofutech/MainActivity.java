package mcm.edu.ph.capstone_tofutech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(this);
    }
    public void onClick (View v){

        switch (v.getId()){
            case R.id.btn1:
                Intent next = new Intent(MainActivity.this, Scenarios.class);
                startActivity(next);
                break;

        }
    }
}
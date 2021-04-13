package mcm.edu.ph.capstone_tofutech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Fire extends AppCompatActivity implements View.OnClickListener {

    Button D1, D2;
    TextView txtQ, txtD1, txtD2;
    ImageView img;
    Intent intent;
    Bundle bundle;
    int scenarios = 0;
    int a = 0;
    int b, c, d, e, f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        D1 = findViewById(R.id.D1);
        D2 = findViewById(R.id.D2);
        txtQ = findViewById(R.id.txtF);
        txtD1 = findViewById(R.id.txtD1);
        txtD2 = findViewById(R.id.txtD2);
        img = findViewById(R.id.imgView);

        intent = getIntent();
        bundle = intent.getExtras();
        scenarios = intent.getIntExtra("SCENARIO3", 0);

        D1.setOnClickListener(this);
        D2.setOnClickListener(this);

        switch (scenarios) {
            case 3:
                String fire = bundle.getString("STRING_FIRE");
                String decF1 = bundle.getString("D1F");
                String decF2 = bundle.getString("D2F");
                txtQ.setText(fire);
                txtD1.setText(decF1);
                txtD2.setText(decF2);
                img.setImageResource(R.drawable.fscene1);
                break;
        }
    }
    public void onClick(View v) {

        Intent nextc = new Intent(Fire.this, Next.class);

        switch (v.getId()) {
            case R.id.D1:
            case R.id.D2:
                if (a > 0 && b > 0 && c > 0 && d > 0 && e > 0) {
                    f = 1;
                    break;
                }
                if (a > 0 && b > 0 && c > 0 && d > 0) {
                    e = 1;
                    break;
                }
                if (a > 0 && b > 0 && c > 0) {
                    d = 1;
                    break;
                }
                if (a > 0 && b > 0) {
                    c = 1;
                    break;
                }
                if (a > 0) {
                    b = 1;
                    break;
                }
                if (a == 0) {
                    a = 1;
                }
                break;
        }
        if (a == 1) {
            txtQ.setText("Nice! Now you've got your cloth wet. To check" +
                    "\nwhat is happening in the other room," +
                    "\ncheck first the doorknob if it’s hot or not." +
                    "\nHow do you check the doorknob?");
            txtD1.setText("Grab it");
            txtD2.setText("Gently touch it");
            img.setImageResource(R.drawable.fscene2);
            if (b == 1) {
                txtQ.setText("Great! The door knob isn’t hot now slowly" +
                        "\nopen the door to check where the fire is" +
                        "\ncoming from. It was coming from the kitchen!" +
                        "\nIt’s a small fire but slowly getting bigger." +
                        "\nHow can you stop the fire?");
                txtD1.setText("Use fire extinguisher");
                txtD2.setText("Blow it away");
                img.setImageResource(R.drawable.fscene3);
                if (c == 1) {
                    txtQ.setText("Good job! You got the fire extinguisher" +
                            "\nnow read the instructions to know how" +
                            "\nit works. What's the first steps" +
                            "\nyou’re going to do?");
                    txtD1.setText("Aim low, pull the pin");
                    txtD2.setText("Pull the pin, aim low");
                    img.setImageResource(R.drawable.fscene4);
                    if (d == 1) {
                        txtQ.setText("Nice you removed the pin and aimed low." +
                                "\nWhat’s next?");
                        txtD1.setText("Squeeze, then sweep");
                        txtD2.setText("Sweep, then squeeze");
                        img.setImageResource(R.drawable.fscene5);
                        if (e == 1) {
                            txtQ.setText("You did well! You have successfully put" +
                                    "\nout the fire from your kitchen. Now call" +
                                    "\nthe fire department and your parents, and" +
                                    "\ntell them what happened. Let them take" +
                                    "\ncare of the other steps to be done.");
                            txtD1.setText(" ");
                            txtD2.setText(" ");
                            img.setImageResource(R.drawable.fscene6);
                            if (f == 1) {
                                startActivity(nextc);
                            }
                        }
                    }
                }
            }
        }
    }
}


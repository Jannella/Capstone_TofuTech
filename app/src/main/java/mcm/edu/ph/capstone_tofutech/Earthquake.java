package mcm.edu.ph.capstone_tofutech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Earthquake extends AppCompatActivity implements View.OnClickListener {

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
        scenarios = intent.getIntExtra("SCENARIO1", 0);

        D1.setOnClickListener(this);
        D2.setOnClickListener(this);

        switch (scenarios) {
            case 1:
                String earthquake = bundle.getString("STRING_EARTHQUAKE");
                String decE1 = bundle.getString("D1E");
                String decE2 = bundle.getString("D2E");
                txtQ.setText(earthquake);
                txtD1.setText(decE1);
                txtD2.setText(decE2);
                img.setImageResource(R.drawable.escene1);
                break;
        }
    }

    public void onClick(View v) {

        Intent nexta = new Intent(Earthquake.this, Next.class);

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
            txtQ.setText("Nice job! You’re now under a table away from" +
                    "\nfalling objects. Now always practice Duck, Cover and" +
                    "\nHold where you sit over your head with a" +
                    "\nflat hard object to protect your head and hold." +
                    "\nYou’re looking for something to cover your head" +
                    "\nwhat are you going to use?");
            txtD1.setText("A paper");
            txtD2.setText("A book");
            img.setImageResource(R.drawable.escene2);
            if (b == 1) {
                txtQ.setText("Nice one! Always remember to cover your head" +
                        "\nat an earthquake situation to prevent injuries." +
                        "\nThe earthquake has stopped. It’s time to grab" +
                        "\nyour backpack, and bring the important things." +
                        "\nWhat should you bring?");
                txtD1.setText("Water & First Aid Kit");
                txtD2.setText("Your toys");
                img.setImageResource(R.drawable.escene3);
                if (c == 1) {
                    txtQ.setText("Nice! Now it is time for you to go" +
                            "\nsomewhere safe." +
                            "\nWhere should you go?");
                    txtD1.setText("Outside near the buildings");
                    txtD2.setText("Open area outside");
                    img.setImageResource(R.drawable.escene4);
                    if (d == 1) {
                        txtQ.setText("You’re on your way to go outside to an" +
                                "\nopen area. While you’re on your way, a" +
                                "\nsudden earthquake appear once again." +
                                "\nWhat are you going to do?");
                        txtD1.setText("Duck, Cover & Hold");
                        txtD2.setText("Keep on going");
                        img.setImageResource(R.drawable.escene5);
                        if (e == 1) {
                            txtQ.setText("Congratulations! You made it out safely." +
                                    "\nall you have to do is to wait for the" +
                                    "\nrescue teams. It will take a while for" +
                                    "\nthe rescue teams to arrive. Keep yourself" +
                                    "\nhydrated by always drinking your water, and just" +
                                    "\nstay calm as you wait.");
                            img.setImageResource(R.drawable.escene6);
                            txtD1.setText(" ");
                            txtD2.setText(" ");
                            if (f == 1) {
                                startActivity(nexta);
                            }
                        }
                    }
                }
            }
        }
    }
}
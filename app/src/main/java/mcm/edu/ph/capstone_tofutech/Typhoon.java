package mcm.edu.ph.capstone_tofutech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Typhoon extends AppCompatActivity implements View.OnClickListener {

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
        scenarios = intent.getIntExtra("SCENARIO2", 0);

        D1.setOnClickListener(this);
        D2.setOnClickListener(this);

        switch (scenarios) {
            case 2:
                String typhoon = bundle.getString("STRING_TYPHOON");
                String decT1 = bundle.getString("D1T");
                String decT2 = bundle.getString("D2T");
                txtQ.setText(typhoon);
                txtD1.setText(decT1);
                txtD2.setText(decT2);
                img.setImageResource(R.drawable.tscene1);
                break;
        }
    }
    public void onClick(View v) {

        Intent nextb = new Intent(Typhoon.this, Next.class);

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
            txtQ.setText("Nice, you found it! Now you can walk" +
                    "\naround the house and find something useful." +
                    "\nLet’s start by finding your backpack, first" +
                    "\naid kit, bottled water, and canned goods." +
                    "\nWhere do you find those things?");
            txtD1.setText("Kitchen");
            txtD2.setText("Bathroom");
            img.setImageResource(R.drawable.tscene2);
            if (b == 1) {
                txtQ.setText("Nice job! You’ve got your important stuff" +
                        "\nnow. While roaming around the house, you" +
                        "\nnoticed that the water is slowly rising." +
                        "\nWhat are going to do at this moment?\n");
                txtD1.setText("Play with the water");
                txtD2.setText("Turn off all electricity");
                img.setImageResource(R.drawable.tscene3);
                if (c == 1) {
                    txtQ.setText("Good! All electricity has been turned off." +
                            "\nThe water level has already covered your feet." +
                            "\nYou noticed that the water is dirty." +
                            "\nWhat should you wear?");
                    txtD1.setText("Boots & raincoat");
                    txtD2.setText("Favorite clothes");
                    img.setImageResource(R.drawable.tscene4);
                    if (d == 1) {
                        txtQ.setText("Great! Now you are protected from the dirty" +
                                "\nwaters. You stayed at the top of a table" +
                                "\nas the water is getting higher." +
                                "\nWhat should be your next move?");
                        txtD1.setText("Panic & scream" +
                                "\nfor help");
                        txtD2.setText("Get the phone & call" +
                                "\nthe rescue team");
                        img.setImageResource(R.drawable.tscene5);
                        if (e == 1) {
                            txtQ.setText("Nice one! You have called the rescue" +
                                    "\nteam, and they are on their way to" +
                                    "\nrescue you. While waiting you should stay" +
                                    "\ncalm, and stay away from the water as" +
                                    "\nmuch as possible.Just hold on there!");
                            txtD1.setText(" ");
                            txtD2.setText(" ");
                            img.setImageResource(R.drawable.tscene6);
                            if (f == 1) {
                                startActivity(nextb);
                            }
                        }
                    }
                }
            }
        }
    }
}

package mcm.edu.ph.capstone_tofutech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Scenarios extends AppCompatActivity implements View.OnClickListener {

    Button btnE, btnT, btnF;
    int scenarios = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenarios);

        btnE = findViewById(R.id.btnE);
        btnT = findViewById(R.id.btnT);
        btnF = findViewById(R.id.btnF);

        btnE.setOnClickListener(this);
        btnT.setOnClickListener(this);
        btnF.setOnClickListener(this);

    }
    public void onClick (View v){

        switch (v.getId()){
            case R.id.btnE:
                Intent eq = new Intent(Scenarios.this, Earthquake.class);
                scenarios = 1;
                String earthquake = "You are playing with your toys when a" +
                        "\nsudden earthquake hits your neighbourhood, and" +
                        "\nyou are close to the epicenter of the earthquake." +
                        "\nWhat are you going to do? ";
                String d1e = "Go under the table";
                String d2e = "Panic & cry";
                eq.putExtra("STRING_EARTHQUAKE", earthquake);
                eq.putExtra("D1E", d1e);
                eq.putExtra("D2E", d2e);
                eq.putExtra("SCENARIO1", scenarios);
                startActivity(eq);
                break;
            case R.id.btnT:
                Intent tp = new Intent(Scenarios.this, Typhoon.class);
                scenarios = 2;
                String typhoon = "You're alone at home, the typhoon had devastatedly" +
                        "\nhit the the electric line, and you can’t see" +
                        "\nanything. You need something in order to see" +
                        "\nWhat do you need to find?";
                String d1t = "Toys";
                String d2t = "Flashlight";
                tp.putExtra("STRING_TYPHOON", typhoon);
                tp.putExtra("D1T", d1t);
                tp.putExtra("D2T", d2t);
                tp.putExtra("SCENARIO2", scenarios);
                startActivity(tp);
                break;
            case R.id.btnF:
                Intent fr = new Intent(Scenarios.this, Fire.class);
                scenarios = 3;
                String fire = "You are home alone playing in your room" +
                        "\nwhen suddenly you noticed a smoke is coming" +
                        "\ninside your room. Remember to avoid suffocation," +
                        "\nyou need a wet cloth to cover your nose." +
                        "\nWhat are you supposed to do now?";
                String d1f = "Get some water &" +
                        "\n a cloth";
                String d2f = "Keep on playing";
                fr.putExtra("STRING_FIRE", fire);
                fr.putExtra("D1F", d1f);
                fr.putExtra("D2F", d2f);
                fr.putExtra("SCENARIO3", scenarios);
                startActivity(fr);
                break;

        }
    }
}

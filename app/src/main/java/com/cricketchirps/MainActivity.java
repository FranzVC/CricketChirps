package com.cricketchirps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_submit = findViewById(R.id.btn_submit);
        final RadioButton radioBtn_celsius = findViewById(R.id.radioBtn_celsius);
        final RadioButton radioBtn_fahrenheit = findViewById(R.id.radioBtn_fahrenheit);
        final TextView textView_temperature = findViewById(R.id.textView_temperature);
        final EditText txtBx_data = findViewById(R.id.txtBx_data);
        final Toast toast_fahrenheit = Toast.makeText(getApplicationContext(), R.string.toast_fahrenheitMessage, Toast.LENGTH_SHORT);
        final Toast toast_celsius = Toast.makeText(getApplicationContext(), R.string.toast_celsiusMessage, Toast.LENGTH_SHORT);

        radioBtn_celsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioBtn_fahrenheit.setChecked(false);
                toast_celsius.setGravity(Gravity.TOP, 0, 155);
                toast_celsius.show();
            }
        });

        radioBtn_fahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioBtn_celsius.setChecked(false);
                toast_fahrenheit.setGravity(Gravity.TOP, 0, 155);
                toast_fahrenheit.show();
            }
        });

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int chirpsNumber = Integer.parseInt(txtBx_data.getText().toString());
                String temperature;
                if (radioBtn_celsius.isChecked()) {
                    chirpsNumber = (chirpsNumber / 3) + 4;
                    temperature = chirpsNumber + "°C";
                    textView_temperature.setText(temperature);
                } else {
                    chirpsNumber = chirpsNumber + 40;
                    temperature = chirpsNumber + "°F";
                    textView_temperature.setText(temperature);
                }
            }
        });
    }


}

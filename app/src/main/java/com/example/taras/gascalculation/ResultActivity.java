package com.example.taras.gascalculation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Taras on 06.02.2018.
 */
//TODO start to create logic

public class ResultActivity extends AppCompatActivity {

    Button btn_back;
    Button btn_add;
    TextView txt_gasCalorific;
    TextView txt_gasDensity;
    TextView txt_TCofAir;
    TextView txt_normalRate;
    TextView txt_lowerFL;
    TextView txt_higherFL;
//    ArrayList <String> list;
    //GasDescription gasDescription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        txt_gasCalorific = (TextView) findViewById(R.id.gas_calorific_ID);
        txt_gasDensity = (TextView) findViewById(R.id.gas_density_ID);
        txt_TCofAir = (TextView) findViewById(R.id.gas_tcoAir_ID);
        txt_normalRate = (TextView) findViewById(R.id.gas_normalRate_ID);
        txt_lowerFL = (TextView) findViewById(R.id.gas_lowerFL_ID);
        txt_higherFL = (TextView) findViewById(R.id.gas_higherFT_ID);

        btn_back = (Button) findViewById(R.id.btn_back);
        btn_add = (Button) findViewById(R.id.btn_add);

//        list = (ArrayList<String>) getIntent().getSerializableExtra("gas_all");

        /*gasDescription = new GasDescription(Utils.getGasDescriptions(list.get(0)),
                Utils.getGasDescriptions(list.get(1)),
                Utils.getGasDescriptions(list.get(2)),
                Utils.getGasDescriptions(list.get(3)),Utils.getGasDescriptions(list.get(4)));*/
        //txt_gasCalorific.setText(Utils.getGasCalorificValue(gasDescription));

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMessage("FUCK!!!!!");
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toastMessage (String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}


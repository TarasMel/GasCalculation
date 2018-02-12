package com.example.taras.gascalculation;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    EditText editMethane;
    EditText editMonoxide;
    EditText editHydrogen;
    EditText editDioxide;
    EditText editNitrogen;
    Button btn_getResult;
    Button btn_Check;
    Button btn_about;

    ArrayList<String> listEntry;
//    GasDescription gasDescription;

//TODO в реализацию проверки чтобы общая сумма была ровно сто перевести все методи в классе Утилс в ГасДскриптион
//TODO Приложение валится при нажатии на кнопке результат
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editMethane = (EditText) findViewById(R.id.editMethane_ID);
        editMonoxide = (EditText) findViewById(R.id.editMonoxide_ID);
        editHydrogen = (EditText) findViewById(R.id.editHydrogen_ID);
        editDioxide = (EditText) findViewById(R.id.editDioxide_ID);
        editNitrogen = (EditText) findViewById(R.id.editNitrogen_ID);

        btn_about = (Button) findViewById(R.id.btn_About);
        btn_Check = (Button) findViewById(R.id.btn_Check);
        btn_getResult = (Button) findViewById(R.id.btn_getResult);
        //adding to list view
        listEntry = new ArrayList<>();
        listEntry.add(editMethane.toString());
        listEntry.add(editMonoxide.toString());
        listEntry.add(editHydrogen.toString());
        listEntry.add(editDioxide.toString());
        listEntry.add(editNitrogen.toString());
        //Creating obj gasDescription
/*        gasDescription = new GasDescription(Utils.getGasDescriptions(editMethane.toString()),
                Utils.getGasDescriptions(editMonoxide.toString()),
                Utils.getGasDescriptions(editHydrogen.toString()),
                Utils.getGasDescriptions(editDioxide.toString()),
                Utils.getGasDescriptions(editNitrogen.toString()));*/


        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();
                toastMessage(res.getString(R.string.for_btn_about));
            }
        });
        btn_Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /*if(gasDescription.checkingAdding(gasDescription))
                toastMessage("All good!!!You can get your result");
                else toastMessage("Incorrect entry of data, check your options," +
                        " because their amount should be 100 ");*/
                toastMessage("Lalalalalalalala");
            }
        });
        btn_getResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                //intent.putExtra("gas_all", listEntry);
                startActivity(intent);
            }
        });
    }


    private void toastMessage (String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}

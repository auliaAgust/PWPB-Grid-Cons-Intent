package com.example.intentapp2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btnMoveActivity, btnMoveWithDataActivity, btnMoveWithObject;
    Button btnDialNomor;
    Button btnMoveResult;
    TextView tvResult;

    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = (Button)findViewById(R.id.btn_move);
        btnMoveActivity.setOnClickListener(this);

        btnMoveWithDataActivity = (Button)findViewById(R.id.btn_move_data);
        btnMoveWithDataActivity.setOnClickListener(this);

        btnMoveWithObject = (Button) findViewById(R.id.btn_move_object);
        btnMoveWithObject.setOnClickListener(this);

        btnDialNomor = findViewById(R.id.btn_dial);
        btnDialNomor.setOnClickListener(this);

        btnMoveResult = findViewById(R.id.btn_move_result);
        btnMoveResult.setOnClickListener(this);

        tvResult = findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move:
                Intent moveIntent = new Intent(MainActivity.this, Move.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_data:
                Intent moveIntentData = new Intent(MainActivity.this, MoveWithData.class);
                moveIntentData.putExtra(MoveWithData.EXTRA_NAME, "Aulia Agustina");
                moveIntentData.putExtra(MoveWithData.EXTRA_AGE, 17);
                startActivity(moveIntentData);
                break;
            case R.id.btn_move_object:
                Person mPerson = new Person();
                mPerson.setName("Aulia Agustina");
                mPerson.setAge(17);
                mPerson.setEmail("auliaguss@gmail.com");
                mPerson.setCity("London");
                Intent moveIntentObj = new Intent(MainActivity.this, MoveWithObject.class);
                moveIntentObj.putExtra(MoveWithObject.EXTRA_PERSON, mPerson);
                startActivity(moveIntentObj);
                break;
            case R.id.btn_dial:
                Intent moveIntentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:082260794612"));
                startActivity(moveIntentDial);
                break;
            case R.id.btn_move_result:
                Intent movRes = new Intent(MainActivity.this, MoveForResult.class);
                startActivityForResult(movRes, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data){
        super.onActivityResult(reqCode, resCode, data);
        if(reqCode == REQUEST_CODE){
            if(resCode == MoveForResult.RESULT_CODE){
                int selectedVal = data.getIntExtra(MoveForResult.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedVal));
            }
        }
    }
}
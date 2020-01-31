package com.myproyect.tutoria_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.myproyect.tutoria_c.ui.CostosIndirectos;
import com.myproyect.tutoria_c.ui.ManoObra;
import com.myproyect.tutoria_c.ui.MateriaPrima;
import com.myproyect.tutoria_c.ui.Totales;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Paper.init(this);
        initComponents();
        setListener();
    }

    //initialize the components of the layout
    private void initComponents () {
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
    }

    private void setListener () {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = MateriaPrima.callingIntent(MainActivity.this);
                startActivity(intent);
                break;
            case R.id.button3:
                Intent intentCI = CostosIndirectos.callingIntent(MainActivity.this);
                startActivity(intentCI);
                break;
            default:
                break;
        }
    }
}

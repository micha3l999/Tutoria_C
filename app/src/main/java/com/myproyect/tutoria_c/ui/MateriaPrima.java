package com.myproyect.tutoria_c.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.myproyect.tutoria_c.Model.MateriaPrima.Material;
import com.myproyect.tutoria_c.R;

import java.util.ArrayList;

public class MateriaPrima extends AppCompatActivity implements View.OnClickListener {

    private EditText etName, etQuantity, etUnitPrice;
    private TextView tvTotalPrice, tvTotalMp;
    private Button btCalTotalPrice, btCalTotalMP, btAddMaterial;
    private ArrayList<Material> materiales = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_prima);
        initComponents();
        setListener();
    }

    /**
     * calling intent
     * @param context
     * @return
     */
    public static Intent callingIntent (final Context context) {
        Intent mIntent = new Intent(context, MateriaPrima.class);
        return mIntent;
    }

    /**
     * Initialize the components of the view
     */
    private void initComponents () {
        etName = findViewById(R.id.etNombre);
        etQuantity = findViewById(R.id.etQuantity);
        etUnitPrice = findViewById(R.id.etUnitPrice);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        btAddMaterial = findViewById(R.id.btAddMaterial);
        btCalTotalPrice = findViewById(R.id.btCalTotalPrice);
        btCalTotalMP = findViewById(R.id.btCalMP);
        tvTotalMp = findViewById(R.id.tvTotalMP);
    }

    private void setListener () {
        findViewById(R.id.etNombre).setOnClickListener(this);
        findViewById(R.id.etQuantity).setOnClickListener(this);
        findViewById(R.id.etUnitPrice).setOnClickListener(this);
        findViewById(R.id.btCalMP).setOnClickListener(this);
        findViewById(R.id.btAddMaterial).setOnClickListener(this);
        findViewById(R.id.btCalTotalPrice).setOnClickListener(this);
        findViewById(R.id.btReturnHome).setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        String sQuantity, sPrice, sName;
        float price = 0, total = 0, totalMP = 0;
        int quantity = 0;
        switch (v.getId()) {
            case R.id.btCalTotalPrice:
                //consigo los datos de los campos de ingreso y muestro el valor total de un material
                sQuantity = etQuantity.getText().toString();
                sPrice = etUnitPrice.getText().toString();
                if (!sQuantity.equals("") && !sPrice.equals("")) {
                    quantity = Integer.parseInt(sQuantity);
                    price = Float.parseFloat(sPrice);
                    total = quantity*price;
                }
                tvTotalPrice.setText(String.valueOf(total));
                break;
            case R.id.btAddMaterial:
                //consigo los datos de los campos de ingreso y guardo el material en una lista
                sQuantity = etQuantity.getText().toString();
                sPrice = etUnitPrice.getText().toString();
                if (!sQuantity.equals("") && !sPrice.equals("")) {
                    quantity = Integer.parseInt(sQuantity);
                    price = Float.parseFloat(sPrice);
                }

                total = quantity*price;
                sName = etName.getText().toString();
                Material material = new Material(sName, quantity, price, total);
                materiales.add(material);

                //borro los campos de ingreso para añadir nuevo material
                etQuantity.setText("");
                etName.setText("");
                etUnitPrice.setText("");
                tvTotalPrice.setText("");
                break;
            case R.id.btCalMP:
                sQuantity = etQuantity.getText().toString();
                sPrice = etUnitPrice.getText().toString();
                if (!sQuantity.equals("") && !sPrice.equals("")) {
                    quantity = Integer.parseInt(sQuantity);
                    price = Float.parseFloat(sPrice);
                    totalMP = quantity*price;
                }
                //se calcula el total de la materia prima recorriendo la lista de materiales
                for (int i = 0; i < materiales.size(); i++) {
                    totalMP = totalMP + materiales.get(i).getPrecioTotal();
                }
                tvTotalMp.setText(String.valueOf(totalMP));
            case R.id.btReturnHome:
                finish();
            default:
                break;
        }
    }
}

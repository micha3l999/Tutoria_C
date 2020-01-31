package com.myproyect.tutoria_c.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.myproyect.tutoria_c.Model.CostosIndirectos.CostosIndirectosModel;

import com.myproyect.tutoria_c.R;

public class CostosIndirectos extends AppCompatActivity implements View.OnClickListener {

    private static final String TEXT_CIF = "Total de los Costos Indirectos de fabricación: ";
    private EditText etRent, etServices, etInternet, etDepreciation, etGuard, etSecretary;
    private TextView tvCIF;
    private CostosIndirectosModel costosIndirectos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costos_indirectos);
        initComponents();
        setListener();
    }

    /**
     * calling intent el intent para invocar este activity
     * @param context activity que invocó este activity
     * @return el intent
     */
    public static Intent callingIntent (final Context context) {
        Intent mIntent = new Intent(context, CostosIndirectos.class);
        return mIntent;
    }

    /**
     * Inicializa los componentes del layout
     */
    private void initComponents() {
        etDepreciation = findViewById(R.id.etDepreciation);
        etRent = findViewById(R.id.etRent);
        etServices = findViewById(R.id.etServices);
        etGuard = findViewById(R.id.etGuard);
        etSecretary = findViewById(R.id.etSecretary);
        etInternet = findViewById(R.id.etInternet);
        tvCIF = findViewById(R.id.tvCIF);
    }

    /**
     * Inicializa el evento onClick
     */
    private void setListener() {
        findViewById(R.id.btCalCI).setOnClickListener(this);
        findViewById(R.id.btReturnHome).setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        String[] valuesToTransform = new String[6];
        switch (v.getId()) {
            case R.id.btCalCI:
                costosIndirectos = new CostosIndirectosModel();
                valuesToTransform[0] = etDepreciation.getText().toString().trim();
                valuesToTransform[1] = etRent.getText().toString().trim();
                valuesToTransform[2] = etServices.getText().toString().trim();
                valuesToTransform[3] = etGuard.getText().toString().trim();
                valuesToTransform[4] = etInternet.getText().toString().trim();
                valuesToTransform[5] = etSecretary.getText().toString().trim();

                float total = 0;

                for (int i=0; i<valuesToTransform.length; i++) {
                    if (!valuesToTransform[i].equals("")) {
                        total = total + Float.parseFloat(valuesToTransform[i]);
                    }
                }

                String cifResult = (String) TEXT_CIF + total;
                tvCIF.setText(cifResult);
                break;
            case R.id.btReturnHome:
                finish();
                break;

        }
    }
}

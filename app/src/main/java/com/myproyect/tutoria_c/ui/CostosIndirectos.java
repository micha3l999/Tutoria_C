package com.myproyect.tutoria_c.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.myproyect.tutoria_c.R;

public class CostosIndirectos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costos_indirectos);
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
}

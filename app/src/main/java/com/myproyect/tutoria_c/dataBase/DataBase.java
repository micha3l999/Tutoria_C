package com.myproyect.tutoria_c.dataBase;

import com.myproyect.tutoria_c.Model.CostosIndirectos.CostosIndirectosModel;
import com.myproyect.tutoria_c.Model.MateriaPrima.MateriaPrimaModel;

import io.paperdb.Paper;

public class DataBase {
    private static final String MATERIA_PRIMA = "materiaPrima";
    private static final String COSTOS_INDIRECTOS = "costosIndirectos";
    private DataBase () {}

    public static void saveMP(MateriaPrimaModel materiaPrima) {
        Paper.book().write(MATERIA_PRIMA, materiaPrima);
    }

    public static MateriaPrimaModel getMateriaPrima() {
        return Paper.book().read(MATERIA_PRIMA);
    }

    public static void saveCI(CostosIndirectosModel costosIndirectos) {
        Paper.book().write(COSTOS_INDIRECTOS, costosIndirectos);
    }

    public static CostosIndirectosModel getCI() {
        return Paper.book().read(COSTOS_INDIRECTOS);
    }
}

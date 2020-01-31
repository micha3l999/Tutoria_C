package com.myproyect.tutoria_c.Model.CostosIndirectos;

public class CostosIndirectosModel {

    private String[] costNames
            = {"Arriendos", "Servicios Básicos", "Internet", "Depreciación de maquinarias y equipos"
                , "Guardianía", "Secretaría"};
    private float[] costsValues;

    /**
     * Constructor
     */
    public CostosIndirectosModel() {
        costsValues = new float[6];
    }


    /**
     * set para los valores del array
     *
     * @param costsValue valor del costo
     * @param i iterador
     */
    public void setCostsValue(float costsValue, int i) {
        this.costsValues[i] = costsValue;
    }

    /**
     * get para los costos indirectos
     *
     * @param i iterador
     * @return el costo indirecto
     */
    public float getCostValue(final int i) {
        return costsValues[i];
    }
}

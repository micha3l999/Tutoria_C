package com.myproyect.tutoria_c.Model.MateriaPrima;

import android.os.Parcel;
import android.os.Parcelable;

public class Material implements Parcelable {
    private String nombre;
    private int unidades;
    private float precioUnitario;
    private float precioTotal;

    public Material (String nombre, int unidades, float precioUnitario, float precioTotal) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
    }

    protected Material(Parcel in) {
        nombre = in.readString();
        unidades = in.readInt();
        precioUnitario = in.readFloat();
        precioTotal = in.readFloat();
    }

    public static final Creator<Material> CREATOR = new Creator<Material>() {
        @Override
        public Material createFromParcel(Parcel in) {
            return new Material(in);
        }

        @Override
        public Material[] newArray(int size) {
            return new Material[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(nombre);
        dest.writeInt(unidades);
        dest.writeFloat(precioUnitario);
        dest.writeFloat(precioTotal);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getUnidades() {
        return unidades;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }
}

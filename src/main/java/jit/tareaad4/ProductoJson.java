package jit.tareaad4;

import java.io.Serializable;

public class ProductoJson implements Serializable { 

    private int idProducto;
    private int unidades;
    private int idTenda;

    public ProductoJson(int idProducto, int idTenda, int unidades) {
        this.idProducto = idProducto;
        this.unidades = unidades;
        this.idTenda = idTenda;
    }

    public ProductoJson() {
    }

}

package jit.tareaad4;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StockTendas")
public class StockTendas implements Serializable {

    @Id
    @Column(name = "idTenda")
    private int idTenda;
    @Id
    @Column(name = "idProducto")
    private int idProducto;
    @Column(name = "Cantidade")
    private int Cantidade;

    public StockTendas(int idTenda, int idProducto, int Cantidade) {
        this.idTenda = idTenda;
        this.idProducto = idProducto;
        this.Cantidade = Cantidade;
    }

    public StockTendas() {

    }

}

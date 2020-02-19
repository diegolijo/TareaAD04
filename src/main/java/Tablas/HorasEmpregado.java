package Tablas;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HorasEmpregado")
public class HorasEmpregado implements Serializable {

    @Id
    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEmpregado")
    private Empregado empregado;

    @Id
    @ManyToOne//(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idTenda")
    private Tenda tenda;

    @Column(name = "Horas")
    private int horas;

    public HorasEmpregado() {
    }

    public HorasEmpregado(Empregado empregado,Tenda tenda, int horas) {
        this.empregado = empregado;
        this.tenda = tenda;
        this.horas = horas;
    }    
    
    public Empregado getEmpregado() {
        return this.empregado;
    }

    public int getHoras() {
        return horas;
    }
    

}

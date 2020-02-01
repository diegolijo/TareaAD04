package Tablas;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import net.bytebuddy.implementation.ToStringMethod;

@Entity
@Table(name = "Provincia")
public class Provincia implements Serializable {

    @Id
    @Column(name = "idProvincia")
    private int id;
    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Tenda> tendas;

    public Provincia(int id, String nome) {
        this.id = id;
        this.nome = nome;
        //       this.tendas = new HashSet<>();
    }

    public Provincia() {
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        String provincia = id + "\t" + nome;
        return provincia;
    }

    public String getName() {
        return this.nome;
    }

}

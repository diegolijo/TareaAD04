package Tablas;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Tenda")
public class Tenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTenda;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cidade")
    private String cidade;
    @ManyToOne
    @JoinColumn(name = "idProvincia")
    private Provincia provincia;
    @OneToMany(mappedBy = "tenda", cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
    private Set<HorasEmpregado> horasEmpregado;

    public Tenda(String nome, String cidade, Provincia provincia) {
        this.nome = nome;
        this.cidade = cidade;
        this.provincia = provincia;
        this.horasEmpregado = new HashSet<>();
    }

    public void addHoras(HorasEmpregado e) {
        this.horasEmpregado.add(e);
    }

    @Override
    public String toString() {
        return this.idTenda + "\t" + this.nome + "\t" + this.cidade + "\t" + this.provincia + "\n";

    }

    public String getName() {
        return this.nome + " " + this.cidade;
    }

    public Tenda() {
    }

}

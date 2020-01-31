package jit.tareaad4;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Empregado")
public class Empregado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEmpregado;
    @Column(name = "nome")
    private String nome;
    @Column(name = "Apellidos")
    private String apellidos;
    @ManyToMany(cascade = {CascadeType.ALL},  fetch = FetchType.EAGER)
    @JoinTable(name = "HorasEmpleados", joinColumns = {
        @JoinColumn(name = "idEmpregado")}, inverseJoinColumns = {
        @JoinColumn(name = "IdTenda")})
    private Set<Tenda> tendasEmpregado;

    public Empregado(String nome, String Apellidos) {
        this.nome = nome;
        this.apellidos = Apellidos;
        this.tendasEmpregado = new HashSet<>();
    }

    public Empregado() {

    }

    public void addTenda(Tenda tenda) {
        this.tendasEmpregado.add(tenda);
    }

    String getName() {
        return this.nome + " " + this.apellidos;
    }

}

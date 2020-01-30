package jit.tareaad4;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Empregado")
public class Empregado implements Serializable {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "Apellidos")
    private String Apellidos;

    public Empregado(int id, String nome, String Apellidos) {
        this.id = id;
        this.nome = nome;
        this.Apellidos = Apellidos;
    }

    public Empregado() {

    }

}

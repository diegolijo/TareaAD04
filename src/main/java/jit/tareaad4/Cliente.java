package jit.tareaad4;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "email")
    private String email;

    public Cliente(int id, String nome, String apellidos, String email) {
        this.id = id;
        this.nome = nome;
        this.apellidos = apellidos;
        this.email = email;
    }

    public Cliente() {

    }

}

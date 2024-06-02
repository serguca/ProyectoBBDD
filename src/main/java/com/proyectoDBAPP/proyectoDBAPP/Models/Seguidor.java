package com.proyectoDBAPP.proyectoDBAPP.Models;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "seguidores")
public class Seguidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "seguidor_id", nullable = false)
    private Usuario seguidor;

    @ManyToOne
    @JoinColumn(name = "seguido_id", nullable = false)
    private Usuario seguido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getSeguidor() {
        return seguidor;
    }

    public void setSeguidor(Usuario seguidor) {
        this.seguidor = seguidor;
    }

    public Usuario getSeguido() {
        return seguido;
    }

    public void setSeguido(Usuario seguido) {
        this.seguido = seguido;
    }
    
}
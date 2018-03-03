package com.framework.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{

    private static final long serialVersionUID = 4934523415376474587L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="nome")
    private String nome;
    
   //@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="pedido")
   //private Set<Pedido> pedidos = new HashSet<Pedido>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    public Set<Pedido> getPedidos() {
//        return pedidos;
//    }
//
//    public void setPedidos(Set<Pedido> pedidos) {
//        this.pedidos = pedidos;
//    }
}
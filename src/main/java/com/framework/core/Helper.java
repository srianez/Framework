package com.framework.core;

import javax.persistence.EntityManager;

import com.framework.model.Cliente;
import com.framework.model.ItemPedido;
import com.framework.model.Pedido;

public class Helper {
	
	private EntityManager em;
	
	public Helper(EntityManager em){
		this.em = em;
	}
	
	public String salvarCliente(Cliente cliente) {
		try {
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			return "Cliente salvo";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String salvarPedido(Pedido pedido) {
		try {
			em.getTransaction().begin();
			em.persist(pedido);
			em.getTransaction().commit();
			return "Pedido salvo";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String salvarItemPedido(ItemPedido itemPedido) {
		try {
			em.getTransaction().begin();
			em.persist(itemPedido);
			em.getTransaction().commit();
			return "Item do pedido salvo";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
}

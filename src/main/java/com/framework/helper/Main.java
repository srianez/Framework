package com.framework.helper;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.framework.core.Helper;
import com.framework.core.JpaUtil;
import com.framework.cupomfiscal.GeraHash;
import com.framework.model.*;

public class Main {

	private EntityManager em;
	public Main(EntityManager em){
		this.em = em;
	}

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loja");
	    EntityManager em = entityManagerFactory.createEntityManager();
	    
	    LocalDateTime today = LocalDateTime.now();

		Helper dao = new Helper(em);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Silas");
		dao.salvarCliente(cliente);
		
		
	    Pedido pedido = new Pedido();	    
	    pedido.setCliente(cliente);
	    GeraHash gerahash = new GeraHash();
	    pedido.setHash(gerahash.hash());
	    pedido.setData(today);
	    pedido.setValor(10.98);
	    dao.salvarPedido(pedido);
	      
	    
	    ItemPedido itemPedido = new ItemPedido();
	    itemPedido.setCodigo(1);
	    itemPedido.setDescricao("Blusa");
	    itemPedido.setPedido(pedido);
	    itemPedido.setQuantidade(2);
	    itemPedido.setValorUnitario(10.00);
	    dao.salvarItemPedido(itemPedido);
	    
	    ItemPedido itemPedido2 = new ItemPedido();
	    itemPedido2.setCodigo(2);
	    itemPedido2.setDescricao("Bermuda");
	    itemPedido2.setPedido(pedido);
	    itemPedido2.setQuantidade(1);
	    itemPedido2.setValorUnitario(100.00);
	    dao.salvarItemPedido(itemPedido2);
	    	       
	}  

	
}

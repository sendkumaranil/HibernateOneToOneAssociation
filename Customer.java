package com.association.onetoone.annotation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="customer")
public class Customer {
	
	private int id;
	private String name;
	private String email;
	private String address;
	private MyTransaction transaction;
	
	@Id
	@Column(name="txn_id")
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen",strategy="foreign",parameters={@Parameter(name="property",value="transaction")})
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="cust_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="cust_email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="cust_address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@OneToOne
	@PrimaryKeyJoinColumn
	public MyTransaction getTransaction() {
		return transaction;
	}
	public void setTransaction(MyTransaction transaction) {
		this.transaction = transaction;
	}
	

}

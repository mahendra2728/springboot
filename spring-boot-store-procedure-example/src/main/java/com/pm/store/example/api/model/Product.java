package com.pm.store.example.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@NamedStoredProcedureQueries({
			   		@NamedStoredProcedureQuery(name = "getProducts", procedureName = "getProducts"),
			   		@NamedStoredProcedureQuery(name="getProductByName",procedureName ="getProductsByProductName", 
			   		  parameters = { @StoredProcedureParameter(mode = ParameterMode.IN,name = "pname",type =String.class)})
			   		})
public class Product {
	
	@Id 
	private int id;
	@Column(name = "product_name")
	private String product_name;
	private double price;
	private int qty;
	private int cust_id;
	
	
}

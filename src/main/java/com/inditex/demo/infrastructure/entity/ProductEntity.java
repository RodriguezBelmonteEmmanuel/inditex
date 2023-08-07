package com.inditex.demo.infrastructure.entity;

import java.util.List;

import com.inditex.demo.domain.model.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class ProductEntity {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private List<PriceListEntity> priceLists;
	
	public Product toDomain() {
		return new Product(this.id, this.name);
	}
	
}

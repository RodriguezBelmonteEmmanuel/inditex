package com.inditex.demo.infrastructure.entity;

import java.time.LocalDateTime;

import com.inditex.demo.domain.model.Currency;
import com.inditex.demo.domain.model.PriceList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="prices")
public class PriceListEntity {
	
	@Id
	@Column(name="id")
	private int id;
	
	@JoinColumn(name = "brand_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private BrandEntity brand;
	
	@Column(name="start_date")
	private LocalDateTime startDate;
	
	@Column(name="end_date")
	private LocalDateTime endDate;
	
	@JoinColumn(name = "product_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private ProductEntity product;
	
	@Column(name="priority")
	private int priority;
	
	@Column(name="price")
	private double price; 
	
	@Enumerated(EnumType.STRING)
	@Column(name="currency")
	private Currency currency;
	
	public PriceList toDomain() {
		return new PriceList(this.id, this.brand.toDomain(), this.startDate, this.endDate, this.product.toDomain(), this.priority, this.price, this.currency);
	}
	
}

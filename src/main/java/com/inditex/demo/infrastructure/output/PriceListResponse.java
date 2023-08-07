package com.inditex.demo.infrastructure.output;

import java.time.LocalDateTime;

import com.inditex.demo.domain.model.PriceList;

public record PriceListResponse(int brandId, int productId, LocalDateTime startDate, LocalDateTime endDate, double price) {

	public static PriceListResponse fromDomain(PriceList priceList) {
		return new PriceListResponse(priceList.brand().id(), priceList.product().id(), priceList.startDate(), priceList.endDate(), priceList.price());
	}
	
}

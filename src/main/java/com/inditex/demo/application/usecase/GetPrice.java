package com.inditex.demo.application.usecase;

import java.time.LocalDateTime;

import com.inditex.demo.domain.model.PriceList;
import com.inditex.demo.domain.port.out.GetPriceUserCase;
import com.inditex.demo.domain.port.out.PriceListRepositoryPort;

public class GetPrice implements GetPriceUserCase {

	private PriceListRepositoryPort priceListRepositoryPort;

	public GetPrice(PriceListRepositoryPort priceListRepositoryPort) {
		this.priceListRepositoryPort = priceListRepositoryPort;
	}
	
	@Override
	public PriceList get(int brandId, int productId, LocalDateTime dateTime) {
		return this.priceListRepositoryPort.get(productId, brandId, dateTime);
	}
	
	
	
}

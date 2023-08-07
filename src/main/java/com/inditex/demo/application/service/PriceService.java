package com.inditex.demo.application.service;

import java.time.LocalDateTime;

import com.inditex.demo.domain.model.PriceList;
import com.inditex.demo.domain.port.out.GetPriceUserCase;

public class PriceService implements GetPriceUserCase {

	private GetPriceUserCase getPrice;

	public PriceService(GetPriceUserCase getPrice) {
		this.getPrice = getPrice;
	}
	
	@Override
	public PriceList get(int brandId, int productId, LocalDateTime dateTime) {
		return getPrice.get(brandId, productId, dateTime);
	}

}

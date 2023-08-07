package com.inditex.demo.domain.port.out;

import java.time.LocalDateTime;

import com.inditex.demo.domain.model.PriceList;

public interface PriceListRepositoryPort {
	
	public PriceList get(int productId, int brandId, LocalDateTime dateTime);

}

package com.inditex.demo.domain.port.out;

import java.time.LocalDateTime;

import com.inditex.demo.domain.model.PriceList;

public interface GetPriceUserCase {
	
	public PriceList get(int brandId, int productId, LocalDateTime dateTime);

}

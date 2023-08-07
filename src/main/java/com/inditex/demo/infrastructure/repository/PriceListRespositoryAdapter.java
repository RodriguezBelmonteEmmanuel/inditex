package com.inditex.demo.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.inditex.demo.domain.model.PriceList;
import com.inditex.demo.domain.port.out.PriceListRepositoryPort;
import com.inditex.demo.infrastructure.entity.PriceListEntity;

public class PriceListRespositoryAdapter implements PriceListRepositoryPort {
	
	private PriceListRepository priceListRepository;
	
	public PriceListRespositoryAdapter(PriceListRepository priceListRepository) {
		this.priceListRepository = priceListRepository;
	}
	
	@Override
	public PriceList get(int productId, int brandId, LocalDateTime dateTime) {
		List<PriceListEntity> prices = priceListRepository.findAllByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(brandId, productId, dateTime, dateTime);
		return prices.size() != 0 ? prices.get(0).toDomain() : null;
	}

}

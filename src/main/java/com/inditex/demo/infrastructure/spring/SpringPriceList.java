package com.inditex.demo.infrastructure.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.demo.application.service.PriceService;
import com.inditex.demo.application.usecase.GetPrice;
import com.inditex.demo.domain.port.out.GetPriceUserCase;
import com.inditex.demo.domain.port.out.PriceListRepositoryPort;
import com.inditex.demo.infrastructure.repository.PriceListRepository;
import com.inditex.demo.infrastructure.repository.PriceListRespositoryAdapter;

@Configuration
public class SpringPriceList {

	@Bean
	public PriceService priceService(GetPriceUserCase getPrice) {
		return new PriceService(getPrice);
	}

	@Bean
	public GetPriceUserCase getPriceUserCase(PriceListRepositoryPort priceListRepositoryPort) {
		return new GetPrice(priceListRepositoryPort);
	}
	
	@Bean
	public PriceListRepositoryPort priceListRepositoryPort(PriceListRepository priceListRepository) {
		return new PriceListRespositoryAdapter(priceListRepository);
	}
	
}

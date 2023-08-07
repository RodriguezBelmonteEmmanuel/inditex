package com.inditex.demo.infrastructure.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.demo.application.service.PriceService;
import com.inditex.demo.infrastructure.output.PriceListResponse;


@RestController
public class PriceListController {

	private PriceService priceService;
	
	@Autowired
	public PriceListController(PriceService priceService) {
		this.priceService = priceService;
	}
	
	@GetMapping("/price/{brandId}/{productId}/{date}")
	public PriceListResponse getPrice(@PathVariable(name = "brandId") int brandId, @PathVariable(name = "productId") int productId, @PathVariable(name = "date") LocalDateTime date) {
		return PriceListResponse.fromDomain(priceService.get(brandId, productId, date));
	}
	
}

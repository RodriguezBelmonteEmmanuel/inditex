package com.inditex.demo.domain.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inditex.demo.infrastructure.controller.PriceListController;
import com.inditex.demo.infrastructure.output.PriceListResponse;

@SpringBootTest
class PriceListControllerTest {

	@Autowired
	private PriceListController priceListController;
	
	@Test
	void testCase1() {
		PriceListResponse priceList = priceListController.getPrice(1, 35455, LocalDateTime.of(2020, 6, 14, 10, 0));
		assertThat(priceList.brandId()).isEqualTo(1);
		assertThat(priceList.productId()).isEqualTo(35455);
		assertThat(priceList.startDate()).isEqualTo(LocalDateTime.of(2020, 6, 14, 0, 0));
		assertThat(priceList.endDate()).isEqualTo(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		assertThat(priceList.price()).isEqualTo(35.5);
	}
	
	@Test
	void testCase2() {
		PriceListResponse priceList = priceListController.getPrice(1, 35455, LocalDateTime.of(2020, 6, 14, 16, 0));
		assertThat(priceList.brandId()).isEqualTo(1);
		assertThat(priceList.productId()).isEqualTo(35455);
		assertThat(priceList.startDate()).isEqualTo(LocalDateTime.of(2020, 6, 14, 15, 0));
		assertThat(priceList.endDate()).isEqualTo(LocalDateTime.of(2020, 6, 14, 18, 30));
		assertThat(priceList.price()).isEqualTo(25.45);
	}
	
	@Test
	void testCase3() {
		PriceListResponse priceList = priceListController.getPrice(1, 35455, LocalDateTime.of(2020, 6, 14, 21, 0));
		assertThat(priceList.brandId()).isEqualTo(1);
		assertThat(priceList.productId()).isEqualTo(35455);
		assertThat(priceList.startDate()).isEqualTo(LocalDateTime.of(2020, 6, 14, 0, 0));
		assertThat(priceList.endDate()).isEqualTo(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		assertThat(priceList.price()).isEqualTo(35.5);
	}
	
	@Test
	void testCase4() {
		PriceListResponse priceList = priceListController.getPrice(1, 35455, LocalDateTime.of(2020, 6, 15, 10, 0));
		assertThat(priceList.brandId()).isEqualTo(1);
		assertThat(priceList.productId()).isEqualTo(35455);
		assertThat(priceList.startDate()).isEqualTo(LocalDateTime.of(2020, 6, 15, 0, 0));
		assertThat(priceList.endDate()).isEqualTo(LocalDateTime.of(2020, 6, 15, 11, 0));
		assertThat(priceList.price()).isEqualTo(30.5);
	}
	
	@Test
	void testCase5() {
		PriceListResponse priceList = priceListController.getPrice(1, 35455, LocalDateTime.of(2020, 6, 16, 21, 0));
		assertThat(priceList.brandId()).isEqualTo(1);
		assertThat(priceList.productId()).isEqualTo(35455);
		assertThat(priceList.startDate()).isEqualTo(LocalDateTime.of(2020, 6, 15, 16, 0));
		assertThat(priceList.endDate()).isEqualTo(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		assertThat(priceList.price()).isEqualTo(38.95);
	}
}

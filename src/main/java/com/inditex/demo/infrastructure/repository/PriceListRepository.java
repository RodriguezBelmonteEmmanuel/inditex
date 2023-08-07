package com.inditex.demo.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inditex.demo.infrastructure.entity.PriceListEntity;

public interface PriceListRepository extends JpaRepository<PriceListEntity, Integer> {

	List<PriceListEntity> findAllByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(int brandId, int productId, LocalDateTime startDate, LocalDateTime endDate);

}

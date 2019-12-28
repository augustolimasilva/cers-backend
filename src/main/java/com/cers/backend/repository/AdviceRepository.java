package com.cers.backend.repository;

import com.cers.backend.domain.Advice;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdviceRepository extends PagingAndSortingRepository<Advice, Long> {
}

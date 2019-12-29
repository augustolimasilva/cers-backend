package com.cers.backend.service;

import com.cers.backend.domain.Advice;
import com.cers.backend.util.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdviceService {

    Advice insertAdvice(Advice advice);

    Advice alterAdvice(Advice advice, Long id);

    Page<Advice> listAdvices(Pageable pageable);

    Response deleteById(Long id);

    Advice findById(Long id);
}

package com.cers.backend.service;

import com.cers.backend.domain.Advice;
import com.cers.backend.util.Response;

import java.util.List;

public interface AdviceService {

    Advice insertAdvice(Advice advice);

    Advice alterAdvice(Advice advice, Long id);

    List<Advice> listAdvices();

    Response deleteById(Long id);

    Advice findById(Long id);
}

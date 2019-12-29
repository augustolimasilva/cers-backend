package com.cers.backend.service.impl;

import com.cers.backend.domain.Advice;
import com.cers.backend.exception.CustomException;
import com.cers.backend.repository.AdviceRepository;
import com.cers.backend.service.AdviceService;
import com.cers.backend.util.Constantes;
import com.cers.backend.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.data.domain.Pageable;

@Service
public class AdviceServiceImpl implements AdviceService {

    @Autowired
    AdviceRepository adviceRepository;

    @Override
    public Advice insertAdvice(Advice advice) {
        Date date = new Date();
        advice.setDtPublication(date);
        return adviceRepository.save(advice);
    }

    @Override
    public Advice alterAdvice(Advice advice, Long id) {
        if(Objects.isNull(id)){
            throw new CustomException(Constantes.ID_REQUIRED);
        }

        Optional<Advice> adv = adviceRepository.findById(id);

        if(adv.isPresent()){
           Date date = new Date();
           advice.setDtPublication(adv.get().getDtPublication());
           advice.setDtVisualization(date);
           advice.setId(id);
           return adviceRepository.save(advice);
        }else{
            throw new CustomException(Constantes.ADVICE_NOT_FOUND);
        }
    }

    @Override
    public Page<Advice> listAdvices(Pageable pageable) {
        return (Page<Advice>) adviceRepository.findAll(pageable);
    }

    @Override
    public Response deleteById(Long id) {
        Optional<Advice> advice = adviceRepository.findById(id);

        if(advice.isPresent()){
            adviceRepository.deleteById(id);
            return new Response("sucesso", Constantes.DELETED_SUCCESSFUL);
        }else{
            throw new CustomException(Constantes.ADVICE_NOT_FOUND);
        }
    }

    @Override
    public Advice findById(Long id) {
        if(Objects.isNull(id)){
            throw new CustomException(Constantes.ID_REQUIRED);
        }

        return adviceRepository.findById(id).get();
    }
}
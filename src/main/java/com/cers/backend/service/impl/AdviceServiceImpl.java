package com.cers.backend.service.impl;

import com.cers.backend.domain.Advice;
import com.cers.backend.exception.CustomException;
import com.cers.backend.repository.AdviceRepository;
import com.cers.backend.service.AdviceService;
import com.cers.backend.util.Constantes;
import com.cers.backend.util.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AdviceServiceImpl implements AdviceService {

    @Autowired
    AdviceRepository adviceRepository;

    @Override
    public Advice insertAdvice(Advice advice) {
        return adviceRepository.save(advice);
    }

    @Override
    public Advice alterAdvice(Advice advice, Long id) {
        if(Objects.isNull(id)){
            throw new CustomException(Constantes.ID_REQUIRED);
        }

        Optional<Advice> adv = adviceRepository.findById(id);

        if(adv.isPresent()){
           adv.get().setId(id);
           return adviceRepository.save(adv.get());
        }else{
            throw new CustomException(Constantes.ADVICE_NOT_FOUND);
        }
    }

    @Override
    public List<Advice> listAdvice() {
        return (List<Advice>) adviceRepository.findAll();
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
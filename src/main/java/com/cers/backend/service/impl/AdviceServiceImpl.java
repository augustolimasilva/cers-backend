package com.cers.backend.service.impl;

import com.cers.backend.domain.Advice;
import com.cers.backend.exception.CustomException;
import com.cers.backend.repository.AdviceRepository;
import com.cers.backend.service.AdviceService;
import com.cers.backend.util.Constants;
import com.cers.backend.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
            throw new CustomException(Constants.ID_REQUIRED);
        }

        Optional<Advice> adv = adviceRepository.findById(id);

        if(adv.isPresent()){
           advice.setDtPublication(adv.get().getDtPublication());

           if(Objects.isNull(adv.get().getDtVisualization())){
               Date date = new Date();
               advice.setDtVisualization(date);
           }else{
                advice.setDtVisualization(adv.get().getDtVisualization());
           }
           advice.setId(id);
           return adviceRepository.save(advice);
        }else{
            throw new CustomException(Constants.ADVICE_NOT_FOUND);
        }
    }

    @Override
    public List<Advice> listAdvices() {
        return adviceRepository.findAll();
    }

    @Override
    public Response deleteById(Long id) {
        Optional<Advice> advice = adviceRepository.findById(id);

        if(advice.isPresent()){
            adviceRepository.deleteById(id);
            return new Response("sucesso", Constants.DELETED_SUCCESSFUL);
        }else{
            throw new CustomException(Constants.ADVICE_NOT_FOUND);
        }
    }

    @Override
    public Advice findById(Long id) {
        if(Objects.isNull(id)){
            throw new CustomException(Constants.ID_REQUIRED);
        }

        return adviceRepository.findById(id).get();
    }
}
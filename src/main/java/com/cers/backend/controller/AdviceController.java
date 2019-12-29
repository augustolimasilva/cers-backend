package com.cers.backend.controller;

import com.cers.backend.domain.Advice;
import com.cers.backend.domain.dto.AdviceDTO;
import com.cers.backend.service.AdviceService;
import com.cers.backend.util.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.data.domain.Pageable;
import java.util.List;

@CrossOrigin(origins =  "http://localhost:4200")
@RestController
@RequestMapping("/advice")
public class AdviceController {

    @Autowired
    AdviceService adviceService;

    @PostMapping
    public ResponseEntity<Advice> insertAdvice(@RequestBody @Valid AdviceDTO adviceDTO){
        Advice advice = new ModelMapper().map(adviceDTO, Advice.class);
        return new ResponseEntity<>(adviceService.insertAdvice(advice), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Advice> alterAdvice(@RequestBody @Valid AdviceDTO adviceDTO, @PathVariable Long id){
        Advice advice = new ModelMapper().map(adviceDTO, Advice.class);
        return new ResponseEntity<>(adviceService.alterAdvice(advice, id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Advice>> listAdvices(Pageable pageable){
        return new ResponseEntity<>(adviceService.listAdvices(pageable), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteById(@PathVariable Long id){
      return new ResponseEntity<>(adviceService.deleteById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advice> findById(@PathVariable Long id){
        return new ResponseEntity<>(adviceService.findById(id), HttpStatus.OK);
    }
}
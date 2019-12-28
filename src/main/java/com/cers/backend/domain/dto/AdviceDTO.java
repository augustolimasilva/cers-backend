package com.cers.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdviceDTO {

    @Length(min = 10, max = 200, message = "{advice.title.length}")
    private String title;

    @Length(min = 10, max = 200, message = "{advice.description.length}")
    private String description;
}
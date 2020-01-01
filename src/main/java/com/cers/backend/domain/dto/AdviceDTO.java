package com.cers.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdviceDTO {

    @Length(min = 10, max = 200, message = "{advice.title.length}")
    @NotNull(message = "{advice.title.notnull}")
    private String title;

    @Length(min = 10, max = 200, message = "{advice.description.length}")
    @NotNull(message = "{advice.description.notnull}")
    private String description;
}
package com.vertex.bootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslationPair {

    @NotNull(message = "wordFrom doesnt expect to be null")
    @NotBlank(message = "wordFrom doesnt expect to be empty")
    @Size(min = 3, message = "wordFrom expected to be at least 3 letters")
    private String wordFrom;
    private String wordTo;
    private Language langFrom;
    private Language langTo;
}

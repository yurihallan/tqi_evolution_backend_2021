package com.tqi.SCred_TQI.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String email;
    @NotEmpty
    @org.hibernate.validator.constraints.br.CPF
    private String CPF;
    @NotEmpty
    private String RG;
    @NotEmpty
    private String senha;
    @NotEmpty
    private Integer renda;

    @Valid
    @NotEmpty
    private List<EnderecoDTO> enderecos;

    @Valid
    @NotEmpty
    private List<EmprestimoDTO> emprestimos;

}

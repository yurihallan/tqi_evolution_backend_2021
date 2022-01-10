package com.tqi.SCred_TQI.DTO.request;

import com.sun.istack.NotNull;
import com.tqi.SCred_TQI.entity.Cliente;
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
public class EnderecoDTO {

    private Long id;
    @NotEmpty
    private String rua;
    @NotEmpty
    private String bairro;
    @NotEmpty
    private  String cidade;

    private List<Cliente> clientes;

}

package com.tqi.SCred_TQI.DTO.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoDTO {

    private Long id;

    @NotEmpty
    private Integer valor_emprestimo;
    @NotEmpty
    private LocalDate data_primeira_parcela;
    @NotEmpty
    private int  qtd_parcelas;
}

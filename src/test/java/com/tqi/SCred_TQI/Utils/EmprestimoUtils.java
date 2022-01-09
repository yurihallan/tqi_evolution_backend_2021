package com.tqi.SCred_TQI.Utils;

import com.tqi.SCred_TQI.DTO.request.EmprestimoDTO;
import com.tqi.SCred_TQI.entity.Emprestimo;

import java.time.LocalDate;

public class EmprestimoUtils {
    public static final long EMPRESTIMO_ID = 1L;
    public static final Integer VALOR_EMPRESTIMO = 1500;
    public static final LocalDate EMPRESTIMO_DATA_PRIMEIRO_PARCELA = LocalDate.now();
    public static final int EMPRESTIMO_QTD_PARCELAS = 20;


    public static EmprestimoDTO createFakeDTO(){
        return EmprestimoDTO.builder()
                .id(EMPRESTIMO_ID)
                .valor_emprestimo(VALOR_EMPRESTIMO)
                .data_primeira_parcela(EMPRESTIMO_DATA_PRIMEIRO_PARCELA)
                .qtd_parcelas(EMPRESTIMO_QTD_PARCELAS)
                .build();
    }

    public static Emprestimo createFakeEntity(){
        return Emprestimo.builder()
                .id(EMPRESTIMO_ID)
                .valor_emprestimo(VALOR_EMPRESTIMO)
                .data_primeira_parcela(EMPRESTIMO_DATA_PRIMEIRO_PARCELA)
                .qtd_parcelas(EMPRESTIMO_QTD_PARCELAS)
                .build();
    }
}

package com.tqi.SCred_TQI.Utils;

import com.tqi.SCred_TQI.DTO.request.EnderecoDTO;
import com.tqi.SCred_TQI.entity.Endereco;

public class EnderecoUtils {

    private static final String ENDERECO_RUA = "Rua libertador";
    private static final String ENDERECO_BAIRRO = "Parque 10";
    private static final String ENDERECO_CIDADE = "Manaus";
    public static final long ENDERECO_ID  = 1L;




    public static Endereco createFakeEntity(){
        return Endereco.builder()
                .id(ENDERECO_ID)
                .rua(ENDERECO_RUA)
                .bairro(ENDERECO_BAIRRO)
                .cidade(ENDERECO_CIDADE)
                .build();
    }
}

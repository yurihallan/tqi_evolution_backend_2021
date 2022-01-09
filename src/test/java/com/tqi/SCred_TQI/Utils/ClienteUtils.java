package com.tqi.SCred_TQI.Utils;

import com.tqi.SCred_TQI.DTO.request.ClienteDTO;
import com.tqi.SCred_TQI.entity.Cliente;

import java.util.Collections;

public class ClienteUtils {

    public static final long CLIENT_ID = 1L;
    public static final String CLIENT_NOME = "ROFRIGO";
    public static final String CLIENT_EMAIL = "rodrigo@gmail.com";
    public static final String CLIENT_CPF = "123.654.785-45";
    public static final String CLIENT_RG = "1234568";
    public static final String CLIENT_SENHA = "13245";
    public static final Integer CLIENT_RENDA = 2500;

    public static ClienteDTO createFakeDTO(){
        return ClienteDTO.builder()
                .id(CLIENT_ID)
                .nome(CLIENT_NOME)
                .email(CLIENT_EMAIL)
                .RG(CLIENT_RG)
                .senha(CLIENT_SENHA)
                .renda(CLIENT_RENDA)
                .CPF(CLIENT_CPF)
                .enderecos(Collections.singletonList(EnderecoUtils.createFakeDTO()))
                .emprestimos(Collections.singletonList(EmprestimoUtils.createFakeDTO()))
                .build();
    }

    public static Cliente createFakeEntity(){
        return Cliente.builder()
                .id(CLIENT_ID)
                .nome(CLIENT_NOME)
                .email(CLIENT_EMAIL)
                .RG(CLIENT_RG)
                .senha(CLIENT_SENHA)
                .renda(CLIENT_RENDA)
                .CPF(CLIENT_CPF)
                .enderecos(Collections.singletonList(EnderecoUtils.createFakeEntity()))
                .emprestimos(Collections.singletonList(EmprestimoUtils.createFakeEntity()))
                .build();
    }
}

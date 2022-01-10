package com.tqi.SCred_TQI.service;

import com.tqi.SCred_TQI.DTO.request.ClienteDTO;
import com.tqi.SCred_TQI.DTO.response.MessageResponseDTO;
import com.tqi.SCred_TQI.Utils.ClienteUtils;
import com.tqi.SCred_TQI.entity.Cliente;
import com.tqi.SCred_TQI.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class ClienteServiceTeste {
    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    void testGivenClientDTOthenRetunClient(){

        Cliente SavedCliente = ClienteUtils.createFakeEntity();

        Mockito.when(clienteRepository.save(any(Cliente.class))).thenReturn(SavedCliente);

        MessageResponseDTO expectedSuccessMessage = MessageResponseDTO.builder()
                .message("Cliente cadastrado com sucesso! -> id:" + SavedCliente.getId())
                .build();

        MessageResponseDTO successMessage = clientService.createClient(SavedCliente);


        assertEquals(expectedSuccessMessage, successMessage);
    }
}

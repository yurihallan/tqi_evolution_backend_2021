package com.tqi.SCred_TQI.service;

import com.tqi.SCred_TQI.DTO.request.ClienteDTO;
import com.tqi.SCred_TQI.DTO.response.MessageResponseDTO;
import com.tqi.SCred_TQI.entity.Cliente;

import com.tqi.SCred_TQI.exception.ClientNotFoundException;
import com.tqi.SCred_TQI.exception.LoanNotFoundException;
import com.tqi.SCred_TQI.mapper.ClienteMapper;
import com.tqi.SCred_TQI.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;



import java.util.List;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {

    private ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper = ClienteMapper.INSTANCE;

    public Cliente UserLogin(@RequestBody Cliente clienteLogin) throws ClientNotFoundException {
        Optional<Cliente> clienteOptional = clienteRepository.GetLogin(clienteLogin.getEmail(), clienteLogin.getSenha());

        return clienteOptional.orElseThrow(() -> new ClientNotFoundException("Cliente não foi encontrado!"));
    }

    public ResponseEntity changeClient(@PathVariable Long id, @RequestBody Cliente NewClient) {
        Optional<Cliente> oldClient = clienteRepository.findById(id);

        if (oldClient.isPresent()) {
            Cliente cliente = oldClient.get();
            cliente.setNome(NewClient.getNome());
            cliente.setEmail(NewClient.getEmail());
            cliente.setRG(NewClient.getRG());
            cliente.setCPF(NewClient.getCPF());
            cliente.setSenha(NewClient.getSenha());
            cliente.setRenda(NewClient.getRenda());


            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ClientNotFoundException("Cliente não foi encontrado!"), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> deleteClient(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            clienteRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(new ClientNotFoundException("Cliente não foi encontrado!"), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> findClientById(@PathVariable Long id) {
        Optional<Cliente> clientOptional = clienteRepository.findById(id);

        if (clientOptional.isPresent()) {
            return new ResponseEntity<>(clientOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ClientNotFoundException("Cliente não foi encontrado!"), HttpStatus.NOT_FOUND);
        }

    }

    public List<Cliente> listAllClient() {
        return clienteRepository.findAll();
    }

    public MessageResponseDTO createClient(@RequestBody ClienteDTO clienteDTO) {
        Cliente clienteToSave = clienteMapper.toModel(clienteDTO);

        Cliente saveCliente = clienteRepository.save(clienteToSave);
        return createMessageResponse(saveCliente.getId(), "Cliente criado com sucesso!");

    }


    public ResponseEntity GetLoanDetail(@PathVariable Long id) {
        Optional<Object> emprestimoOptional = clienteRepository.LoanDetail(id);

        if (emprestimoOptional.isPresent()) {
            return new ResponseEntity(emprestimoOptional, HttpStatus.OK);
        } else {
            return new ResponseEntity(new LoanNotFoundException("Detalhe do Emprestimo não foi encontrado!"), HttpStatus.NOT_FOUND);
        }
    }

    public MessageResponseDTO createMessageResponse(Long id, String s){
        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();
    }

}

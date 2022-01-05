package com.tqi.SCred_TQI.service;

import com.tqi.SCred_TQI.entity.Cliente;
import com.tqi.SCred_TQI.exception.ClientNotFoundException;
import com.tqi.SCred_TQI.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {

    private ClienteRepository clienteRepository;

    public Cliente UserLogin(@RequestBody Cliente clienteLogin) throws ClientNotFoundException {
        Optional<Cliente> clienteOptional = clienteRepository.GetLogin(clienteLogin.getEmail(), clienteLogin.getSenha());

        return clienteOptional.orElseThrow(() -> new ClientNotFoundException("Cliente não foi encontrado!"));
    }

    public ResponseEntity changeClient(@PathVariable Long id, @RequestBody Cliente NewClient) {
        Optional<Cliente> oldClient = clienteRepository.findById(id);

        if(oldClient.isPresent()){
            Cliente cliente = oldClient.get();
            cliente.setNome(NewClient.getNome());
            cliente.setEmail(NewClient.getEmail());
            cliente.setRG(NewClient.getRG());
            cliente.setCPF(NewClient.getCPF());
            cliente.setSenha(NewClient.getSenha());
            cliente.setRenda(NewClient.getRenda());



            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ClientNotFoundException("Cliente não foi encontrado!"),HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> deleteClient(@PathVariable Long id){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            clienteRepository.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> findClientById(@PathVariable Long id){
        Optional<Cliente> clientOptional = clienteRepository.findById(id);

        try {
            return new ResponseEntity<>(clientOptional.get(),HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(new ClientNotFoundException("Cliente não foi encontrado!"),HttpStatus.NOT_FOUND);
        }
    }
}

package com.tqi.SCred_TQI.controller;

import com.tqi.SCred_TQI.entity.Cliente;
import com.tqi.SCred_TQI.entity.Endereco;
import com.tqi.SCred_TQI.repository.ClienteRepository;
import com.tqi.SCred_TQI.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scred")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {

    private ClienteRepository clienteRepository;


    //metodo Get - Listando Todos os clientes
    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public List<Cliente> listAllClient(){
        return  clienteRepository.findAll();
    }

    //metodo Get - Listando um cliente pelo id
    @RequestMapping(value = "/cliente/{id}",method = RequestMethod.GET)
    public Cliente findClientById(@PathVariable Long id){
          Optional<Cliente> clientOptional = clienteRepository.findById(id);

          return clientOptional.orElseThrow(() -> new NoResultException("Client Not Found"));
    }

    //metodo Post - Cadastrando um cliente com seu endereço
    @RequestMapping(value = "/cliente", method = RequestMethod.POST)
    public Cliente createClient(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    //metodo Delete - Deletando um cliente
    @RequestMapping(value = "/cliente/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteClient(@PathVariable Long id){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            clienteRepository.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //metodo Put -Alterando um clientes e seu endereço
    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cliente> changeClient(@PathVariable Long id, @RequestBody Cliente NewClient){
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
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }


    }

}

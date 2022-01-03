package com.tqi.SCred_TQI.controller;

import com.tqi.SCred_TQI.entity.Endereco;
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
public class EnderecoController {

    private EnderecoRepository enderecoRepository;

    //metdoo Get - Listando Todos os endereços
    @RequestMapping(value = "/endereco", method = RequestMethod.GET)
    public List<Endereco> listAllAddress() {
        return enderecoRepository.findAll();
    }

    //metodo getById - Listando um endereço pelo id
    @RequestMapping(value = "/endereco/{id}", method = RequestMethod.GET)
    public Endereco findAddressById(@PathVariable Long id) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);

        return enderecoOptional.orElseThrow(() -> new NoResultException("Address not found!"));
    }

    //metodo Post - Cadastrando um endereço com seu endereço
    @RequestMapping(value = "/endereco", method = RequestMethod.POST)
    public Endereco createAddress(@RequestBody Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    //metodo Delete - Deletando um endereço
    @RequestMapping(value = "/endereco/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAddress(@PathVariable Long id) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isPresent()) {
            enderecoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //metodo Put - Alterando um endereço do cliente
    @RequestMapping(value = "/endereco/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Endereco> changeAddress(@PathVariable Long id, @RequestBody Endereco NewEndereco){
        Optional<Endereco> oldAddress = enderecoRepository.findById(id);

        if(oldAddress.isPresent()){
            Endereco endereco = oldAddress.get();
            endereco.setCidade(NewEndereco.getCidade());
            endereco.setBairro(NewEndereco.getBairro());
            endereco.setRua(NewEndereco.getRua());
            endereco.setCliente(NewEndereco.getCliente());
//            endereco.getCliente().get
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}



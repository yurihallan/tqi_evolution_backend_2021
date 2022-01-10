package com.tqi.SCred_TQI.controller;

import com.tqi.SCred_TQI.DTO.request.EnderecoDTO;
import com.tqi.SCred_TQI.entity.Endereco;
import com.tqi.SCred_TQI.exception.AddressNotFoundException;
import com.tqi.SCred_TQI.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/scred")
@AllArgsConstructor
public class EnderecoController {

    private EnderecoService enderecoService;

    //metdoo Get - Listando Todos os endereços
    @RequestMapping(value = "/endereco", method = RequestMethod.GET)
    public List<Endereco> listAllAddress() {
        return enderecoService.listAllAddress();
    }

    //metodo getById - Listando um endereço pelo id
    @RequestMapping(value = "/endereco/{id}", method = RequestMethod.GET)
    public Endereco findAddressById(@PathVariable Long id) throws AddressNotFoundException {

        return enderecoService.findAddressById(id);
    }

    //metodo Post - Cadastrando um endereço com seu endereço
    @RequestMapping(value = "/endereco", method = RequestMethod.POST)
    public Endereco createAddress(@RequestBody @Valid EnderecoDTO enderecoDTO) {
        return enderecoService.createAddress(enderecoDTO);
    }

    //metodo Delete - Deletando um endereço
    @RequestMapping(value = "/endereco/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAddress(@PathVariable Long id) {
        return enderecoService.deleteAddress(id);
    }


    //metodo Put - Alterando um endereço do cliente
    @RequestMapping(value = "/endereco/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Endereco> changeAddress(@PathVariable Long id, @RequestBody @Valid Endereco NewEndereco){
        return enderecoService.changeAddress(id, NewEndereco);
    }



}



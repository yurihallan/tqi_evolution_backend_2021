package com.tqi.SCred_TQI.service;

import com.tqi.SCred_TQI.entity.Endereco;
import com.tqi.SCred_TQI.exception.AddressNotFoundException;
import com.tqi.SCred_TQI.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public List<Endereco> listAllAddress(){
        return enderecoRepository.findAll();
    }

    public Endereco findAddressById(@PathVariable Long id) throws AddressNotFoundException {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);

        return enderecoOptional.orElseThrow(() -> new AddressNotFoundException("Endereco não foi encontrado!"));
    }

    public Endereco createAddress(@RequestBody Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public ResponseEntity<Object> deleteAddress(@PathVariable Long id){
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isPresent()) {
            enderecoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Endereco> changeAddress(@PathVariable Long id, @RequestBody Endereco NewEndereco){
        Optional<Endereco> oldAddress = enderecoRepository.findById(id);

        if(oldAddress.isPresent()){
            Endereco endereco = oldAddress.get();
            endereco.setCidade(NewEndereco.getCidade());
            endereco.setBairro(NewEndereco.getBairro());
            endereco.setRua(NewEndereco.getRua());
            endereco.setCliente(NewEndereco.getCliente());

            return new ResponseEntity<>(endereco, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

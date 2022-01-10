package com.tqi.SCred_TQI.controller;

import com.tqi.SCred_TQI.DTO.request.ClienteDTO;
import com.tqi.SCred_TQI.DTO.response.MessageResponseDTO;
import com.tqi.SCred_TQI.entity.Cliente;
import com.tqi.SCred_TQI.exception.ClientNotFoundException;
import com.tqi.SCred_TQI.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/scred")
@AllArgsConstructor
public class ClienteController {

    private ClientService clientService;


    //metodo Get - Listando Todos os clientes
    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public List<Cliente> listAllClient(){
        return  clientService.listAllClient();
    }

    //metodo Get - Listando um cliente pelo id
    @RequestMapping(value = "/cliente/{id}",method = RequestMethod.GET)
    public ResponseEntity<ClienteDTO> findClientById(@PathVariable Long id){

          return clientService.findClientById(id);
    }

    //metodo Post - Cadastrando um cliente com seu endereço
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/cliente", method = RequestMethod.POST)
    public MessageResponseDTO createClient(@RequestBody @Valid ClienteDTO clienteDTO){

//        return clientService.createClient(clienteDTO);
        return null;
    }

    //metodo Delete - Deletando um cliente
    @RequestMapping(value = "/cliente/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteClient(@PathVariable Long id){
        return clientService.deleteClient(id);
    }

    //metodo Put -Alterando um clientes e seu endereço
    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.PUT)
    public ResponseEntity changeClient(@PathVariable Long id, @RequestBody Cliente NewClient) {
        return clientService.changeClient(id, NewClient);
    }

    //Metodo Get -Listando um cliente e verificando seu email e a senha.
    @RequestMapping(value = "/cliente/UserLogin/",method = RequestMethod.GET)
    public Cliente UserLogin(@RequestBody Cliente clienteLogin) throws ClientNotFoundException {

        return clientService.UserLogin(clienteLogin);
    }


    //Metodo getLoadDetail - Detalhe do emprestimo por cliente
    @RequestMapping(value = "/emprestimo/detail/{id}",method = RequestMethod.GET)
    public ResponseEntity LoanDetail(@PathVariable Long id){
        return clientService.GetLoanDetail(id);
    }
}

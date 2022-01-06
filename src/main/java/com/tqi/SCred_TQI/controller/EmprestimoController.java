package com.tqi.SCred_TQI.controller;

import com.tqi.SCred_TQI.entity.Emprestimo;
import com.tqi.SCred_TQI.exception.LoanNotFoundException;
import com.tqi.SCred_TQI.repository.EmprestimoRepository;
import com.tqi.SCred_TQI.service.EmprestimoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scred")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmprestimoController {

    private EmprestimoService emprestimoService;

    //metodo Get - Listando todos os emprestimo;
    @RequestMapping(value = "/emprestimo", method = RequestMethod.GET)
    public List<Emprestimo> listAllLoan(){
        return emprestimoService.listAllLoan();
    }

    //metodo Get - Listando um emprestimo pelo id
    @RequestMapping(value = "/emprestimo/{id}",method = RequestMethod.GET)
    public Emprestimo findLoanById(@PathVariable Long id) throws LoanNotFoundException {

        return emprestimoService.findLoanById(id);
    }

    //Metodo Post - Cadastrando um emprestimo
    @RequestMapping(value = "/emprestimo", method = RequestMethod.POST)
    public ResponseEntity<Emprestimo> CreateLoan(@Valid @RequestBody Emprestimo NewEmprestimo){
        return emprestimoService.CreateLoan(NewEmprestimo);
    }

    //Metodo Delete - Deletando um emprestimo
    @RequestMapping(value = "/emprestimo", method = RequestMethod.DELETE)
    public ResponseEntity deleteLoan(@PathVariable Long id) {
        return emprestimoService.deleteLoan(id);
    }

    //metodo Put - Alterando um emprestimo
    @RequestMapping(value = "/emprestimo", method = RequestMethod.PUT)
    public ResponseEntity ChangeLoan(@PathVariable Long id, @RequestBody Emprestimo EmprestimoNew) {
       return emprestimoService.ChangeLoan(id, EmprestimoNew);
    }
}

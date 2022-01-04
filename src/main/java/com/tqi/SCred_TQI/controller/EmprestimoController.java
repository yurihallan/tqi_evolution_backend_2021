package com.tqi.SCred_TQI.controller;

import com.tqi.SCred_TQI.entity.Emprestimo;
import com.tqi.SCred_TQI.repository.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scred")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmprestimoController {

    private EmprestimoRepository emprestimoRepository;

    //metodo Get - Listando todos os emprestimo;
    @RequestMapping(value = "/emprestimo", method = RequestMethod.GET)
    public List<Emprestimo> listAllLoan(){
        return emprestimoRepository.findAll();
    }

    //metodo Get - Listando um emprestimo pelo id
    @RequestMapping(value = "/emprestimo/{id}",method = RequestMethod.GET)
    public Emprestimo findLoanById(@PathVariable Long id){
        Optional<Emprestimo> emprestimoOptional = emprestimoRepository.findById(id);

        return emprestimoOptional.orElseThrow(() -> new NoResultException("Loan Not Found"));
    }

    //Metodo Post - Cadastrando um emprestimo
    @RequestMapping(value = "/emprestimo", method = RequestMethod.POST)
    public ResponseEntity<Emprestimo> CreateLoan(@RequestBody Emprestimo emprestimo){
        LocalDate data_primeira_parcela = emprestimo.getData_primeira_parcela();
        LocalDate data_tres_meses = LocalDate.now().plusMonths(3);

        if((emprestimo.getQtd_parcelas() <= 60) && (data_primeira_parcela.compareTo(data_tres_meses) <= 0)){
            return new ResponseEntity<>(emprestimoRepository.save(emprestimo), HttpStatus.OK);
        }else {
            System.out.println("Emprestimo excedeu o limite permitido!");
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    //Metodo Delete - Deletando um emprestimo
    @RequestMapping(value = "/emprestimo", method = RequestMethod.DELETE)
    public ResponseEntity<Emprestimo> deleteLoan(@PathVariable Long id){
        Optional<Emprestimo> emprestimoOptional = emprestimoRepository.findById(id);
        if(emprestimoOptional.isPresent()){
            emprestimoRepository.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //metodo Put - Alterando um emprestimo
    @RequestMapping(value = "/emprestimo", method = RequestMethod.PUT)
    public ResponseEntity<Emprestimo> ChangeLoan(@PathVariable Long id, @RequestBody Emprestimo EmprestimoNew){
        Optional<Emprestimo> emprestimoOld = emprestimoRepository.findById(id);

        if(emprestimoOld.isPresent()){
            Emprestimo emprestimo = emprestimoOld.get();
            emprestimo.setValor_emprestimo(EmprestimoNew.getValor_emprestimo());
            emprestimo.setQtd_parcelas(EmprestimoNew.getQtd_parcelas());
            emprestimo.setData_primeira_parcela(EmprestimoNew.getData_primeira_parcela());
            return new ResponseEntity<>(emprestimo, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
